package com.example.demo.user;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="test_user")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private int id;
    private String username;
    private String email;
    private LocalDate dob;

    public User() {
    }

    public User(int id, String username, String email, LocalDate dob) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.dob = dob;
    }

    public User(String username, String email, LocalDate dob) {
        this.username = username;
        this.email = email;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
