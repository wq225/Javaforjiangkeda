package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.SellerInfo;

import java.util.List;

public interface SellerService {
//    List<SellerInfo> findAll();
//    //登录
//    List<SellerInfo> findByUsernameAndPassword(String username,String password);
//

    SellerInfo findSellerInfoByUsernameAndPassword(String username,String password);
}
