package org.mrstm.uberreviewservice.services;

import org.mrstm.uberreviewservice.models.Booking;
import org.mrstm.uberreviewservice.models.Driver;
import org.mrstm.uberreviewservice.models.Review;
import org.mrstm.uberreviewservice.repositories.BookingRepository;
import org.mrstm.uberreviewservice.repositories.DriverRepository;
import org.mrstm.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World... Preparing DB queries...");
        Review review = Review.builder()
                .content("Good rider")
                .rating(5.0)
//                .updatedAt(new Date())
//                .createdAt(new Date())
                .build(); //code to create java object.

        Booking booking = Booking.builder()
                        .endTime(new Date())
                                .review(review)
                                        .build();

        bookingRepository.save(booking);
        reviewRepository.save(review); //this code executes db query...
        /*
        Questionn is which one is to be created first????
        currently putting booking before review..
        this give errors...
        as this object is created in java not in mysql.
        And if we remove .review from the booking it will work
        solution1: save review first then booking...
        solution2: add cascade mechanism in booking classs
         */

        Optional<Driver> driver = driverRepository.hqlFindByIdAndLicense(2L,"UP123");



        if(driver.isPresent()) {
            System.out.println(driver.get().getFullName());
//            List<Booking> bookings = driver.get().getBookings();
//            for (Booking booking1 : bookings) {
//                System.out.println(booking1.getBookingStatus());
//            }
        }
//        List<Review> reviews = reviewRepository.findAll();
//        for (Review r : reviews) {
//            System.out.println(r.getContent());
//        }
    }
}
