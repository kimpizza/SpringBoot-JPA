package com.example.toby;

import com.example.toby.dao.ConnectionMaker;
import com.example.toby.dao.DConnectionMaker;
import com.example.toby.dao.DaoFactory;
import com.example.toby.dao.UserDao;
import com.example.toby.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao",UserDao.class);

        User user = new User();
        user.setId("goguma8");
        user.setName("김유리8");
        user.setPassword("////");
        dao.add(user);
        System.out.println(user.getId() + " 등록 성공!!");

        User user2 = dao.get(user.getId());

        System.out.println(user2.getId());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId()+"조회 성공");
    }
}
