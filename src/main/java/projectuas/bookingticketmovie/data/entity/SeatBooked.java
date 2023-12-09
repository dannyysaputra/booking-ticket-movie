package projectuas.bookingticketmovie.data.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seat_booked")
public class SeatBooked {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_booked_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    @JsonManagedReference
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonManagedReference
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    @JsonManagedReference
    private Screening screening;
}
