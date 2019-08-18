package com.tiantian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiantian.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * description:
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
