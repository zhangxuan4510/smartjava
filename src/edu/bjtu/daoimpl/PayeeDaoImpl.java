package edu.bjtu.daoimpl;

import edu.bjtu.dao.PayeeDao;
import edu.bjtu.model.Payee;
import edu.bjtu.util.UtilDB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangxuan on 2016/7/10.
 */
public class PayeeDaoImpl implements PayeeDao {
    @Override
    public boolean addPayee(Payee payee,String userName) {
        boolean falg=false;
        int count=0;
        Connection conn= UtilDB.getConn();
        System.out.println(conn);
        QueryRunner qr=new QueryRunner();
        String sql="insert into t_payee(userName,account,name,address,swiftCode,bankName,bankAddress) values(?,?,?,?,?,?,?)";
        Object obj[]={userName,payee.getAccount(),payee.getName(),payee.getAddress(),payee.getSwiftCode(),payee.getBankName(),payee.getBankAddress()};
        try {
            count=qr.update(conn,sql,obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilDB.closeConn(conn);
        }
        if(count!=0)
            falg=true;
        else
            System.out.println("添加失败");
        return falg;
    }

    @Override
    public List<Payee> queryPayee(String custID) {
        List<Payee> payees=null;
        Connection conn=UtilDB.getConn();
        String sql="select account,name,address,swiftCode,bankName,bankAddress from t_payee";
        QueryRunner qr=new QueryRunner();
        try {
            payees = (List<Payee>)qr.query(conn, sql, new BeanListHandler(Payee.class) );
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilDB.closeConn(conn);
        }
        return payees;
    }

    @Override
    public boolean deletePayee(String accounts, String userName) {
        String accountArr[]=accounts.split("-");
        int count=0;
        Connection conn=UtilDB.getConn();
        QueryRunner qr=new QueryRunner();
            try {
                for(int i=0;i<accountArr.length;i++) {
                    System.out.println("The account is " + accountArr[i]);
                    String sql = "delete from t_payee where userName=? and account=?";
                    Object[] obj = {userName, accountArr[i]};
                    int c=qr.update(conn, sql, obj);
                    if(c>0)
                        count++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                UtilDB.closeConn(conn);
            }
        System.out.println(count+" 条记录已经被成功删除");
        if(count>0)
            return true;
        return false;
    }

    @Override
    public boolean updatePayee(Payee payee, String userName, String oldAccount) {
        String sql="update t_payee set account=?,name=?,address=?,swiftCode=?,bankName=?,bankAddress=? where userName=? and account=?";
        Object obj[]={payee.getAccount(),payee.getName(),payee.getAddress(),payee.getSwiftCode(),payee.getBankName(),
        payee.getBankAddress(),userName,oldAccount};
        Connection conn=UtilDB.getConn();
        QueryRunner qr=new QueryRunner();
        int count=0;
        try {
            count=qr.update(conn,sql,obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilDB.closeConn(conn);
        }
        if(count>0)
            return true;
        return false;
    }

    @Override
    public Payee getSelectPayee(String userName, String account) {
        String sql="select account,name,address,swiftCode,bankName,bankAddress from t_payee where userName=? and account=?";
        Connection conn=UtilDB.getConn();
        Payee payee=null;
        QueryRunner qr=new QueryRunner(UtilDB.getDataSource());
        System.out.println(UtilDB.getDataSource());
        Object[] obj={userName,account};
        try {
            payee=(Payee)qr.query(sql,new BeanHandler<Payee>(Payee.class),obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payee;
    }

    @Override
    public boolean checkNoAccount(String userName,String account) {
        boolean flag=false;
        StringBuffer sqlbuff=new StringBuffer();
        sqlbuff.append("select account from t_payee where userName=? and account=?");
        Connection conn=UtilDB.getConn();
        ResultSet res=null;
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(sqlbuff.toString());
            stat.setString(1,userName);
            stat.setString(2,account);
            res=stat.executeQuery();
            if(!res.next()){
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
