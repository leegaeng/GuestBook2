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

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		GuestbookDao dao = new GuestbookDao();

		if (id != null || password != null) {

			dao.delete(Integer.parseInt(id), password);

		}

		List<Guestbook> list = dao.fetchList();
		request.setAttribute("list", list);

		WebUtil.forward("/view/index.jsp", request, response);
	}

}
