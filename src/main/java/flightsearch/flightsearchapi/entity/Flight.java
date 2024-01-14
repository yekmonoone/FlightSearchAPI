package flightsearch.flightsearchapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "flights")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    private LocalDateTime departureDate;

    @Column(nullable = true)
    private LocalDateTime arrivalDate;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport departureAirportObj;



}
