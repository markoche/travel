package service;

import java.sql.SQLException;
import java.util.List;

import entity.Users;
import entity.son_re;


public interface SonRemarkService {
	
	//��ѯ�û��Ƿ��лظ�����
	public List<Object> getSon(int sen_id,int a,int b) throws SQLException;
	//����
	public boolean makeSon_re(son_re re) throws SQLException;
	//qzh
	List getSonRemark(int son_re_to) throws SQLException;
}
