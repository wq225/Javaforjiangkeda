package com.neusoft.springbootsell.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate
public class SellerInfo {
    //id
    @Id
    private String id;
    //用户名
    private String username;
    //登录密码
    private String password;
    private String openid;

}
