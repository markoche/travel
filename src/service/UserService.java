package service;

import java.sql.SQLException;
import java.util.List;

import entity.Users;

/**
 * �û���Ϣ����ӿ�
 * @author hxs
 *
 */
public interface UserService {

	//���ݾ������۲��û���Ϣ
		public List<Users> getUser(int sen_id,int a,int b) throws SQLException;
	//����л������鿴��������Ϣ�ͱ���������Ϣ
		public List<Object> getReUser(int sen_id,int a,int b) throws SQLException;
    //lyd
		List<Users> getUserList() throws SQLException;
	//qzh
		 boolean UpdateUser(Users users);
}
