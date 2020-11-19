package com.neusoft;

import com.neusoft.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 通过键盘录入用户名和密码
 * 判断用户是否登录成功
 * select * from user where username = "" and password = "";
 * 如果这个sql有查询结果，则成功，反之，则失败
 * */
public class JDBCusercheck {
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName =sc.nextLine();
        System.out.println("请输入密码：");
        String password =sc.nextLine();
        if(check(userName,password)){
            System.out.println("登陆成功！");
        }else{
            System.out.println("用户名或者密码错误！");
        }
    }

    private static boolean check(String userName, String password) throws SQLException {
        //参数校验
        if(userName==null||password==null){
            return false;
        }
        Connection conn= null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn= JDBCUtils.getConnection();
            String sql = "select * from yonghu where username = '"+userName+"' and password='"+password+"'";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //    走到这里说明有异常，需要返回true
        return false;
    }
}
