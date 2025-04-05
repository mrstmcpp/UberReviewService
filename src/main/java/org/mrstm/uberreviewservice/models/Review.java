package org.mrstm.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;



@Entity
@Getter
@Setter
@Builder //implements builder design pattern
@AllArgsConstructor //create constructor with all arguments
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) //is a JPA annotation that lets you hook into the lifecycle of an entity—things like when it's created, updated, or deleted—by registering a listener class to respond to those events.
//also need to add @EnableJpaAuditing in entry point of application...
//alternative is to pass date in builder class.
//@Table(name = "ReviewData") //we can give custom name to our table like this.
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Double rating;

    @Column(name = "createdAt" ,nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // format
    @CreatedDate // get when field was created
    private Date createdAt;

    @Column(name = "updatedAt" ,nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate //get when field is modified
    private Date updatedAt;

}
