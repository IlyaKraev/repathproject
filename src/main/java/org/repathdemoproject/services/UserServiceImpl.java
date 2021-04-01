package org.repathdemoproject.services;

import org.repathdemoproject.entities.User;
import org.repathdemoproject.repositories.UserRepository;
import org.repathdemoproject.requests.UserRequest;
import org.repathdemoproject.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        System.out.println("Service: Ready to find all the users.");
        return userRepository.findAll();
    }

    @Override
    public List<User> getByCompany(String company) {
        System.out.println("Service: Ready to find users.");
        return userRepository.findByCompany(company);
    }

    @Override
    public boolean createNewUser(UserRequest request) {
        User user = new User(request.getName(), request.getEmail(), request.getCompany());
        User newUser = userRepository.save(user);
        System.out.println("The new user is: "+newUser.toString());
        return true;
    }

    @Override
    public User updateUser(Long id, UserRequest request) {
        User existingUser = userRepository.findById(id).orElse(null);
        if(existingUser==null){
            System.out.println("The user has not been updated.");
            return null;
        }
        existingUser.setName(request.getName());
        existingUser.setCompany(request.getCompany());
        existingUser.setEmail(request.getEmail());
        User updatedUser = userRepository.save(existingUser);
        System.out.println("User has been updated: "+updatedUser.toString());
        return updatedUser;
    }

    @Override
    public boolean deleteUser(Long id) {
        if(userRepository.existsById(id)){
         userRepository.deleteById(id);
            System.out.println("User deleted.");
            return true;
        }
        System.out.println("User was not deleted.");
        return false;
    }
}
