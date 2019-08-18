package com.tiantian.controller;

import com.tiantian.entity.User;
import com.tiantian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectAll")
    public List<User> selectAll() {
        return userService.selectAll();
    }

    /**
     * condition和unless的区别，condition对传入值生效，unless对结果result生效
     * 缓存注解在同一层的调用不生效 如: 直接在同一层调用方法 selectByUserId(5); 缓存不生效
     * @param userId
     * @return
     */

    @RequestMapping("/selectByUserId")  // unless = "#result == null" 结果为空则不缓存
    @Cacheable(value = "redisCache", unless = "#result == null", key = "'user_id' + #userId")
    public User selectByUserId(Integer userId){
        return userService.selectByUserId(userId);
    }

    @RequestMapping("/updateByUserId") // 更新 结果为空不缓存
    @CachePut(value = "redisCache", condition = "#result != null",key = "'user_id' + #result.userId")
    public User updateByUserId(User user) {
        return userService.updateByUserId(user);
    }

    @RequestMapping("/deleteByUserId") // 结果为空不缓存
    @CacheEvict(value = "redisCache", condition = "#result != null", key = "'user_id' + #userId")
    public String deleteByUserId(Integer userId) {
        return userService.deleteById(userId);
    }

}