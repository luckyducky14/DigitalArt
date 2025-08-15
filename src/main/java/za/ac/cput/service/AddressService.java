package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    public static IAddressService service;

    private AddressRepository repository;

    public Address create(Address address) {
        return repository.save(address);
    }

    public Address read(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Address update(Address address) {
        return repository.save(address);
    }

    public void delete(Long addressID) {
        this.repository.deleteById(addressID);
    }

    public List<Address> getAll() {
        return repository.findAll();
    }
}
