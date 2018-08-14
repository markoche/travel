package service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.PlaceRemarkDao;
import dao.SonRemarkDao;
import dao.UserDao;
import dao.impl.PlaceRemarkDaoImpl;
import dao.impl.SonRemarkDaoImpl;
import dao.impl.UserDaoImpl;
import dbutil.DbUtil;
import entity.Users;
import entity.place_remark;
import entity.son_re;
import service.SonRemarkService;

public class SonRemarkServiceImpl implements SonRemarkService {
   PlaceRemarkDao pla_reDao=new PlaceRemarkDaoImpl();
   UserDao userDao=new UserDaoImpl();
	SonRemarkDao sonDao=new SonRemarkDaoImpl();
	SonRemarkDaoImpl sondd=new SonRemarkDaoImpl();
	//获取是否含有评论
	@Override
	public List<Object> getSon(int sen_id,int a,int b) throws SQLException {
		// TODO Auto-generated method stub
		SonRemarkDaoImpl sDao=new SonRemarkDaoImpl();
		//对应景点的所有评论
		List<place_remark> list=pla_reDao.getReList(sen_id,a, b);
		 List<Object> oList=new ArrayList<Object>();
		List<son_re> sonList=new ArrayList();
		if(list!=null){
		for (int i = 0; i < list.size(); i++) {
			List<son_re> sList=sDao.getSonList(list.get(i).getPla_re_id());
			List<son_re> uulist=new ArrayList<son_re>();  
			if(sList!=null){
			
		 oList.add(sList);
		   System.out.println("oList"+oList.size());
		    }
			else{
				oList.add(null);
			}
		}
		}
		else{
			oList= null;
		}
		return oList;
		
	}
	//注册景点
	@Override
	public boolean makeSon_re(son_re re) throws SQLException {
		// TODO Auto-generated method stub
		int count=sonDao.makeSon_re(re);
		boolean flag=false;
		if(count>0){
			flag=true;
		}
		return flag;
	}
	//qzh
	@Override
	public List getSonRemark(int son_re_to) throws SQLException {
		//SonRemarkService remarkService=new SonRemarkServiceImpl();
		SonRemarkDao remarkDao=new SonRemarkDaoImpl();
		List list=remarkDao.getSonRemark(son_re_to);
		return list;
	}

}
