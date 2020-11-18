package com.neusoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC连接mysql示例
 */
public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
        //        1、导入驱动jar包, 建立libs文件夹， 右键 add as library
        //        2、 注册驱动
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //        3、获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=jiangkeda;user=sa;password=990225");
        //        4、定义sql
        String sql = "update account set balance = 500 where id = 1";
        //        5、获取数据库连接对象statement
        Statement stmt = conn.createStatement();
        //        6、执行sql
        int i = stmt.executeUpdate(sql);
        //        7、处理结果
        if (i == 1) {
            System.out.println("更新成功");
        } else {
            System.out.println("失败");
        }
        //        8、释放资源
        stmt.close();
        conn.close();
    }
}