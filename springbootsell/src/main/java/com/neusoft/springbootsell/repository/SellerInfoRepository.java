package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {


    SellerInfo findByUsernameAndPassword(String username,String password);

    SellerInfo save(SellerInfo sellerInfo);
}
