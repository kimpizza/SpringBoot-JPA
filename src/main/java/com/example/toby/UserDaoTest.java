package com.example.toby;

import com.example.toby.dao.ConnectionMaker;
import com.example.toby.dao.DConnectionMaker;
import com.example.toby.dao.UserDao;
import com.example.toby.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao dao = new UserDao(connectionMaker);
        User user = new User();
        user.setId("goguma4");
        user.setName("김유리4");
        user.setPassword("////");
        dao.add(user);
        System.out.println(user.getId() + " 등록 성공!!");

        User user2 = dao.get(user.getId());

        System.out.println(user2.getId());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId()+"조회 성공");
    }
}
