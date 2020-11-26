package com.neusoft.springbootsell.Repository;

import com.neusoft.springbootsell.dataobject.OrderMaster;
import com.neusoft.springbootsell.repository.OrderMasterRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTests {
    @Autowired
    OrderMasterRepository repository;

    private final String OPENID="110110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setUserName("王琪");
        orderMaster.setBuyerPhone("18862622817");
        orderMaster.setBuyerAddress("江科大西门");
        orderMaster.setBuyerOpenId(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(9.9));

        OrderMaster result=repository.save(orderMaster);
        //System.out.println(master);
        Assert.assertNotNull(result);
    }
}
