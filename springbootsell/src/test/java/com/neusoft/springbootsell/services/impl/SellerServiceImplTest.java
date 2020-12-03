package com.neusoft.springbootsell.services.impl;


import com.neusoft.springbootsell.dataobject.SellerInfo;
import com.neusoft.springbootsell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerServiceImplTest {

    private static final String username="admin";
    private static final String password="admin";

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findSellerInfoByUsernameAndPassword(){
        SellerInfo result =sellerService.findSellerInfoByUsernameAndPassword(username,password);
        Assert.assertEquals(username,result.getUsername());
        Assert.assertEquals(password,result.getPassword());
    }

    @Test
    public void save(){
        SellerInfo sellerInfo=new SellerInfo();
        sellerInfo.setId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin1");
        sellerInfo.setPassword("admin1");
        sellerInfo.setOpenid("abcd");

        SellerInfo result=sellerService.save(sellerInfo);
        Assert.assertNotNull(result);
    }
}
