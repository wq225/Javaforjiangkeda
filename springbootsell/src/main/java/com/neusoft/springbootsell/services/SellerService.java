package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.SellerInfo;

import java.util.List;

public interface SellerService {

   SellerInfo findSellerInfoByUsernameAndPassword(String username, String password);

   SellerInfo save(SellerInfo sellerInfo);

}
