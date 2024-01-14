package flightsearch.flightsearchapi.repository;

import flightsearch.flightsearchapi.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepo extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f " +
            "WHERE (:arrivalId IS NULL OR f.arrivalAirport.id = :arrivalId) " +
            "AND (:departureId IS NULL OR f.departureAirport.id = :departureId) " +
            "AND (:departureDateTime IS NULL OR f.departureDate = :departureDateTime) " +
            "AND (:returnDateTime IS NULL OR f.arrivalDate = :returnDateTime) "
    )
    List<Flight> searchFlightsByArrivalAirportId(
            @Param("arrivalId") Integer arrivalId,
            @Param("departureId") Integer departureId,
            @Param("departureDateTime") LocalDateTime departureDateTime,
            @Param("returnDateTime") LocalDateTime returnDateTime
    );
}
