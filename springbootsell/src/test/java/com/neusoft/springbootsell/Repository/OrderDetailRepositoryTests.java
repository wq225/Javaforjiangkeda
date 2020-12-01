package com.neusoft.springbootsell.Repository;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import com.neusoft.springbootsell.repository.OrderDetailRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTests {
    @Autowired
    OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("02");
        orderDetail.setOrderId("2");
        orderDetail.setProductId("12");
        orderDetail.setProductName("老味居");
        orderDetail.setProductPrice(new BigDecimal(10.88));
        orderDetail.setProductQuantity(999);
        orderDetail.setProductIcon("太好吃了");

        OrderDetail result=repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("123455");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}
