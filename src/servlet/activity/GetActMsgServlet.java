package servlet.activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ActivityMessageService;
import service.impl.ActivityMessageServiceImpl;



public class GetActMsgServlet extends HttpServlet {

	/**
	 * �õ����л�б�
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String act_id=request.getParameter("act_id");
		ActivityMessageService service=new ActivityMessageServiceImpl();
		List list=service.getActmsgList(Integer.parseInt(act_id));
		request.setAttribute("activityMessage", list);
		request.getRequestDispatcher("activity/act.jsp").forward(request, response);
		out.flush();
		out.close();
	}

}
