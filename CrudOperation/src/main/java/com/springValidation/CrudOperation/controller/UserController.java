package com.springValidation.CrudOperation.controller;


import com.springValidation.CrudOperation.dao.IUserRepository;
import com.springValidation.CrudOperation.model.User;
import com.springValidation.CrudOperation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/User")
@Validated
public class UserController {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@Valid @RequestBody User newuser) {
        User user = userRepository.save(newuser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("findUserById/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("updateUserById/{userId}")
    public ResponseEntity<User> updateUserById(@PathVariable int userId,@Valid @RequestBody User user){
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user1=optionalUser.get();
            user1.setUsername(user.getUsername());
            user1.setDateOfBirth(user.getDateOfBirth());
            user1.setEmail(user.getEmail());
            user1.setPhoneNumber(user.getPhoneNumber());
            user1.setTime(user.getTime());
            user1.setDate(user.getDate());
            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int userId) {
        try {
            userRepository.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
