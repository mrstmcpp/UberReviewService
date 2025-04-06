package org.mrstm.uberreviewservice.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

//basemodel -> all the attributes which are common across tables;

@MappedSuperclass //“This class is not an entity, but its fields should be mapped to the database columns in subclasses that are entities.”
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel { // abstract so that object creation is not possible
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id; //changed to protected from private so that all
    //the classes which extends only they can access it.

    @Column(name = "createdAt" ,nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // format
    @CreatedDate // get when field was created
    protected Date createdAt;

    @Column(name = "updatedAt" ,nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate //get when field is modified
    protected Date updatedAt;
}
