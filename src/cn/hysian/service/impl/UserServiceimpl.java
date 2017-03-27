package cn.hysian.service.impl;

import cn.hysian.dao.UserDao;
import cn.hysian.dao.impl.UserDaoiml;
import cn.hysian.service.UserService;

public class UserServiceimpl implements UserService {
	
	private UserDao userDao = new UserDaoiml();
	@Override
	public boolean loginUser(String mail, String passwd) {
		return userDao.checkLogin(mail, passwd) >0 ? true:false;
	}

	@Override
	public boolean isExist(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
