package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.ProductInfo;
import com.neusoft.springbootsell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SellerInfoRepository extends JpaRepository<SellerInfo,Long> {
//    List<SellerInfo> findByUsernameAndPassword(String username, String password) ;
//    List<SellerInfo> findByUsername(String username);

    SellerInfo findByUsernameAndPassword(String username,String password);

    SellerInfo findByOpenid(String abc);
}
