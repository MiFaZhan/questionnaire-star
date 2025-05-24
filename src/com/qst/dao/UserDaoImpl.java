package com.qst.dao;

import com.qst.pojo.User;
import com.qst.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author qst
 *
 * 用户Dao接口实现类
 *
 */
public class UserDaoImpl implements IUserDao{

    @Override
    public User verifyLogin(String uname, String upass) {
        User user=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //加载驱动
        try {
            conn=DBUtil.getConn();
            String sql="SELECT user_id,user_nick,user_login,user_pass FROM user WHERE user_login=? and user_pass=?";
            //3.获取预处理对象
            pstmt=conn.prepareStatement(sql);
            //给参数赋值
            pstmt.setString(1, uname);
            pstmt.setString(2, upass);
            //4.执行sql语句.
            rs=pstmt.executeQuery();
            if(rs.next()) { //通过循环遍历所有数据
                user=new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserLogin(rs.getString("user_login"));
                user.setUserNick(rs.getString("user_nick"));
                user.setUserPass(rs.getString("user_pass"));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {//5.资源得释放
            DBUtil.closeAll(conn, pstmt, rs);
        }
        return user;
    }

}
