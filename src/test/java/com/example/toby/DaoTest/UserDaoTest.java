package com.example.toby.DaoTest;

import com.example.toby.dao.DaoFactory;
import com.example.toby.dao.UserDao;
import com.example.toby.domain.User;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;


public class UserDaoTest {
    private UserDao userDao = new DaoFactory().userDao();

    @Test
    void join() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setId("kimyur33");
        user.setName("김유링");
        user.setPassword("1234");
        userDao.add(user);
        System.out.println("success");
    }
}
