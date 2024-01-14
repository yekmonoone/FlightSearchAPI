package flightsearch.flightsearchapi.controller;

import flightsearch.flightsearchapi.entity.Flight;
import flightsearch.flightsearchapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/{id}")
    public Optional<Flight> getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        return flightService.updateFlight(id, flightDetails);
    }
}
