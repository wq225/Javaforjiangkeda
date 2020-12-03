package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dataobject.SellerInfo;
import com.neusoft.springbootsell.repository.SellerInfoRepository;
import com.neusoft.springbootsell.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;


    @Override
    public SellerInfo findSellerInfoByUsernameAndPassword(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public SellerInfo save(SellerInfo sellerInfo) {

        return repository.save(sellerInfo);
    }


}
