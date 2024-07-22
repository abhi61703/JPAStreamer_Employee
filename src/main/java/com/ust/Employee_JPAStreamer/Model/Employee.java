package com.ust.Employee_JPAStreamer.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ustdata")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "education")
    private String education;

    @Column(name = "joiningYear")
    private int joiningYear;

    @Column(name = "city")
    private String city;

    @Column(name = "paymentTier")
    private int paymentTier;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "everBenched")
    private String everBenched;

    @Column(name = "experienceInCurrentDomain")
    private int experienceInCurrentDomain;

    @Column(name = "leaveOrNot")
    private int leaveOrNot;
}
