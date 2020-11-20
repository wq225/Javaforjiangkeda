package com.neusoft;

import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.domain.Business;

import java.util.List;

public class test {
    public static void main(String[] args) {

//         //获取business所以的商家
//        BusinessDaoImpl dao=new BusinessDaoImpl();
//        List<Business> businessList=dao.listBusiness();
//        for(Business b : businessList){
//            System.out.println(b);
//        }



//        //添加一条记录
//        BusinessDaoImpl dao = new BusinessDaoImpl();
//        int businessid = dao.saveBusiness("wq大酒店");
//        System.out.println("id" + businessid);



//        //删除一条记录
//        BusinessDaoImpl dao = new BusinessDaoImpl();
//        dao.removeBusiness(10013);



//        //更新
//        BusinessDaoImpl dao=new BusinessDaoImpl();
//        Business business=new Business();
//        business.setBusinessName("wq大酒店");
//        business.setBusinessAddress("徐州市云龙区");
//        business.setBusinessExplain("琪师傅亲自操刀");
//        business.setDeliveryPrice(500.);
//        business.setStarPrice(20.);
//        business.setBusinessId(10014);
//        dao.updateBusiness(business);


        //getBusinessById
        BusinessDaoImpl dao=new BusinessDaoImpl();
        Business b=dao.getBusinessById(10005);
        System.out.println(b);
    }
}
