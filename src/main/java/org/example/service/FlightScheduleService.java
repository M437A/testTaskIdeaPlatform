package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Request.Flights;
import org.example.entity.Request.FlightRequest;
import org.example.entity.Request.WeatherData;
import org.example.entity.Response.FlightResponse;
import org.example.entity.Response.Schedule;
import org.example.exception.IncorrectCityException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightScheduleService {

    @Value("${service.flight-schedule.max-wind}")
    private int MAX_WIND;

    @Value("${service.flight-schedule.min-visibility}")
    private int MIN_VISIBILITY;

    @Value("${service.flight-schedule.positive-message}")
    private String POSITIVE_MESSAGE;

    @Value("${service.flight-schedule.negative-message}")
    private String NEGATIVE_MESSAGE;

    public FlightResponse getFlightSchedule(final FlightRequest flightRequest) {
        final List<Flights> requestFlights = flightRequest.getFlights();
        final Map<String, List<WeatherData>> forecast = flightRequest.getForecast();
        List<Schedule> schedules = new ArrayList<>();

        for (Flights flight : requestFlights) {
            String status = getStatus(flight, forecast);

            schedules.add(new Schedule().builder()
                    .no(flight.getNo())
                    .from(flight.getFrom())
                    .to(flight.getTo())
                    .status(status)
                    .build());

            log.info(String.format("%s | %s -> %s | %s", flight.getNo(), flight.getFrom(), flight.getTo(), status));
        }
        return new FlightResponse().builder()
                .schedules(schedules)
                .build();
    }

    private String getStatus(final Flights flight, final Map<String, List<WeatherData>> forecast) {
        String cityFrom = flight.getFrom();
        int timeCityFrom = flight.getDeparture();
        WeatherData weatherDataFrom = forecast.get(cityFrom).get(timeCityFrom);

        String cityTo = flight.getTo();
        int timeDifference = getTimeDifference(flight.getFrom(), flight.getTo());
        int timeCityTo = formatTime(timeCityFrom + timeDifference+flight.getDuration());
        WeatherData weatherDataTo = forecast.get(cityTo).get(timeCityTo);

        if (isAvailableToFly(weatherDataFrom) && isAvailableToFly(weatherDataTo)) {
            return POSITIVE_MESSAGE;
        } else {
            return NEGATIVE_MESSAGE;
        }
    }
    private boolean isAvailableToFly(final WeatherData weatherData) {
        final int wind = weatherData.getWind();
        final int visibility = weatherData.getVisibility();
        return wind <= MAX_WIND && visibility >= MIN_VISIBILITY;
    }

    public static int formatTime(int time) {
        int formattedTime = time % 24;
        if (formattedTime < 0) {
            formattedTime += 24;
        }
        return formattedTime;
    }

    private int getTimeDifference(String cityFrom, String cityTo) {
        String timeZoneCityFrom = getCorrectTimeZoneFormat(cityFrom);
        String timeZoneCityTo = getCorrectTimeZoneFormat(cityTo);

        long offsetCityFrom = TimeZone.getTimeZone(timeZoneCityFrom).getRawOffset();
        long offsetCityTo = TimeZone.getTimeZone(timeZoneCityTo).getRawOffset();

        return (int) ((offsetCityTo - offsetCityFrom) / (1000 * 60 * 60));
    }

    private String getCorrectTimeZoneFormat(String cityName) {
        String[] availableIds = TimeZone.getAvailableIDs();

        for (String id : availableIds) {
            if (id.toLowerCase().contains(cityName.toLowerCase())) {
                return id;
            }
        }

        throw new IncorrectCityException();
    }
}
