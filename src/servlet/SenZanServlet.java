package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;
import entity.place_remark;
import entity.son_re;
import service.PlaceRemarkService;
import service.SonRemarkService;
import service.UserService;
import service.impl.PlaceRemarkServiceImpl;
import service.impl.SonRemarkServiceImpl;
import service.impl.UserServiceImpl;

public class SenZanServlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//��url�л�ȡ����id
//		int sen_id=Integer.parseInt(request.getParameter("id"));
//		//��ȡ����������
//		PlaceRemarkServiceImpl prs=new PlaceRemarkServiceImpl();
//		UserService userSvice=new UserServiceImpl();
//		SonRemarkService sonService=new SonRemarkServiceImpl();
//		UserServiceImpl usip=new UserServiceImpl();
//		try{
//			int amount=prs.getRemark(sen_id);
//			request.setAttribute("amount", amount);
//			//��ȡ���۵�������Ϣ
//			List<place_remark> pla_reList=prs.getZanList(sen_id);
//			request.setAttribute("remarkList", pla_reList);
//						
//			//������
//			List<Users> uList=usip.getZanUser(sen_id, 1,4);
//			request.setAttribute("uList", uList);
//			System.out.println("uList--->"+uList.size()+uList.toString());
//			
//			//�鿴�Ƿ��л���
//			List<son_re> sonList=sonService.getSon(sen_id,1, 4);
//			request.setAttribute("sonList", sonList);
//			System.out.println("sonList--->"+sonList.size());
//			//�����˵���Ϣ
//			List<Users> reUList =usip.getZanReUser(sen_id, 1, 4);
//			request.setAttribute("reUList", reUList);
//			System.out.println("reUList--->"+reUList.size());
//			request.getRequestDispatcher("senicRemark.jsp").forward(request, response);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	}


