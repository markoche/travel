package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;
import entity.son_re;
import net.sf.json.JSON;
import service.SonRemarkService;
import service.impl.SonRemarkServiceImpl;

public class FaServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		SonRemarkService sonRemarkService = new SonRemarkServiceImpl();
		String content = (String) request.getParameter("content");
		int sId = Integer.parseInt(request.getParameter("uId"));
		int pla_re_id = Integer.parseInt(request.getParameter("pla_re_id"));
		System.out.println(sId + "content" + "----->" + content);
		Users myUsers = (Users) request.getSession().getAttribute("user");
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date curr;
		try {
			curr = formatter.parse(dateString);
			son_re re = new son_re();
			re.setSon_re_content(content);
			re.setSon_re_date(curr);
			re.setSon_re_my(myUsers.getId());
			re.setSon_re_to(sId);
			re.setPla_re_id(pla_re_id);
			boolean flag = sonRemarkService.makeSon_re(re);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
