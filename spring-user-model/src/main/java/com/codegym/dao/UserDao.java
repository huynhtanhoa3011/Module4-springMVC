package com.codegym.dao;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("Hoa");
        u1.setAccount("hoa");
        u1.setEmail("hoa@codegym.vn");
        u1.setPassword("123456");
        users.add(u1);

        User u2 = new User();
        u2.setAge(15);
        u2.setName("Hoang");
        u2.setAccount("hoang");
        u2.setEmail("hoang@codegym.vn");
        u2.setPassword("123456");
        users.add(u2);

        User u3 = new User();
        u3.setAge(16);
        u3.setName("Chuong");
        u3.setAccount("chuong");
        u2.setEmail("chuong@codegym.vn");
        u3.setPassword("123456");
        users.add(u3);
    }

    public static User checkLogin (Login login) {
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())) {
                return u;
            }
        }
        return null;
    }
}
