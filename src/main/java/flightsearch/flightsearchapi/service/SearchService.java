package flightsearch.flightsearchapi.service;

import flightsearch.flightsearchapi.dto.SearchResponseDto;
import flightsearch.flightsearchapi.entity.Flight;
import flightsearch.flightsearchapi.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    private FlightRepo flightRepository;

    public List<SearchResponseDto> searchFlights(Integer arrivalAirportId, Integer departureAirportId, LocalDateTime departureDateTime, LocalDateTime returnDateTime) {
        List<Flight> flights = flightRepository.searchFlightsByArrivalAirportId(arrivalAirportId, departureAirportId, departureDateTime, returnDateTime);

        List<SearchResponseDto> resultFlight = new ArrayList<SearchResponseDto>();

        for (Flight flight : flights) {
            SearchResponseDto tempSearchResponseDto = new SearchResponseDto();
            tempSearchResponseDto.setArrivalAirport(flight.getArrivalAirport());
            tempSearchResponseDto.setDepartureAirport(flight.getDepartureAirport());
            tempSearchResponseDto.setFlightDateTime(flight.getDepartureDateTime());

            resultFlight.add(tempSearchResponseDto);

            if (flight.getArrivalDate() != null) {
                SearchResponseDto tempSearchResponseDto2 = new SearchResponseDto();
                tempSearchResponseDto2.setArrivalAirport(flight.getDepartureAirport());
                tempSearchResponseDto2.setDepartureAirport(flight.getArrivalAirport());
                tempSearchResponseDto2.setFlightDateTime(flight.getArrivalDate());

                resultFlight.add(tempSearchResponseDto2);

            }
        }

        return resultFlight;
    }
}
