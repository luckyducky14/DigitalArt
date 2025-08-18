package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(String lastName, String firstName, String password) {

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password)) {
            return null;
        }
        // Contact contact = ContactFactory.createContact(email,
        return new User.Builder()
                .setLastName(lastName)
                .setFirstName(firstName)
                .setPassword(password)
                .build();
    }
}
