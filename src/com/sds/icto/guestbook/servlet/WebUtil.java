package com.sds.icto.guestbook.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {

	public static void forward(String path, HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {

		RequestDispatcher rd = req.getServletContext().getRequestDispatcher(
				path);

		rd.forward(req, res);

	}

}
