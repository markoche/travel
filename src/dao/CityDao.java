package dao;

import java.sql.SQLException;
import java.util.List;

public interface CityDao {
	List getcitylist();//��ȡ���г����б�
	int addcity();//��ӳ��з���
	int updatecity(int id);//�޸ĳ��з���
	int deletecity(int id);//ɾ�����з���
	String getPro(String city_name) throws SQLException;

}
