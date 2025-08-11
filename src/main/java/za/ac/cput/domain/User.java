package za.ac.cput.domain;

/*
User.java
User POJO class
Author: Luvoo Nana 221376909
Date: 08 May 2025
*/

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private int userId;
    private String lastName;
    private String firstName;
    private String email;
    private String password;

    public int getUserId() {
        return userId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User() {
    }

    public User(int userId, String lastName, String firstName, String email, String password) {
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    public int getUserId(int userId) {
        return userId;
    }

    public String getLastName(String lastName) {
        return lastName;
    }

    public String getFirstName(String firstName) {
        return firstName;
    }

    public String getEmail(String email) {
        return email;
    }

    public String getPassword(String password) {
        return password;
    }

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

    private User(Builder builder) {
        this.userId = builder.userId;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.email = builder.email;
        this.password = builder.password;
    }

    public static class Builder {

        private int userId;
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

        public Builder copy(User item) {
            this.userId = item.userId;
            this.lastName = item.lastName;
            this.firstName = item.firstName;
            this.email = item.email;
            this.password = item.password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}