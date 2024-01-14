package flightsearch.flightsearchapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import flightsearch.flightsearchapi.service.ScheduledJobsService;

@RestController
public class ScheduledJobsController {
    @Autowired
    private ScheduledJobsService scheduledJobsService;

    @GetMapping("/startFlightFetchJob")
    public String startFlightFetchJob() {
        scheduledJobsService.fetchFlights();
        return "Job started";
    }
}