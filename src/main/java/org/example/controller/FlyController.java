package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Request.FlightRequest;
import org.example.entity.Response.FlightResponse;
import org.example.service.FlightScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping(value = FlyController.URL)
public class FlyController {

    public static final String URL = "/api";

    private final FlightScheduleService flightScheduleService;

    @GetMapping
    public ResponseEntity<FlightResponse> getFlights(@RequestBody final FlightRequest flightRequest) {
        log.info("Get request to check flights");
        FlightResponse flightResponse = flightScheduleService.getFlightSchedule(flightRequest);
        log.info("Created schedule was successful");
        return ResponseEntity.ok(flightResponse);
    }
}
