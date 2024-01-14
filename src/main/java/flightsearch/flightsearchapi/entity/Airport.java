package flightsearch.flightsearchapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "airports")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "departureAirportObj")
    private List<Flight> flights;

}