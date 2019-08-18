package com.tiantian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tiantian.entity.User;

import java.util.List;

/**
 * description:
 */
public interface UserService extends IService<User>{
    List<User> selectAll();

    User selectByUserId(Integer userId);

    User updateByUserId(User user);

    String deleteById(Integer userId);
}
