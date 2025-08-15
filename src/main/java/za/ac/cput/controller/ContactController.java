package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact) {
        return service.create(contact);
    }

    @GetMapping("/read/{id}")
    public Contact read(@PathVariable Long contactId) {
        return service.read(contactId);
    }

    @PutMapping("/update")
    public Contact update(@RequestBody Contact contact) {
        return service.update(contact);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long contactId) {
        return service.delete(contactId);
    }

    @GetMapping("/getAll")
    public List<Contact> getAll() {
        return service.getAll();
    }
}
