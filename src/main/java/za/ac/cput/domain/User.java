package za.ac.cput.domain;

/*
User.java
User POJO class
Author: Luvo Nana 221376909
Date: 08 May 2025
*/

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import za.ac.cput.domain.enums.Role;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String lastName;
    private String firstName;
    private String password;
    private LocalDateTime lastLogin;
    private LocalDate createDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_email", referencedColumnName = "email")
    private Contact contact;

    // Protected default constructor for JPA
    protected User() {}

    private User(Builder builder) {
        this.userId = builder.userId;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.password = builder.password;
        this.role = builder.role;
        this.lastLogin = builder.lastLogin;
        this.createDate = builder.createDate;
        this.contact = builder.contact;
    }

    // ====== Getters ======
    public Long getUserId() { return userId; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getPassword() { return password; }
    public Role getRole() { return role; }
    public LocalDateTime getLastLogin() { return lastLogin; }
    public LocalDate getCreateDate() { return createDate; }
    public Contact getContact() { return contact; }

    // ====== Setters ======
    public void setUserId(Long userId) { this.userId = userId; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(Role role) { this.role = role; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }
    public void setCreateDate(LocalDate createDate) { this.createDate = createDate; }
    public void setContact(Contact contact) { this.contact = contact; }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", lastLogin=" + lastLogin +
                ", createDate=" + createDate +
                ", contact=" + contact +
                '}';
    }

    // ====== Builder Pattern ======
    public static class Builder {
        private Long userId;
        private String lastName;
        private String firstName;
        private String password;
        private Role role;
        private LocalDateTime lastLogin;
        private LocalDate createDate;
        private Contact contact;

        public Builder setUserId(Long userId) {
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
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }
        public Builder setLastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }
        public Builder setCreateDate(LocalDate createDate) {
            this.createDate = createDate;
            return this;
        }
        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.lastName = user.lastName;
            this.firstName = user.firstName;
            this.password = user.password;
            this.role = user.role;
            this.lastLogin = user.lastLogin;
            this.createDate = user.createDate;
            this.contact = user.contact;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}
