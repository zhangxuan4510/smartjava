package edu.bjtu.dao;

import edu.bjtu.model.Payee;

import java.util.List;

/**
 * Created by zhangxuan on 2016/7/10.
 */
public interface PayeeDao {
    public boolean addPayee(Payee payee,String custID);
    public List<Payee> queryPayee(String custID);
    public boolean deletePayee(String accounts,String userName);
    public boolean updatePayee(Payee payee,String userName,String oldAccount);
    public Payee getSelectPayee(String userName,String accounts);
    public boolean checkNoAccount(String userName,String account);
}
