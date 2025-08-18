package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class ContactFactory {

    public static Contact createContact(String firstName, String lastName, String phoneNumber, String email) {

        if (Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(email)) {
            return null;
        }

        return new Contact.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setCreateDate(LocalDate.now())
                .build();
    }
}
