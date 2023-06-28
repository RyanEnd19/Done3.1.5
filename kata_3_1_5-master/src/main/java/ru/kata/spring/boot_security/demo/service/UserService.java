package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Component
public interface UserService extends UserDetailsService {
    void saveUser(User user);
    User findById(Long id);

    void deleteUser(Long id);

    void editUser(User user, Long id);

    List<User> getListUsers();

    User findByEmail(String username);


}
