package service;

import java.sql.SQLException;
import java.util.List;

import entity.place_remark;

/**
 * �������۷���ӿ�
 * @author hxs
 *
 */
public interface PlaceRemarkService {

	//�����������
	public int getRemark(int sen_id) throws SQLException;
	//��ʱ���ǰ����������Ϣ
	public List<place_remark> getReList(int sen_id,int a,int b) throws SQLException;
	//����
	public void hit(int amount,int pla_re_id) throws SQLException;
	//ע������
	public boolean re_pla_re(place_remark place_remark) throws SQLException;
}
