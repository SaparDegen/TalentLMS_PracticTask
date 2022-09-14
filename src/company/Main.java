package company;

import company.dao.UserDao;
import company.model.Gender;
import company.model.User;
import company.service.impl.MyException;
import company.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        //9) Main методдо 3 user тузунуз idлери 1,2,3 болсун.
        userService.addUser(new User(1, "Kubatbek", 18, Gender.MALE));
        userService.addUser(new User(2, "Salkyn", 19, Gender.FEMALE));
        userService.addUser(new User(3, "Uson", 20, Gender.MALE));
        userService.addUser(new User(3, "Uson", 20, Gender.MALE));
        //10) Аларды биздин базага кошунуз.
        UserDao userDao = new UserDao();
        userDao.setUsers(userService.getAllUsers());
        System.out.println(userDao.getUsers());
        //11) 1 деген id менен userди таап консольго чыгарыныз.
        try {                                                   //12) Эгер ал id жок болсо анда RunTimeException кармасын.
            System.out.println("User with Id was find: " + userService.findUserById(1));
        } catch (MyException me) {                              //13) Exception ди озунуздор тузунуздорю
            System.out.println(me.getMessage());
        }
        //14) Баардык userлерди консольго чыгарыныз.
        System.out.println(userDao.getUsers());
        //15) 2 деген id менен userди очурунуз.
        userService.deleteUserById(2);
        //16) Баардык userлерди консольго чыгарыныз.
        System.out.println(userDao.getUsers());
    }
}