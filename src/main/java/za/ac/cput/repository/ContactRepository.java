package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findByEmail(String email);
    boolean existsByEmail(String email);

    Contact findByContactId(Long contactId);
    boolean existsByContactId(Long contactId);
}
