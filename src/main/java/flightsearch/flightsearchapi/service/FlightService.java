package flightsearch.flightsearchapi.service;

import flightsearch.flightsearchapi.entity.Flight;
import flightsearch.flightsearchapi.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepo flightRepo;

    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepo.findById(id);
    }

    public Flight createFlight(Flight flight) {
        return flightRepo.save(flight);
    }

    public Flight updateFlight(Long id, Flight flightDetails) {
        Flight flight = flightRepo.findById(id).orElse(null);
        if (flight != null) {
            flight.setDepartureAirport(flightDetails.getDepartureAirport());
            flight.setArrivalAirport(flightDetails.getArrivalAirport());
            flight.setDepartureDate(flightDetails.getDepartureDate());
            flight.setArrivalDate(flightDetails.getArrivalDate());
            flight.setPrice(flightDetails.getPrice());

            return flightRepo.save(flight);
        }
        return null;
    }

    public void deleteFlight(Long id) {
        flightRepo.deleteById(id);
    }
}