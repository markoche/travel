package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Zan;

public interface ZanDao {

	//��������id��ȡ�޶���
	public List<Zan> getZan(int pla_re_id) throws SQLException;
	//ע������¼�
	public int makeZan(Zan zan) throws  SQLException;
}
