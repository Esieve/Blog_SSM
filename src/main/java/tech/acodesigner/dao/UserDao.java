package tech.acodesigner.dao;

import tech.acodesigner.dto.UserDto;
import tech.acodesigner.entity.User;

import java.util.List;

/**
 * Created by 77239 on 2017/3/28/0028.
 */
public interface UserDao {

    public List<UserDto> getUsers();

    public UserDto getUserByUserId(int userId);

    public UserDto getUserByUser(User user);

    public int saveUser(User user);

    public int updateUser(User user);

    public int deleteUser(int userId);

}
