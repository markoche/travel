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
		int page=Integer.parseInt(request.getParameter("page"));//�û���ȥ��ҳ��
		int total=123;//�ܼ�¼��
		int itemsPerPage=10;//ÿҳ��¼��
		int totalPages=total/itemsPerPage;//��ҳ��
		if(total % itemsPerPage !=0){
			totalPages+=1;
		}
		Vector<Integer> pageArr=new Vector<Integer>();
		int start=1;
		if(page>=10){
			start=page/10*10;
		}
		int num=start;//��ǰҳ��ĵ�һ��ҳ��ֵ
		while(!(num>totalPages || num>start+10)){
			pageArr.add(new Integer(num));
			++num;
		}
	}

}
