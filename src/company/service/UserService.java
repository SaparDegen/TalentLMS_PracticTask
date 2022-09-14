package company.service;

import company.model.User;

import java.util.ArrayList;

public interface UserService {
    public void addUser(User user);

    public User findUserById(int id);

    public void deleteUserById(int id);

    public ArrayList<User> getAllUsers();
}
