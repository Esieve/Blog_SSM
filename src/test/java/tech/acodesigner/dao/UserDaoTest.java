package tech.acodesigner.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.acodesigner.entity.User;

import static org.junit.Assert.*;

/**
 * Created by 77239 on 2017/3/28/0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/dao.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getUser() throws Exception {
        User user = new User();
        user.setUsername("root");
        user.setPassword("ICy5YqxZB1uWSwcVLSNLcA==");
        User result = userDao.getUser(user);
        if (result == null) {
            System.out.println("NULL");
        } else {
            System.out.println(result.getUsername());
        }
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setUsername("123");
        user.setPassword("123");
        user.setImage("123");
        int result = userDao.saveUser(user);
        System.out.println(result);
    }

}