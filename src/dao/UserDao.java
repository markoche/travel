package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Users;
import entity.son_re;

public interface UserDao {

	//���ݾ������۲��û���Ϣ
	public List<Users> getUser(int sen_id) throws SQLException;
	//����л������鿴��������Ϣ�ͱ���������Ϣ
	//ͨ��id���û�
	public Users getUsers(int user_id) throws SQLException;
	List<Users> getUserList() throws SQLException;
	//qzh
	//�����û���Ϣ
	int updateUser(Users users) throws SQLException;
}
