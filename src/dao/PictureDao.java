package dao;

import java.sql.SQLException;
import java.util.List;

public interface PictureDao {
	List getpicturelist();
   List getPicList(int sen_id) throws SQLException;
   /*
	 * ���ݾ����Ҷ�ӦͼƬ
	 */
	List getPictureList(String  senicName)throws SQLException;
	
	//����һ���������ҵ�һ��ͼƬ
	String getPictureBySenicName(String senicName)throws SQLException;
}
