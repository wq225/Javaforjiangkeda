package com.neusoft;

import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;
import com.neusoft.view.impl.BusinessViewImpl;

import java.util.Scanner;

/**
 * 入驻商家入口
 * */
public class BusinessAdminEntry {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        Scanner input =new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("------饿了么商家自主管理系统----");
        System.out.println("---------------------------");

        //商家登录
        BusinessView businessView =new BusinessViewImpl();
        Business business=businessView.login();
        int menu=0;
        if(business!=null){
            System.out.println("商家"+"---"+business.getBusinessName()+"---"+"欢迎您回来！");
            while(menu!=5){
                System.out.println("1.查看商家信息");
                System.out.println("2.修改商家信息");
                System.out.println("3.修改密码");
                System.out.println("4.所属商品管理");
                System.out.println("5.退出系统");
                System.out.println("请输入你要选择的序号：");
                menu=input.nextInt();
                switch(menu){
                    case 1:
                        businessView.listAllBusinesses();
                        break;
                    case 2:
                        businessView.selectBusinesses();
                        break;
                    case 3:
                        businessView.saveBusiness();
                        break;
                    case 4:
                        businessView.removeBusiness();
                        break;
                    case 5:
                        System.out.println("欢迎下次登录");
                        break;
                    default:
                        System.out.println("没有这个选项");
                        break;
                }
            }
        }else{
            System.out.println("登陆失败，用户名或密码错误。");
        }
    }
}
