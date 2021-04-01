package org.repathdemoproject.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.repathdemoproject.entities.User;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse  extends Response{
    private User user;
    private List<User> users;

    public UserResponse(String msg, User user) {
        super(msg);
        this.user = user;
    }

    public UserResponse(String msg, List<User> users) {
        super(msg);
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
