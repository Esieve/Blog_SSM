package tech.acodesigner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.acodesigner.dao.UserDao;
import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.dto.UserDto;
import tech.acodesigner.entity.User;
import tech.acodesigner.service.UserService;

import java.util.List;

/**
 * Created by 77239 on 2017/4/3/0003.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public OperationResult<UserDto> checkUser(User user) {
        OperationResult<UserDto> or = new OperationResult<UserDto>();
        UserDto result = userDao.getUserByUser(user);
        if (result == null) {
            or.setSuccess(false);
            or.setInfo("用户名或密码错误");
        } else {
            or.setSuccess(true);
            or.setData(result);
        }
        return or;
    }

    public OperationResult registerUser(User user) {
        OperationResult or = new OperationResult();
        int result = userDao.saveUser(user);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("用户名已存在");
        } else {
            or.setSuccess(true);
            or.setInfo("注册成功");
        }
        return or;
    }

    public List<UserDto> getUsers() {
        return userDao.getUsers();
    }

    public OperationResult getUser(int userId) {
        OperationResult or = new OperationResult();
        UserDto user = userDao.getUserByUserId(userId);
        if (user == null) {
            or.setSuccess(false);
            or.setInfo("该用户不存在");
        } else {
            or.setSuccess(true);
            or.setData(user);
        }
        return or;
    }

    public OperationResult updateUser(User user) {
        OperationResult or = new OperationResult();
        int result = userDao.updateUser(user);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("修改用户失败");
        } else {
            or.setSuccess(true);
            or.setInfo("修改用户成功");
        }
        return or;
    }

    public OperationResult deleteUser(int userId) {
        OperationResult or = new OperationResult();
        int result = userDao.deleteUser(userId);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("删除用户失败");
        } else {
            or.setSuccess(true);
            or.setInfo("删除用户成功");
        }
        return or;
    }
}
