package org.repathdemoproject.services.interfaces;

import org.repathdemoproject.entities.User;
import org.repathdemoproject.requests.UserRequest;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    List<User> getByCompany(String company);

    boolean createNewUser(UserRequest User);
    User updateUser(Long id, UserRequest User);
    boolean deleteUser(Long id);
}
