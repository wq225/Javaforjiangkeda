package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dto.OrderDTO;
import com.neusoft.springbootsell.enums.ResultEnum;
import com.neusoft.springbootsell.exception.SellException;
import com.neusoft.springbootsell.services.BuyerService;
import com.neusoft.springbootsell.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {


    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return null;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        return null;
    }
}