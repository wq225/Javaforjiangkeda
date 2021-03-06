package com.neusoft.springbootsell.dataobject;

import com.neusoft.springbootsell.enums.OrderStatusEnum;
import com.neusoft.springbootsell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//订单主表
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    //订单id
    @Id
    private String orderId;

    //买家名字
    private String buyerName;

    //买家的手机号
    private String buyerPhone;

    //买家的地址
    private String buyerAddress;

    //买家的微信openId
    private  String buyerOpenid;

    //订单的总金额
    private BigDecimal orderAmount;

    //订单状态 默认为0 新下单
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    //订单的支付状态 默认为0 未支付
    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    //订单的创建时间
    private Date createTime;

    //订单的更新时间
    private Date updateTime;
}
