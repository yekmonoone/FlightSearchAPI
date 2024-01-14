package flightsearch.flightsearchapi.repository;

import flightsearch.flightsearchapi.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight, Long> {
}
