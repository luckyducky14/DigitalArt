package za.ac.cput.service;

import za.ac.cput.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {

    Public final UserRepository repository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User read(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id)
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
