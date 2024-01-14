package flightsearch.flightsearchapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "dep_airport")
    private String departureAirport;

    @Column(name = "arr_airport")
    private String arrivalAirport;

    @Column(name = "dep_date")
    private Date departureDate;

    @Column(name = "arr_date")
    private Date arrivalDate;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport departureAirportObj;
}
