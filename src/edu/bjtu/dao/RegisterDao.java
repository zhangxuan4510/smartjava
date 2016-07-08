package edu.bjtu.dao;

import edu.bjtu.model.User;

/**
 * Created by zhangxuan on 2016/7/8.
 */
public interface RegisterDao {
    public boolean register(User user);
    public boolean notExistUserName(String userName);
    public boolean notExistCardID(String cardID);
}
