package org.mrstm.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "passangerReviewId")
public class PassangerReview extends Review {

    @Column(nullable = false)
    private String passangerReviewContent;
    private String passangerRating;
}
