package com.tiantian.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("user")
public class User implements Serializable{
    @TableId
    private Integer userId;

    private String userName;

    private String userPassword;

    private String nickName;

    private String sex;

    private Date time;

}