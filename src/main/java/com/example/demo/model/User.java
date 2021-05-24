package com.example.demo.model;

import com.example.demo.model.Post;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(
        name="test_user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
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
    @Column(
            name = "id",
            updatable = false
    )
    private int id;

    @Column(
            name = "username",
            nullable = false
//            columnDefinition = "TEXT"
    )
    private String username;

    @Column(
            name = "email",
            nullable = false
//            columnDefinition = "TEXT",
//            unique = true
    )
    private String email;

    @Column(
            name = "dob"
    )
    private LocalDate dob;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

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
