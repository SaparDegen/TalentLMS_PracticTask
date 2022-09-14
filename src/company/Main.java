package company;

import company.dao.UserDao;
import company.model.Gender;
import company.model.User;
import company.service.impl.MyException;
import company.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        //9) Main ������� 3 user ������� id���� 1,2,3 ������.
        userService.addUser(new User(1, "Kubatbek", 18, Gender.MALE));
        userService.addUser(new User(2, "Salkyn", 19, Gender.FEMALE));
        userService.addUser(new User(3, "Uson", 20, Gender.MALE));
        userService.addUser(new User(3, "Uson", 20, Gender.MALE));
        //10) ������ ������ ������ �������.
        UserDao userDao = new UserDao();
        userDao.setUsers(userService.getAllUsers());
        System.out.println(userDao.getUsers());
        //11) 1 ����� id ����� user�� ���� ��������� ���������.
        try {                                                   //12) ���� �� id ��� ����� ���� RunTimeException ��������.
            System.out.println("User with Id was find: " + userService.findUserById(1));
        } catch (MyException me) {                              //13) Exception �� ��������� �����������
            System.out.println(me.getMessage());
        }
        //14) ������� user����� ��������� ���������.
        System.out.println(userDao.getUsers());
        //15) 2 ����� id ����� user�� ��������.
        userService.deleteUserById(2);
        //16) ������� user����� ��������� ���������.
        System.out.println(userDao.getUsers());
    }
}