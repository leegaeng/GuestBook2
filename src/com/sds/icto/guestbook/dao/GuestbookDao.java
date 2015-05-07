package com.sds.icto.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.guestbook.vo.Guestbook;

public class GuestbookDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "webdb", "webdb");

		return conn;
	}

	public void insert(Guestbook g) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();

		String sql = "insert into guestbook values(guestbook_seq.nextval, ?, ?, ?, sysdate)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, g.getName());
		ps.setString(2, g.getPassword());
		ps.setString(3, g.getMessage());

		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("저장성공");
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}

	}

	public void delete(int id, String password) throws ClassNotFoundException,
			SQLException {
		Connection conn = getConnection();

		String sql = "delete from guestbook where no = ? and password = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, password);

		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("삭제성공");
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

	public List<Guestbook> fetchList() throws ClassNotFoundException,
			SQLException {
		List<Guestbook> list = new ArrayList<Guestbook>();

		Connection conn = getConnection();

		String sql = "select * from guestbook";

		Statement s = conn.prepareStatement(sql);

		ResultSet rs = s.executeQuery(sql);

		while (rs.next()) {
			Guestbook g = new Guestbook(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4),rs.getString(5));
			list.add(g);
		}

		if (rs != null) {
			rs.close();
		}

		if (s != null) {
			s.close();
		}

		if (conn != null) {
			conn.close();
		}
		return list;
	}

}
