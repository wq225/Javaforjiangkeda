package com.neusoft.springbootsell.form;

import lombok.Data;

import java.sql.Date;

@Data
public class SellerForm {
    private String id;
    //用户名
    private String username;
    //登录密码
    private String password;
    private String openid;
    //登录时间
    private Date createTime;
    //退出时间
    private Date updateTime;
}
