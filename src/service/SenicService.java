package service;

import java.sql.SQLException;
import java.util.List;

import entity.Province;
import entity.Senic;

/**
 * �������ӿ�
 * @author hxs
 *
 */
public interface SenicService {
	public Senic getSenic(int sen_id);
	//���ݾ��������ʡ��
	public String getPro(int sen_id) throws SQLException ;
	//���ݳ������Ҿ���
		List getSenicByCityName(String cityName);
		//���ݾ��������Ҿ�����Ϣ
		List getSenicByName(String senicName);
		//lyd
		List<Senic> getSenicList() throws SQLException;
}
