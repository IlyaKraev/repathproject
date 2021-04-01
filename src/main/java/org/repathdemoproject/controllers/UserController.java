package org.repathdemoproject.controllers;

import org.repathdemoproject.entities.User;
import org.repathdemoproject.requests.UserRequest;
import org.repathdemoproject.responses.Response;
import org.repathdemoproject.responses.UserResponse;
import org.repathdemoproject.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

// The requested endpoints, packaged neatly in a REST controller
@RestController
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // Creates a new user to add to the database
    @PostMapping(value = "/new", consumes = "application/json")
    public Response addUser(@RequestBody UserRequest request) {
        userService.createNewUser(request);
        return new Response("A new user has been saved.");
    }

    // This returns all the users in the database
    @GetMapping(value = "/getall")
    public UserResponse getAllUsers() {
        return new UserResponse("Found all users.", userService.getAll());
    }

    // Updates an existing user within the database
    @PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
    public Response updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
        if (isNull(userService.updateUser(id, request))) {
        return new Response("No user has been updated.");
        }
        return new Response("A user has been updated.");
    }

    // Deletes an existing user from the database
    @DeleteMapping(value = "/delete/{id}")
    public Response deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return new Response("A user has been deleted.");
        }
        return new Response("No user has been deleted.");

    }

    // Returns all the users that are in the same company
    @GetMapping(value = "/getbycompany/{company}")
    public UserResponse getByCompany(@PathVariable String company) {
        return new UserResponse("Found the relevant users.", userService.getByCompany(company));
    }
}
