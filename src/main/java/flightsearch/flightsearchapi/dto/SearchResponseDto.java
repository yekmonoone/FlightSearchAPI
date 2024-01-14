package flightsearch.flightsearchapi.dto;

import flightsearch.flightsearchapi.entity.Airport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchResponseDto {
    private Airport departureAirport;

    private Airport arrivalAirport;

    private LocalDateTime flightDateTime;
}
