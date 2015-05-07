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

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {

		GuestbookDao dao = new GuestbookDao();
		List<Guestbook> list = dao.fetchList();
		req.setAttribute("list", list);
		WebUtil.forward("/view/index.jsp", req, res);
		
	}

}
