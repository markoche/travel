package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.TripDaoImpl;

public class FenYeServlet extends HttpServlet {


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		TripDaoImpl tDao=new TripDaoImpl();
		int page=Integer.parseInt(request.getParameter("page"));//用户想去的页数
		int total=123;//总记录数
		int itemsPerPage=10;//每页记录数
		int totalPages=total/itemsPerPage;//总页数
		if(total % itemsPerPage !=0){
			totalPages+=1;
		}
		Vector<Integer> pageArr=new Vector<Integer>();
		int start=1;
		if(page>=10){
			start=page/10*10;
		}
		int num=start;//当前页面的第一个页数值
		while(!(num>totalPages || num>start+10)){
			pageArr.add(new Integer(num));
			++num;
		}
	}

}
