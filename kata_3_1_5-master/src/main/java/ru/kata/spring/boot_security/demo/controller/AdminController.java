package ru.kata.spring.boot_security.demo.controller;

import org.springframework.boot.Banner;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    @Autowired
    public AdminController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/userinfo")
    public ResponseEntity<User> showInfo(Principal principal) {
        return ResponseEntity.ok(userService.findByEmail(principal.getName()));
    }
    @GetMapping("/table")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getListUsers(), HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> showUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> save(@RequestBody UserDTO user) {
        userService.saveUser(convertToUser(user));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody User user) {
        userService.editUser(user, user.getId());
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    private User convertToUser(UserDTO userdto) {
        return modelMapper.map(userdto, User.class);
    }

}
