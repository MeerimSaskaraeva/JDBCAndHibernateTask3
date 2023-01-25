package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getSession();

        UserService userService=new UserServiceImpl();
//
//        userService.createUsersTable();
//        userService.dropUsersTable();
        userService.saveUser("Meerim","Saskaraeva",(byte)39);
//        userService.saveUser("Nina","Sova",(byte)23);
//        userService.removeUserById(1L);
//        System.out.println(userService.getAllUsers());
//        userService.cleanUsersTable();
    }
}
