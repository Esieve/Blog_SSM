package tech.acodesigner.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.acodesigner.dto.UserDto;
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
        User user = new User("root", "ICy5YqxZB1uWSwcVLSNLcA==");
        UserDto result = userDao.getUser(user);
        if (result == null) {
            System.out.println("NULL");
        } else {
            System.out.println(result.getUsername());
        }
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User("123", "123", "123");
        int result = userDao.saveUser(user);
        System.out.println(result);
    }

}