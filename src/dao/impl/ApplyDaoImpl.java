package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.ApplyDao;
import dbutil.DbUtil;
import entity.Apply;

public class ApplyDaoImpl implements ApplyDao{

	@Override
	public List getapplylist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteapply(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	//qzh
	/*
	 * ���ݽ��������˲������
	 * 
	 */
		@Override
		public List getapplylist(int apply_suser) throws SQLException {
			// TODO Auto-generated method stub
			QueryRunner runner=new QueryRunner(DbUtil.dataSource);
			String sql="SELECT * FROM apply where apply_suser=?";
			Object params[]={apply_suser};
			List list=runner.query(sql, params, new BeanListHandler(Apply.class));
			//System.out.println(list.toString());
			return list;
		}
		//ly
		// ���ݽ�����id�õ�����������б�
		@Override
		public List<Apply> getActapList1(int apply_suser) throws SQLException {
			QueryRunner run= new QueryRunner(DbUtil.dataSource);
			String sql ="SELECT * FROM apply WHERE apply_suser=?";
			Object[] params={apply_suser};
			List list=(List)run.query(sql, new BeanListHandler(Apply.class),params);
			return list;
		}
		// ����������id�õ�����������б�
		@Override
		public List<Apply> getActapList2(int apply_fuser) throws SQLException {
			QueryRunner run= new QueryRunner(DbUtil.dataSource);
			String sql ="SELECT * FROM apply WHERE apply_fuser=?";
			Object[] params={apply_fuser};
			List list=(List)run.query(sql, new BeanListHandler(Apply.class),params);
			return list;	
		}
		// ����һ���µĻ������
		@Override
		public int addActap(int apply_suser,int apply_fuser,int act_id) throws SQLException {
			QueryRunner run=new QueryRunner(DbUtil.dataSource);
			String sql ="INSERT INTO apply VALUES(null,?,'ͨ��',?,?)";	
			Object param[]={apply_suser,apply_fuser,act_id};
			return run.update(sql,param);
		}
		//���ܻ������
		@Override
		public int acceptActap(int apply_id) throws SQLException {
			QueryRunner run=new QueryRunner(DbUtil.dataSource);
			String sql ="UPDATE apply SET apply_condition='ͨ��' WHERE apply_id=?";	
			Object param[]={apply_id};
			return run.update(sql,param);
		}
		//�ܾ��������
		@Override
		public int rejectActap(int apply_id) throws SQLException {
			QueryRunner run=new QueryRunner(DbUtil.dataSource);
			String sql ="DELETE FROM apply WHERE apply_id=?";	
			Object param[]={apply_id};
			return run.update(sql,param);
		}

		

}
