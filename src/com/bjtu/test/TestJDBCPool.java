package com.bjtu.test;

import com.bjtu.jdbc.ConnectionManager;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangxuan on 2016/7/2.
 */
public class TestJDBCPool {
    public static void main(String[] args) throws Exception{
        System.out.println("使用连接池................................");
        for (int i = 0; i < 10000; i++) {
            long beginTime = System.currentTimeMillis();
            Connection conn = ConnectionManager.getInstance().getConnection();
            executeQuery(i,conn,beginTime);
        }

        System.out.println("不使用连接池................................");
        for (int i = 0; i < 10000; i++) {
            long beginTime = System.currentTimeMillis();
            MysqlDataSource ods = new MysqlDataSource();
            ods.setUser("root");
            ods.setPassword("321654");
            ods.setURL("jdbc:mysql://localhost:3306/contractmanage");
            Connection conn = ods.getConnection();
            executeQuery(i,conn,beginTime);
        }
    }

    private static void executeQuery(int i,Connection conn,long beginTime){
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from contract");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // do nothing...
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        if((i+1)%1000==0)
            System.out.println("第" + (i + 1) + "次执行花费时间为:" + (endTime - beginTime));
    }
}
