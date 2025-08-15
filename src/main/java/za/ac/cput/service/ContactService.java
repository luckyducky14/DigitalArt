package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.ContactRepository;

import java.util.List;

@Service
public class ContactService implements IContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact create(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Contact read(Long contactId) {
        return repository.findByContactId(contactId);
    }

    @Override
    public Contact update(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public boolean delete(Long contactId) {
        if (repository.existsByContactId(contactId)) {
            repository.existsByContactId(contactId);
            return true;
        }
        return false;
    }

    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }
}
