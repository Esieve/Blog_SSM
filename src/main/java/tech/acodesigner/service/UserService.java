package tech.acodesigner.service;

import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.dto.UserDto;
import tech.acodesigner.entity.User;

/**
 * Created by 77239 on 2017/4/3/0003.
 */
public interface UserService {

    public OperationResult<UserDto> checkUser(User user);

    public OperationResult registerUser(User user);

}
