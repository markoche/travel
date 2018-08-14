package service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.PlaceRemarkDao;
import dao.SonRemarkDao;
import dao.UserDao;
import dao.impl.PlaceRemarkDaoImpl;
import dao.impl.SonRemarkDaoImpl;
import dao.impl.UserDaoImpl;
import dbutil.DbUtil;
import entity.Users;
import entity.place_remark;
import entity.son_re;
import service.UserService;

public class UserServiceImpl implements UserService {
	PlaceRemarkDao pla_reDao = new PlaceRemarkDaoImpl();
	UserDao userDao = new UserDaoImpl();
	SonRemarkDao sonDao = new SonRemarkDaoImpl();

	@Override
	// 前几条发帖的用户
	public List<Users> getUser(int sen_id, int a, int b) throws SQLException {
		// TODO Auto-generated method stub
		List<place_remark> list = pla_reDao.getReList(sen_id, a, b);
		if (list != null) {
			List<Users> uList2 = new ArrayList<Users>();
			// 根据景点id查询发帖的用户
			for (int i = 0; i < list.size(); i++) {
				Users users = new Users();
				users = userDao.getUsers(list.get(i).getPla_re_user());
				uList2.add(users);
			}
			return uList2;
		} else {
			return null;
		}

	}

	@Override
	// 回帖用户
	public List<Object> getReUser(int sen_id, int a, int b) throws SQLException {
		// TODO Auto-generated method stub
		SonRemarkDaoImpl sDao = new SonRemarkDaoImpl();
		// 对应景点的所有评论
		List<place_remark> list = pla_reDao.getReList(sen_id, a, b);
		List<Object> ouList = new ArrayList<Object>();
		List<son_re> sonList = new ArrayList();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				List<son_re> sList = sDao.getSonList(list.get(i).getPla_re_id());
				List<Users> uulist = new ArrayList<Users>();
				if (sList != null) {
					System.out.println("slist" + sList.size());
					for (int j = 0; j < sList.size(); j++) {
						Users u = new Users();
						u = userDao.getUsers(sList.get(j).getSon_re_my());
						uulist.add(u);

					}
					ouList.add(uulist);
					System.out.println("oulist" + ouList.size());
				} else {
					ouList.add(null);
				}
			}
		} else {
			ouList = null;
		}
		return ouList;
	}

	// lyd
	// 所有用户信息
	public List<Users> getUserList() throws SQLException {
		UserDaoImpl userList = new UserDaoImpl();
		List<Users> list = userList.getUserList();
		return list;
	}

	// qzh
	// 更新用户信息
	@Override
	public boolean UpdateUser(Users users) {
		boolean flag = false;
		UserDao userDao = new UserDaoImpl();
		int count;
		try {
			count = userDao.updateUser(users);
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return flag;
	}

}
