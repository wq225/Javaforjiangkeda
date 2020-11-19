package com.neusoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC查询操作
 */
public class JDBCDemo4 {
    public static void main(String[] args) throws Exception {
        //        1、导入驱动jar包, 建立libs文件夹， 右键 add as library
        //        2、 注册驱动
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //        3、获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=jiangkeda;user=sa;password=990225");
        //        4、定义sql
        String sql = "select * from account ";
        //        5、获取数据库连接对象statement
        Statement stmt = conn.createStatement();
        //        6、执行sql
        ResultSet rs = stmt.executeQuery(sql);
        //        7、处理结果
        rs.next();
        while(rs.next()){
            String id=rs.getString("id");
            String name=rs.getString("name");
            double balance=rs.getDouble("balance");
            System.out.println(id+"-----"+name+"-----"+balance);
        }

//        while(rs.next()){
//            String id=rs.getString(1);
//            String name=rs.getString(2);
//            double balance=rs.getDouble(3);
//            System.out.println(id+"-----"+name+"-----"+balance);
//        }
        //        8、释放资源
        stmt.close();
        conn.close();
    }
}