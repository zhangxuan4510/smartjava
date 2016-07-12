 package edu.bjtu.daoimpl;

import edu.bjtu.dao.RegisterDao;
import edu.bjtu.model.User;
import edu.bjtu.util.UtilDB;
import net.sf.json.JSONArray;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
        QueryRunner qr=new QueryRunner();
        Object[] obj={user.getCustID(),user.getName(),user.getUserName(),user.getUserPwd(),user.getCardID(),
        user.getPhone(),user.getEmail(),user.getAddress(),user.getRegisterDate(),user.getRecentDate()};
        try {
            count=qr.update(conn,sqlbuff.toString(),obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilDB.closeConn(conn);
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

    public String getUserByJson(){

        List<User> users=null;
        JSONArray json=JSONArray.fromObject(users);
        return json.toString();

    }
}
