package edu.bjtu.dao;

/**
 * Created by zhangxuan on 2016/7/10.
 */
public interface LoginDao {
    //用户名登录
    public boolean userNameLogin(String userName,String password);
}
