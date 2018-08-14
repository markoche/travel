package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PictureService;
import service.SenicService;
import service.impl.PictureServiceImpl;
import service.impl.SenicServiceImpl;
import dao.SenicDao;
import dao.impl.SenicDaoImpl;
import entity.Picture;
import entity.Senic;

public class SearchSenicByCityNameServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ܲ�ѯ����
		String cityName=(String) request.getParameter("cityName");
		if("".equals(cityName.trim())){
			request.getRequestDispatcher("/WEB-INF/jsp/emptySearch.jsp").forward(request, response);
		}
		else{
		List<Senic> senicList=null;
		String[] pictures=null;
		//�����ѯ
		SenicService impls=new SenicServiceImpl();
		senicList= impls.getSenicByCityName(cityName);//�����б�

		//���ݾ����ҵ�һ��ͼƬ��
		PictureService pictureService=new PictureServiceImpl();
		pictures=pictureService.getPictures(senicList);

		//��������,�����б���ӦͼƬ
		//System.out.println("post������"+cityName+test+"������"+senicList.size());pass
		request.setAttribute("senicList", senicList);
		request.setAttribute("pictures", pictures);//ͼƬ�����Բ�ѯ���ľ���˳������
		//ת��
		request.getRequestDispatcher("/WEB-INF/jsp/senicList.jsp").forward(request, response);
		
	}
	}

}
