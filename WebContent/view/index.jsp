<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sds.icto.guestbook.dao.GuestbookDao"
	import="com.sds.icto.guestbook.vo.Guestbook" import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/GuestBook2/guestbook" method="post">
		<table border=1 width=500>
			<input type="hidden" name="gb" value="add" />
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="확인"></td>
			</tr>
		</table>
	</form>
	<br>

	<%
		List<Guestbook> list = (List<Guestbook>) request
				.getAttribute("list");

		if (list.size() > 0) {

			for (Guestbook g : list) {
	%>

	<table width=510 border=1>
		<tr>
			<td>[<%=g.getNo()%>]
			</td>
			<td><%=g.getName()%></td>
			<td><%=g.getReg_date()%></td>
			<td><a
				href="/GuestBook2/guestbook?gb=deleteform&id=<%=g.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=g.getMessage()%></td>
		</tr>
	</table>

	<%
		}
		} else {
	%>
	<table width=510 border=1>
		<tr>
			<td colspan=4>등록된 방명록이 없습니다.</td>
		</tr>
	</table>

	<%
		}
	%>
</body>
</html>