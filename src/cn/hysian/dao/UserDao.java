package cn.hysian.dao;

import java.util.List;

import cn.hysian.pojo.User;

public interface UserDao {
	//登陆验证
	public int checkLogin(String mail, String passwd);
	//创建用户
	public int createUser(User form);
	//删除用户
	public int deleteUser(int id);
	//修改资料
	public int updateUser(User form);
	//返回所有用户
	public List<User> getUsers();
	//单个用户
	public User getUser(int id);
}
