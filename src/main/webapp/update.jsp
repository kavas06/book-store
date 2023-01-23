<%@page import="com.js.dto.Book" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ENTER BOOK DETAILS TO UPDATE</h1>
	<% Book bo=(Book)request.getAttribute("book"); %>
	<form action="update2">
	BOOK_ID : <input type="number" name="id" value="<%=bo.getBookid()%>" readonly="readonly"><br><br>
	BOOK_NAME : <input type="text" name="bookname" value="<%= bo.getBookname()%>"><br> <br>
	AUTHOR_NAME : <input type="text" name="authorname" value="<%= bo.getBook_authorname()%>"><br><br>
	PAGES :<input type="number" name="pages" value="<%= bo.getNoofpages()%>"><br><br>
	PRICE : <input type="number" name="price" value="<%=bo.getPrice()%>"><br><br>
	<input type="submit" value="update">
	</form>
	<h2><a href="welcome.html">home</a></h2>
</body>
</body>
</html>