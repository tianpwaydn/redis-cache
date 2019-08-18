package com.tiantian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiantian.entity.User;
import com.tiantian.mapper.UserMapper;
import com.tiantian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description:
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectList(null);
    }

    @Override
    public User selectByUserId(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public User updateByUserId(User user) {
        userMapper.updateById(user);
        return userMapper.selectById(user.getUserId());
    }

    @Override
    public String deleteById(Integer userId) {
        int count = userMapper.deleteById(userId);
        return count > 0 ? "success" : "false";
    }
}
