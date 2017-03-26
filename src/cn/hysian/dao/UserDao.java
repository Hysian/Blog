package cn.hysian.dao;

import java.util.List;

import cn.hysian.pojo.User;

public interface UserDao {
	public int checkLogin(String mail, String passwd);
	public int createUser(User form);
	public int deleteUser(int id);
	public int updateUser(User form);
	public List<User> getUsers();
	public User getUser(int id);
}
