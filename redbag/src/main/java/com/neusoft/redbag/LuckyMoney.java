package com.neusoft.redbag;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 *LuckyMoney是与数据库表中字段一一对应的实体类
 * JavaBean 格式
 * */
@Entity
@Data
public class LuckyMoney {
    //@Entity 指定该类是实体类
    //@Id 代表主键  @GeneratedValue 代表自增长
    //@Data 是lombok插件的一个注解，标识此注解的实体类不用自己写get,set方法
    @Id
    @GeneratedValue
    private Integer id;
    //红包金额
    private BigDecimal money;
    //发红包的人
    private String producer;
    //收红包的人
    private String consumer;
    public LuckyMoney(){

    }


}
