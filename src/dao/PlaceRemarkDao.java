package dao;

import java.sql.SQLException;
import java.util.List;

import entity.place_remark;

public interface PlaceRemarkDao {

	//�����������
	public int getRemark(int sen_id) throws SQLException;
	//��ǰ����������Ϣ
	public List<place_remark> getReList(int sen_id,int a,int b) throws SQLException;
	//����
	public void hit(int amount,int pla_re_id) throws SQLException;
	//ע�ᾰ��������Ϣ
	public int registPla_re(place_remark remark) throws SQLException;
}
