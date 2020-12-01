package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    //orderMaster里面的一条记录可能对应orderDetail里面的多条记录，因此使用List
    List<OrderDetail> findByOrderId(String orderId);
}
