package za.ac.cput.service;

import za.ac.cput.domain.Contact;
import java.util.List;

public interface IContactService extends IService<Contact, Long> {
    Contact create(Contact contact);

    Contact read(Long aLong);
    Contact update(Contact contact);

    List<Contact> getAll();
}
