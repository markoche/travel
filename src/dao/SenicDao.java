package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Senic;

public interface SenicDao {

	public Senic getSenic(int sen_id) throws SQLException;
	   List<Senic> getSenList();
	//���ݳ������Ҿ���
		List getSenicByCityName(String cityName) throws SQLException;
		//���ݾ��������Ҿ�����Ϣ
		List getSenicByName(String senicName) throws SQLException;
}
