package com.sds.icto.guestbook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;

import com.sds.icto.guestbook.action.Action;
import com.sds.icto.guestbook.action.AddAction;
import com.sds.icto.guestbook.action.DeleteAction;
import com.sds.icto.guestbook.action.DeleteFormAction;
import com.sds.icto.guestbook.action.IndexAction;

@WebServlet("/guestbook")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestbookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			request.setCharacterEncoding("utf-8");
			String gb = request.getParameter("gb");
			Action action = null;

			if ("add".equals(gb)) {
				action = new AddAction();
				action.execute(request, response);

			} else if ("delete".equals(gb)) {
				action = new DeleteAction();
				action.execute(request, response);
			} else if ("deleteform".equals(gb)) {
				action = new DeleteFormAction();
				action.execute(request, response);
			} 

			if (action == null) {
				action = new IndexAction();
				action.execute(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
