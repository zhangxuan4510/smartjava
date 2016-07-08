package edu.bjtu.daoimpl;

import edu.bjtu.dao.RegisterDao;
import edu.bjtu.model.User;
import edu.bjtu.util.UtilDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangxuan on 2016/7/8.
 */
public class RegisterDaoimpl implements RegisterDao {

    @Override
    public boolean register(User user) {
        int count=0;
        StringBuffer sqlbuff=new StringBuffer();
        sqlbuff.append("insert into user(custid,name,username,userpwd,cardid,phone,email,address,registerdate,recentdate) ");
        sqlbuff.append("values(?,?,?,?,?,?,?,?,?,?)");
        Connection conn=UtilDB.getConn();
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(sqlbuff.toString());
            stat.setString(1,user.getCustID());
            stat.setString(2,user.getName());
            stat.setString(3,user.getUserName());
            stat.setString(4,user.getUserPwd());
            stat.setString(5,user.getCardID());
            stat.setString(6,user.getPhone());
            stat.setString(7,user.getEmail());
            stat.setString(8,user.getAddress());
            stat.setDate(9,user.getRegisterDate());
            stat.setDate(10,user.getRecentDate());
            count=stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilDB.closeParament(null,stat,conn,null);
        }
        if(count!=0)
            return  true;
        return false;
    }

    @Override
    public boolean notExistUserName(String userName) {
        boolean flag=false;
        StringBuffer sqlbuf=new StringBuffer();
        sqlbuf.append("select username from user where username=?");
        Connection conn= UtilDB.getConn();
        PreparedStatement stat=null;
        ResultSet res=null;
        try {
            stat=conn.prepareStatement(sqlbuf.toString());
            stat.setString(1,userName);
            res=stat.executeQuery();
            if(!res.next()){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilDB.closeParament(null,stat,conn,res);
        }
        System.out.println(flag);
        return flag;
    }

    @Override
    public boolean notExistCardID(String cardID) {
        boolean falg=false;
        StringBuffer sqlbuff=new StringBuffer();
        sqlbuff.append("select cardid from user where cardid=?");
        Connection conn=UtilDB.getConn();
        PreparedStatement stat=null;
        ResultSet res=null;
        try {
            stat=conn.prepareStatement(sqlbuff.toString());
            stat.setString(1,cardID);
            res=stat.executeQuery();
            if(!res.next()){
                falg=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilDB.closeParament(null,stat,conn,res);
        }
        return falg;
    }
}
