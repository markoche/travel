package service;

import java.sql.SQLException;
import java.util.List;

import entity.Senic;

/**
 * ͼƬ����ӿ�
 * @author hxs
 *
 */
public interface PictureService {
    //��ѯ����ͼƬ·��
	List getPicList(int sen_id) throws SQLException;
	/*
	 * ���ݾ����Ҷ�ӦͼƬ
	 */
	List getPictureList(String  senicName);
	//�õ�ÿ�������Ӧ��ͼƬ
	String[] getPictures(List<Senic> senicList);
}
