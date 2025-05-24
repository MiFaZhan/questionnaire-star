package com.qst.pojo;
/**
 *
 * @author qst
 *
 * User实体类
 *
 */
public class User {
    private Integer userId;
    private String userLogin;
    private String userNick;
    private String userPass;
    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
    private Integer userStatus;
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getUserId() {
        return userId;
    }
    public String getUserLogin() {
        return userLogin;
    }
    public String getUserNick() {
        return userNick;
    }
    public String getUserPass() {
        return userPass;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userLogin=" + userLogin + ", userNick=" + userNick + ", userPass="
                + userPass + ", userStatus=" + userStatus + "]";
    }
}
