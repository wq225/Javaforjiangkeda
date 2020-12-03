package com.neusoft.springbootsell.Repository;

import com.neusoft.springbootsell.dataobject.SellerInfo;
import com.neusoft.springbootsell.repository.SellerInfoRepository;
import com.neusoft.springbootsell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save(){
        SellerInfo sellerInfo=new SellerInfo();
        sellerInfo.setId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        SellerInfo result=repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUsernameAndPassword() throws Exception{
        SellerInfo result=repository.findByUsernameAndPassword("王老板","123");
        Assert.assertEquals("王老板",result.getUsername());
        Assert.assertEquals("123",result.getPassword());
    }

}
