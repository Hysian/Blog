package cn.hysian.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hysian.dao.BaseDao;
import cn.hysian.dao.UserDao;
import cn.hysian.pojo.User;

public class UserDaoiml extends BaseDao implements UserDao{

	@Override
	public int checkLogin(String mail, String passwd) {
		getConnection();
		String sql = "SELECT COUNT(1) FROM user WHERE mail=? AND passwd=?";
		int num = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setString(2, passwd);
			rs = ps.executeQuery();
			rs.next();
			num = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return num;
	}

	@Override
	public int createUser(User form) {
		getConnection();
		String sql = "INSERT user(nick,passwd,mail) VALUES(?,?,?)";
		int num = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, form.getName());
			ps.setString(2, form.getPasswd());
			ps.setString(3, form.getMail());
			num = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeConnection();
		}
		return num;
		
	}

	@Override
	public int deleteUser(int id) {
		getConnection();
		String sql = "DELETE FROM user WHERE id =?";
		int num = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			num = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return num;
	}

	@Override
	public int updateUser(User form) {
		getConnection();
		String sql = "UPDATE user SET nick=?, passwd=?, mail=? WHERE id=?";
		int num = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, form.getName());
			ps.setString(2, form.getPasswd());
			ps.setString(3, form.getMail());
			ps.setInt(4, form.getId());
			num = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeConnection();
		}
		return num;
	}

	@Override
	public List<User> getUsers() {
		getConnection();
		String sql = "SELECT * FROM user";
		List<User> list = new ArrayList();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPasswd(rs.getString(3));
				user.setMail(rs.getString(4));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeConnection();
		}
		return list;
	}

	@Override
	public User getUser(int id) {
		getConnection();
		String sql = "SELECT * FROM user WHERE id =?";
		User user = new User();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			user.setId(id);
			user.setName(rs.getString(2));
			user.setPasswd(rs.getString(3));
			user.setMail(rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return user;
	}
	
}
