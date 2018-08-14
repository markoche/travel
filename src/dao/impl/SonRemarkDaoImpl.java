package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.PlaceRemarkDao;
import dao.SonRemarkDao;
import dao.UserDao;
import dbutil.DbUtil;
import entity.Users;
import entity.place_remark;
import entity.son_re;

public class SonRemarkDaoImpl implements SonRemarkDao {
	PlaceRemarkDao pla_reDao = new PlaceRemarkDaoImpl();
	UserDao userDao = new UserDaoImpl();

	// �������۲鿴�Ƿ��лظ�
	@Override
	public List<son_re> getSon(int sen_id, int a, int b) throws SQLException {
		List<son_re> sonList = new ArrayList();
		// TODO Auto-generated method stub
		return sonList;
	}

	/*
	 * ���ݾ������۲�ѯ�ǻ���(non-Javadoc) ����з��أ�û�з��ؿ�
	 */
	public List<son_re> getSonList(int pla_re_id) throws SQLException {
		List<son_re> list = new ArrayList<son_re>();
		QueryRunner runner = new QueryRunner(DbUtil.dataSource);
		String sql = "SELECT * FROM son_remark WHERE pla_re_id=? ORDER BY son_re_date DESC";
		Object[] param = { pla_re_id };
		try {
			list = runner.query(sql, param, new BeanListHandler<son_re>(son_re.class));
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	// �������Ϣ
	public son_re getSonMy(int son_re_to) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DbUtil.dataSource);
		String sql = "SELECT * FROM son_remark WHERE son_re_to =?";
		Object[] param = { son_re_to };
		son_re re = runner.query(sql, param, new BeanHandler<son_re>(son_re.class));
		return re;
	}

	// ���ݻ���id��ѯ������Ϣ
	public son_re getSonInfo(int son_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DbUtil.dataSource);
		String sql = "SELECT * FROM son_remark WHERE son_re_id =?";
		Object[] param = { son_id };
		son_re re = runner.query(sql, param, new BeanHandler<son_re>(son_re.class));
		return re;
	}

	@Override
	// ע�����
	public int makeSon_re(son_re re) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DbUtil.dataSource);
		String sql = "INSERT INTO son_remark VALUES(null,?,?,?,?,?)";
		Object[] param = { re.getSon_re_content(), re.getSon_re_date(), re.getSon_re_to(), re.getSon_re_my(),
				re.getPla_re_id() };
		int count = runner.update(sql, param);
		return count;
	}

	// qzh
	@Override
	public List getSonRemark(int son_re_to) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DbUtil.dataSource);
		String sql = "SELECT * FROM son_remark where son_re_to=?";
		Object params[] = { son_re_to };
		List<son_re> list = runner.query(sql, params, new BeanListHandler(son_re.class));
		return list;
	}

}
