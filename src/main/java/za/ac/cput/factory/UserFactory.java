package za.ac.cput.factory;

import za.ac.cput.domain.User;

public class UserFactory {

    public static User createUser(int userId, String lastName, String firstName, String email, String password) {

        return new User.Builder().userId(userId)
                .userId(userId)
                .lastName(lastName)
                .firstName(firstName)
                .email(email)
                .password(password)
                .build();
    }
}
