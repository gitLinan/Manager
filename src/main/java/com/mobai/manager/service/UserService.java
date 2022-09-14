package com.mobai.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mobai.manager.model.User;
import com.mobai.manager.model.UserVO;

import java.util.List;

/**
 * User Service interface
 *
 * @author li.nan
 * @date 2022/9/13
 */
public interface UserService extends IService<User> {
    User getUserById(long id);

    User getUserByUniqueId(long uniqueId);

    List<User> getUserList();

    void createUser(UserVO userVO) throws Exception;

    void deleteUser(long[] id) throws Exception;

    void updateUser(UserVO userVO) throws Exception;
}
