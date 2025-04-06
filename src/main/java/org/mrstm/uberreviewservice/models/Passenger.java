package org.mrstm.uberreviewservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel{
    private String passangerName;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>();

}
