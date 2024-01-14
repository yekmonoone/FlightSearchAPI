package flightsearch.flightsearchapi.service;


import flightsearch.flightsearchapi.entity.Airport;
import flightsearch.flightsearchapi.repository.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
    @Autowired
    private AirportRepo airportRepo;

    public List<Airport> getAllAirports() {
        return airportRepo.findAll();
    }

    public Optional<Airport> getAirportById(Long id) {
        return airportRepo.findById(id);
    }

    public Airport createAirport(Airport airport) {
        return airportRepo.save(airport);
    }

    public Airport updateAirport(Long id, Airport airportDetails) {
        Airport airport = airportRepo.findById(id).orElse(null);
        if (airport != null) {
            airport.setCity(airportDetails.getCity());

            return airportRepo.save(airport);
        }
        return null;
    }

    public void deleteAirport(Long id) {
        airportRepo.deleteById(id);
    }
}