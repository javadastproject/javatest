<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Messages2</title>
</head>
<body>
	<%
	@SuppressWarnings("unchecked")
	List<String> list = (List<String>) request.getAttribute("list2");%>
	<form method="get" action="Conversations_host.html">
		<input type="submit" value="New theme" />
		<br>
		<%for (String str: list) {%>
			<textarea name="conversations2" id="conversations2" rows="30" cols="60"><%=str%></textarea>
			<br>
		<%} %>
	</form>
</body>
</html>