package za.ac.cput.domain;

/*
Contact.java
Contact POJO class
Author: Luvo Nana 221376909
Date: 15 August 2025
*/

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate createDate;

    protected Contact() {}

    private Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.createDate = builder.createDate;
    }

    public Long getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public LocalDate getCreateDate() { return createDate; }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public static class Builder {
        private Long contactId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private LocalDate createDate;

        public Builder setContactId(Long contactId) {
            this.contactId = contactId;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setCreateDate(LocalDate createDate) {
            this.createDate = createDate;
            return this;
        }
        public Builder copy(Contact contact) {
            this.contactId = contact.contactId;
            this.firstName = contact.firstName;
            this.lastName = contact.lastName;
            this.phoneNumber = contact.phoneNumber;
            this.email = contact.email;
            this.createDate = contact.createDate;
            return this;
        }
        public Contact build() {
            return new Contact(this);
        }
    }
}
