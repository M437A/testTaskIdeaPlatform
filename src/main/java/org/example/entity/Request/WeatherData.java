package org.example.entity.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {

    @NotNull
    private int time;

    @NotNull
    private int wind;

    @NotNull
    private int visibility;
}
