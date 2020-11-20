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
        System.out.println("id" + businessid);*/


        //删除一条记录
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.removeBusiness(10013);
    }
}
