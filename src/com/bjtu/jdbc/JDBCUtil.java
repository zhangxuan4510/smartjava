package com.bjtu.jdbc;
import java.sql.*;


/**
 * Created by zhangxuan on 2016/7/2.
 */
public class JDBCUtil
{

    public static Connection getConn(String url,String userName,String userpwd) throws Exception{
       //加载驱动
       Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url,userName,userpwd);
        Connection c=DriverManager.getConnection("sss");

        return conn;
    }



}
