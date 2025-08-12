package za.ac.cput.domain;

/*
User.java
User POJO class
Author: Luvo Nana 221376909
Date: 08 May 2025
*/

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId; //long
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private LocalDateTime lastLogin;
    private LocalDate createDate;
    @Enumerated(EnumType.STRING)
    private Role role;


    // Protected default constructor for JPA
    protected User() {}

    private User(Builder builder) {
        this.userId = builder.userId;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.email = builder.email;
        this.password = builder.password;
    }

    // Getters
    public int getUserId() { return userId; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // Builder pattern
    public static class Builder {
        private int userId; //long
        private String lastName;
        private String firstName;
        private String email;
        private String password;

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder copy(User user) {
            this.userId = user.userId;
            this.lastName = user.lastName;
            this.firstName = user.firstName;
            this.email = user.email; //Remove
            this.password = user.password;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}
