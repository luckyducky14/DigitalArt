package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void createAddressSuccess() {
        User user = new User.Builder().setUserId(1L).setFirstName("John").setLastName("Doe").build();
        Address address = AddressFactory.createAddress("123 Main St", "Cape Town", "Western Cape", "8000", "South Africa", user);
        assertNotNull(address);
    }

}
