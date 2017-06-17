package tech.acodesigner.service;

import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.dto.UserDto;
import tech.acodesigner.entity.User;

import java.util.List;

/**
 * Created by 77239 on 2017/4/3/0003.
 */
public interface UserService {

    public OperationResult<UserDto> checkUser(User user);

    public OperationResult registerUser(User user);

    public List<UserDto> getUsers();

    public OperationResult getUser(int userId);

    public OperationResult updateUser(User user);

    public OperationResult deleteUser(int userId);

}
