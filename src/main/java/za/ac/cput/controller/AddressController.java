package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Address create(@RequestBody Address address) {
        return service.create(address);
    }

    @GetMapping("/read/{addressID}")
    public Address read(@PathVariable Long addressID) {
        return service.read(addressID);
    }

    @PutMapping("/update")
    public Address update(@RequestBody Address address) {
        return service.update(address);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long addressID) {
        this.service.delete(addressID);
    }

    @GetMapping("/getAll")
    public List<Address> getAll() {
        return service.getAll();
    }
}

