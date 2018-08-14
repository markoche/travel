package service.impl;

import java.sql.SQLException;
import java.util.List;

import dao.PictureDao;
import dao.impl.PictureDaoImpl;
import entity.Senic;
import service.PictureService;

public class PictureServiceImpl implements PictureService {
   PictureDao picDao=new PictureDaoImpl();
	@Override
	//���ݾ�������ȡ��������ͼƬ
	public List getPicList(int sen_id) throws SQLException {
		// TODO Auto-generated method stub
		
		return picDao.getPicList(sen_id);
	}

	@Override
	//���ݾ������õ�ͼƬ��������
	public List getPictureList(String senicName) {
		PictureDao pictureDao=new PictureDaoImpl();
		List pictureList=null;
		try {
			pictureList = pictureDao.getPictureList(senicName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pictureList;
		
	}

	@Override
	//���ݾ�������õ�ÿ������ĵ�һ��ͼƬ·��
	public String[] getPictures(List<Senic> senicList) {
		String[] pictures=new String[20];
		PictureDao pictureDao=new PictureDaoImpl();
		
		for (int i = 0; i <senicList.size(); i++) {
			try {
				//���о��㣬����ͼ����i������ĵ�1��ͼƬ
				
				pictures[i]=pictureDao.getPictureBySenicName(senicList.get(i).getSen_name());//���ص�һ��ͼƬ
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return pictures;
	}
	
}
