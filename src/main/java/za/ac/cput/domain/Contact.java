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
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    @Column(unique = true, nullable = false, length = 11)
    private String phoneNumber;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private LocalDate createDate;

    @Column(unique = true, nullable = false, length = 11)
    private String altNumber;

    protected Contact() {}

    private Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.createDate = builder.createDate;
        this.altNumber = builder.altNumber;
    }

    public Long getContactId() { return contactId; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public LocalDate getCreateDate() { return createDate; }
    public String getAltNumber() { return altNumber; }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", altNumber='" + altNumber + '\'' +
                '}';
    }

    public static class Builder {
        private Long contactId;
        private String phoneNumber;
        private String email;
        private LocalDate createDate;
        private String altNumber;

        public Builder setContactId(Long contactId) {
            this.contactId = contactId;
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

        public Builder setAltNumber(String altNumber) {
            this.altNumber = altNumber;
            return this;
        }

        public Builder copy(Contact contact) {
            this.contactId = contact.contactId;
            this.phoneNumber = contact.phoneNumber;
            this.email = contact.email;
            this.createDate = contact.createDate;
            this.altNumber = contact.altNumber;
            return this;
        }
        public Contact build() {
            return new Contact(this);
        }
    }
}
