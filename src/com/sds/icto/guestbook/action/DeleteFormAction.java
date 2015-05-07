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

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");

		request.setAttribute("id", id);

		WebUtil.forward("/view/deleteform.jsp", request, response);

	}

}
