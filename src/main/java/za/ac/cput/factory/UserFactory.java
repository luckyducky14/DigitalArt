package za.ac.cput.factory;


import za.ac.cput.domain.Contact;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(String lastName, String firstName, String password, String email, String phoneNumber, String altNumber) {

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password)) {
            return null;        }
        Contact contact = ContactFactory.createContact(phoneNumber, email, altNumber);
        return new User.Builder()
                .setLastName(lastName)
                .setFirstName(firstName)
                .setPassword(password)
                .setContact(contact)
                .build();
    }
}
