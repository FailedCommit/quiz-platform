package com.maatlabs.userservice.beans;

import jakarta.persistence.*;

@Entity
public class QuizUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

// TODO: How an autogenerated Long ID would work if we have multiple DB shards running all over the
//  planet? Would we not need User Databases per Geography, and userId to be like <Geography>_<Number or String> ie
//  usa_userId1, india_userId2 ?? We can have a global mater and replicas like Amazon Aurora Global DB but self managed could pose problems

