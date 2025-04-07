//package org.mrstm.uberreviewservice.models;
//
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class Student extends BaseModel {
//    private String studentName;
//    private String rollNo;
//
//    @ManyToMany
//    @JoinTable(
//            name = "course_students",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id")
//    )
//    private List<Course> courseList = new ArrayList<>();
//}


//just for learning purpose;