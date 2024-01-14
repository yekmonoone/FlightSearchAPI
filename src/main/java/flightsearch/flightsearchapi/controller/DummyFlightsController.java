package flightsearch.flightsearchapi.controller;

import flightsearch.flightsearchapi.dto.FlightDto;
import flightsearch.flightsearchapi.entity.Airport;
import flightsearch.flightsearchapi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/dummy")
public class DummyFlightsController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/data")
    List<FlightDto> getDummyData() {
        List<FlightDto> dummyFlights = new ArrayList<FlightDto>();
        List<Airport> allAirports = airportService.getAllAirports();
        Random rd = new Random();

        for (int i = 0; i < 10; i++) {
            FlightDto dummyFlightDto = new FlightDto();

            Collections.shuffle(allAirports);

            Airport departureAirport = allAirports.get(0);
            Airport arrivalAirport = allAirports.get(1);

            dummyFlightDto.setDepartureAirport(departureAirport);
            dummyFlightDto.setArrivalAirport(arrivalAirport);

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime departureDateTime = now.plusDays(rd.nextInt(10)).plusHours(rd.nextInt(5)).plusMinutes(rd.nextInt(5)).withSecond(0).withNano(0);

            dummyFlightDto.setDepartureDateTime(departureDateTime);

            int forArrivalProbability = rd.nextInt(2);

            if (forArrivalProbability == 1) {
                LocalDateTime returnDateTime = departureDateTime.plusDays(rd.nextInt(10)).plusHours(rd.nextInt(5)).plusMinutes(rd.nextInt(5)).withSecond(0).withNano(0);
                dummyFlightDto.setArrivalDateTime(returnDateTime);
            }

            dummyFlightDto.setPrice(rd.nextInt(1, 1000));
            dummyFlights.add(dummyFlightDto);
        }

        return dummyFlights;
    }
}