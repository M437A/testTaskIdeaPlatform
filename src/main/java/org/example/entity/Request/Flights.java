package org.example.entity.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flights {

    @NotBlank(message = "No cannot be blank")
    private String no;

    @NotNull(message = "Departure cannot be null")
    private int departure;

    @NotBlank(message = "From cannot be blank")
    private String from;

    @NotBlank(message = "To cannot be blank")
    private String to;

    @NotNull(message = "Duration cannot be null")
    private int duration;
}
