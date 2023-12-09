package projectuas.bookingticketmovie.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "auditorium")
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer studio;

    @Column(nullable = false)
    private Integer seatCount;

    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Seat> seats;

    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Screening> screenings;
}
