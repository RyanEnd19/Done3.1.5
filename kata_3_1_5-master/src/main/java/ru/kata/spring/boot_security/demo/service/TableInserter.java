package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;


@Component
public class TableInserter implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public TableInserter(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) {
        Long first = 1L;
        User user3 = new User("anton",
                "gandon", (byte)82, "olisov_vbk@bk.ru", "1");
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");

        roleService.saveRole(user);
        roleService.saveRole(admin);

        //user3.addRole(user);
        user3.setRoles(Set.of(user, admin));

        userService.saveUser(user3);
        //userService.flush();

    }
}
