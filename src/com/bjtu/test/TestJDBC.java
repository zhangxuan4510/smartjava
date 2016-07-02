package com.bjtu.test;

import com.bjtu.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by zhangxuan on 2016/7/2.
 */
public class TestJDBC {
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://localhost:3306/testjdbc";
        String userName="root";
        String userpwd="321654";
        Connection conn= JDBCUtil.getConn(url,userName,userpwd);
        String url2="jdbc:mysql://localhost:3306/schoolbook";
        Connection conn2=JDBCUtil.getConn(url2,userName,userpwd);
        System.out.println("conn "+conn);
        System.out.println("conn2 "+conn2);
    }
}
