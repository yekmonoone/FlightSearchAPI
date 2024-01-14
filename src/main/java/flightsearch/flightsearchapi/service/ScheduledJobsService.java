package flightsearch.flightsearchapi.service;

import java.util.Arrays;

import flightsearch.flightsearchapi.dto.FlightDto;
import flightsearch.flightsearchapi.entity.Flight;
import flightsearch.flightsearchapi.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ScheduledJobsService {

    @Autowired
    private FlightRepo flightRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "0 0 12 * * *")
    public void fetchFlights() {
        String apiUrl = "http://localhost:8080/dummy/data";

        FlightDto[] dummyFlights = restTemplate.getForObject(apiUrl, FlightDto[].class);



        if (dummyFlights != null) {
            Flight[] finalFlights = new Flight[dummyFlights.length];
            for (int i = 0; i < dummyFlights.length; i++) {
                Flight tempFlight = new Flight();

                tempFlight.setDepartureAirport(dummyFlights[i].getDepartureAirport());
                tempFlight.setDepartureDate(dummyFlights[i].getDepartureDateTime());
                tempFlight.setArrivalAirport(dummyFlights[i].getArrivalAirport());
                tempFlight.setArrivalDate(dummyFlights[i].getArrivalDateTime());
                tempFlight.setPrice(dummyFlights[i].getPrice());

                finalFlights[i] = tempFlight;
            }

            flightRepository.saveAll(Arrays.asList(finalFlights));
        }
    }
}