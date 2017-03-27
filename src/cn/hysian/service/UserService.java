package cn.hysian.service;

public interface UserService {
	//登陆验证
	public boolean loginUser(String mail, String passwd);
	//用户名是否存在
	public boolean isExist(String name);
}
