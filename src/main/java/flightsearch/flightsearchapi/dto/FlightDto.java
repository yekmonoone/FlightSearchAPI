package flightsearch.flightsearchapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightDto {

    private Long id;
    private String departureAirport;
    private String arrivalAirport;
    private Date departureDate;
    private Date arrivalDate;
    private double price;

}
