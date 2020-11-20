package com.neusoft;

import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.domain.Business;

import java.util.List;

public class test {
    public static void main(String[] args) {
        /**获取business所以的商家
             BusinessDaoImpl dao=new BusinessDaoImpl();
             List<Business> businessList=dao.listBusiness();
             for(Business b : businessList){
             System.out.println(b);
             }
         * */


        /**添加一条记录
        BusinessDaoImpl dao = new BusinessDaoImpl();
        int businessid = dao.saveBusiness("江科大食堂");
        System.out.println("id" + businessid);
         */

        /**
        //删除一条记录
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.removeBusiness(10013);
        */

        /**
        //更新
        BusinessDaoImpl dao=new BusinessDaoImpl();
        Business business=new Business();
        business.setBusinessName("真好吃");
        business.setBusinessAddress("dasdas");
        business.setBusinessExplain("dasdas");
        business.setDeliveryPrice(5.);
        business.setStarPrice(2.);
        business.setBusinessId(10012);
        dao.updateBusiness(business);
        */

        //getBusinessById
        BusinessDaoImpl dao=new BusinessDaoImpl();
        Business b=dao.getBusinessById(10005);
        System.out.println(b);
    }
}
