package flightsearch.flightsearchapi.repository;

import flightsearch.flightsearchapi.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport, Long> {
}
