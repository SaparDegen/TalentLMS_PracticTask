package company.service.impl;

import company.model.User;
import company.service.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        int result1 = 0;
        for (User elem: users) {
            if (user.getId() == elem.getId()) {
                result1 = 1;
                System.out.println("An error occurred, ID must be unique");
                break;
            }
        }
        if (result1 == 0) {
            users.add(user);
            System.out.println("A new user id:" + user.getId() + ", name:" + user.getName() + " was added");
        }
    }

    @Override
    public User findUserById(int id) {
        User result = null;
        for (User elem: users) {
            if (elem.getId() == id) {
                result = elem;
                break;
            }
        }
        if (result == null) {
            throw new MyException("The specified Id was not found");
        }
        return result;
    }

    @Override
    public void deleteUserById(int id) {
        users.remove(findUserById(id));
        System.out.println("User with Id " + id + " was deleted");
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return users;
    }
}
