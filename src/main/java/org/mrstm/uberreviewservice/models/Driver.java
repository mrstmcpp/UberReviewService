package org.mrstm.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Driver extends BaseModel {
    private String fullName;

    @Column(unique = true , nullable = false)
    private String licenseNumber;

    // 1 to many : Driver : Booking
    /*
    since here we mentioned onetomany -> then in booking class
    we have to mention manytoone above driver

    Just normal onetomany annotations creates an extra tables
    named driver_bookings which is a mistake of spring
    so we use mappedby -> driver word came from the booking.java class
     */
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings = new ArrayList<>();
}
