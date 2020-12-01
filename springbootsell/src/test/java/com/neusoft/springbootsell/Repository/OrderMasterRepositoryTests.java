package com.neusoft.springbootsell.Repository;

import com.neusoft.springbootsell.dataobject.OrderMaster;
import com.neusoft.springbootsell.repository.OrderMasterRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

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
        orderMaster.setOrderId("07");
        orderMaster.setBuyerName("要被删除的人");
        orderMaster.setBuyerPhone("13364712");
        orderMaster.setBuyerAddress("某小区");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(19.0));

        OrderMaster result=repository.save(orderMaster);
        //System.out.println(master);
        Assert.assertNotNull(result);
    }

//    //根据买家微信openid查询买家端信息
//    @Test
//    void findByBuyerOpenid() {
//        PageRequest request=PageRequest.of(0,1);
//        Page<OrderMaster> result
//                = repository.findByBuyerOpenid(OPENID, request);
//        Assert.assertNotEquals(0,result.getTotalElements());
//        //System.out.println(result.getTotalElements());
//    }

}
