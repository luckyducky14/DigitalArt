package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ContactFactoryTest {

    private static Contact c1 = ContactFactory.createContact("0712345678", "james.carter@example.com", "0725075082");
    private static Contact c2 = ContactFactory.createContact("0823456789", "sophia.miller@example.com", "0647924284");
    private static Contact c3 = ContactFactory.createContact("0834567890", "invalid@example.com", "0761921751");// Should fail

    @Test
    public void testCreateContact() {
        assertNotNull(c1);
        System.out.println(c1.toString());
    }

    @Test
    public void testCreateContactWithAllAttributes() {
        assertNotNull(c2);
        System.out.println(c2.toString());
    }

    @Test
    public void testCreateContactThatFails() {
        assertNull(c3);
        System.out.println("c3 failed due to invalid information.");
    }
}
