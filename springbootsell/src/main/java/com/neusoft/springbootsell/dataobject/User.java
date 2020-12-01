package com.neusoft.springbootsell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

//用户
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private String id;
    private String username;
    private String password;
    private String openid;
    private Date createTime;
    private Date updateTime;
}
