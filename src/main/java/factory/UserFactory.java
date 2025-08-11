package factory;

import domain.User;

public class UserFactory {

    public static User createUser(int userId, String lastName, String firstName, String email, String password) {

        return new User.Builder().setUserId(userId)
                .setLastName(lastName)
                .setFirstName(firstName)
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}
