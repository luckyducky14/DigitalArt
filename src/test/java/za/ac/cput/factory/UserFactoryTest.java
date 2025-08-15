package za.ac.cput.factory;

import za.ac.cput.domain.User;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserFactoryTest {

    private static User u1 = UserFactory.createUser("Nana", "Luvo", "751luvonana@gmail.com", "Luv@2025");
    private static User u2 = UserFactory.createUser("Precious", "Mbali", "PreciousMbali@gmail.com", "Mbali@20002");
    private static User u3 = UserFactory.createUser("Goodman", "Steers", "goodman@gmail.com", "Steers@9120");


    @Test
    public void testCreateUser() {
        assertNotNull(u1);
        System.out.println(u1.toString());
    }

    @Test
    public void testCreateUserWithAllAttributes() {
        assertNotNull(u2);
        System.out.println(u2.toString());
    }

    @Test
    public void testCreateUserThatFails() {
        assertNotNull(u3);
        System.out.println(u1.toString());
    }
}
