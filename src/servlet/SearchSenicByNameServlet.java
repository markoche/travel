package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class SearchSenicByNameServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		this.doPost(request, response);
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ܲ�ѯ����
		String searchSenic=req.getParameter("senicName");
		if("".equals(searchSenic.trim())){
			req.getRequestDispatcher("/WEB-INF/jsp/emptySearch.jsp").forward(req, resp);
		}
		else{
		String[] pictures=null;
		//�����ѯ
		SenicService senicService=new SenicServiceImpl();
		List<Senic> senicList=senicService.getSenicByName(searchSenic);
		//���ݾ�����չʾ�ĵ�һ��ͼƬ��
		PictureService pictureService=new PictureServiceImpl();
		pictures=pictureService.getPictures(senicList);
		//��������,�����б���ӦͼƬ		
		req.setAttribute("senicList", senicList);
		req.setAttribute("pictures", pictures);//ͼƬ�����Բ�ѯ���ľ���˳������
		//ת��
		req.getRequestDispatcher("/WEB-INF/jsp/senicList.jsp").forward(req, resp);
		
	}
	}

}
