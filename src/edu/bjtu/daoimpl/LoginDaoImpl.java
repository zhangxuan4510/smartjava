package edu.bjtu.daoimpl;

import edu.bjtu.dao.LoginDao;
import edu.bjtu.util.UtilDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangxuan on 2016/7/10.
 */
public class LoginDaoImpl implements LoginDao{
    @Override
    public boolean userNameLogin(String userName,String password) {
        boolean flag=false;
        StringBuffer sqlbuff=new StringBuffer();
        sqlbuff.append("select * from user where username=? and userpwd=?");
        Connection conn= UtilDB.getConn();
        PreparedStatement stat=null;
        ResultSet res=null;
        try {
            stat=conn.prepareStatement(sqlbuff.toString());
            stat.setString(1,userName);
            stat.setString(2,password);
            res=stat.executeQuery();
            if(res.next()){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilDB.closeParament(null,stat,conn,res);
        }
        return flag;
    }
}
