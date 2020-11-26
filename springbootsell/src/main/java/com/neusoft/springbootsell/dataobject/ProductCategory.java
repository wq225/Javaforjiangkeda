package com.neusoft.springbootsell.dataobject;

//商品类目

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
public class ProductCategory {
    //类目的id
    @Id
    @GeneratedValue
    private Integer categoryId;
    //类目名
    private String categoryName;
    //类目的编号
    private Integer categoryType;
    //订单的创建时间
    private Date createTime;
    //订单的更新时间
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
