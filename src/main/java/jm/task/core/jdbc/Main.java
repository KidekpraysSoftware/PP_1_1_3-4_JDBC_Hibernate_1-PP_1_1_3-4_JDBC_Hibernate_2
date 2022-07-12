package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь


        UserService userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();

        userServiceImpl.saveUser("Name1", "LastName1", (byte) 20);
        userServiceImpl.saveUser("Name2", "LastName2", (byte) 25);
        userServiceImpl.saveUser("Name3", "LastName3", (byte) 31);
        userServiceImpl.saveUser("Name4", "LastName4", (byte) 38);

        List<User> users = userServiceImpl.getAllUsers();
        System.out.println(users.toString());

        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();
    }
}

