package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Users;
import entity.son_re;

public interface SonRemarkDao {

	    //��ѯ�û��Ƿ��лظ�����
		public List<son_re> getSon(int sen_id,int a,int b) throws SQLException;
	    //�����ӻظ�����һ�����id
		public son_re getSonMy(int son_re_my) throws SQLException;
		//����
		public int makeSon_re(son_re re) throws SQLException;
		//qzh
		 List getSonRemark(int son_re_to) throws SQLException;
		
}
