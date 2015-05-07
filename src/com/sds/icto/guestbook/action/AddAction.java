package com.sds.icto.guestbook.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.dao.GuestbookDao;
import com.sds.icto.guestbook.servlet.WebUtil;
import com.sds.icto.guestbook.vo.Guestbook;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {

		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String message = request.getParameter("content");

		GuestbookDao dao = new GuestbookDao();

		if (name != null || password != null || message != null) {
			dao.insert(new Guestbook(name, password, message));
		}

		List<Guestbook> list = dao.fetchList();
		request.setAttribute("list", list);

		WebUtil.forward("/view/index.jsp", request, response);
	}

}
