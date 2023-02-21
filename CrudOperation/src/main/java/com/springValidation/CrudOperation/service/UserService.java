package com.springValidation.CrudOperation.service;


import com.springValidation.CrudOperation.dao.IUserRepository;
import com.springValidation.CrudOperation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private IUserRepository repository;

    //addUser function is used to add new user into the databse
    public User addUser(User user) {
        repository.save(user);
        return user;
    }

    // findById function is used to fetching the data from the database

    public Optional<User> findById(int userId) {
        return repository.findById(userId);
    }

    //findAll function will return all the data stored in the database
    public List<User> findAll() {
        return repository.findAll();
    }

    // The updateUser function will check weather the user is present or not in the database
    // if it finds the user it'll update the user else it will throw the error
    public  User updateUserById(int userId,User user){
        Optional<User> optionalUser=repository.findById(userId);
        if(optionalUser.isPresent()){
            User user1=optionalUser.get();
            user1.setUsername(user.getUsername());
            user1.setDateOfBirth(user.getDateOfBirth());
            user1.setEmail(user.getEmail());
            user1.setPhoneNumber(user.getPhoneNumber());
            user1.setTime(user.getTime());
            user1.setDate(user.getDate());
            return repository.save(user1);
        }else {
            throw new UserNotFoundException("No such User present in the database");
        }
    }


    //this function will delete the user if it's present in the database else it will throw error
    public void deleteUser(int userId) {
        try {
            repository.deleteById(userId);
        } catch (Exception e) {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        }
    }
}
