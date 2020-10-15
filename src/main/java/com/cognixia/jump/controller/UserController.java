package com.cognixia.jump.controller;

import com.cognixia.jump.exceptions.ResourceNotFoundException;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repo.UserRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Controller for Users
 * @author David Morales
 * @version v1 (10/14/20)
 */
@RequestMapping("/api")
@RestController
public class UserController {
    @Autowired
    UserRepo service;

    @Autowired
    private MongoOperations mongoTemplate;

    @GetMapping("/allUsers")
    @ApiOperation(value = "",
    notes = "Retrieve all users in the database and sorts them by name in asending order. \n"
    + "Usage: looks up a list of all restaurant in the database\n" +
            "Author(s): David Morales\n" +
            "Exception(s): None",
    response = List.class, produces = "application/json")
    public List<User> getUsers() {
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "",
    notes = "Retrieve a user pertaining to an id. \n" +
            "Usage: provide an id to look up a user in the database\n" +
            "Author(s): David Morales\n" +
            "Exception(s): ResourceNotFoundException is thrown when the id does not match an exisiting user in the database",
    response = User.class, produces = "application/json")
    public User getUserById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<User> found = service.findById(id);
        if(!found.isPresent()) {
            throw new ResourceNotFoundException("User with id= " + id + " is not found");
        }

        return found.get();
    }

}
