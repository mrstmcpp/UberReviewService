package org.mrstm.uberreviewservice.services;

import org.mrstm.uberreviewservice.models.Review;
import org.mrstm.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
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

        reviewRepository.save(review); //this code executes db query...

//        List<Review> reviews = reviewRepository.findAll();
//        for (Review r : reviews) {
//            System.out.println(r.getContent());
//        }
    }
}
