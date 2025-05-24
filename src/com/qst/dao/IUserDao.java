package com.qst.dao;

import com.qst.pojo.User;

/**
 *
 * @author qst
 *
 * 用户Dao接口
 *
 */
public interface IUserDao {
    /**
     * 登录验证
     * @param uname
     * @param upass
     * @return
     */
    User verifyLogin(String uname,String upass);
}
