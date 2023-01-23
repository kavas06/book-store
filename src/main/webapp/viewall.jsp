<%@page import="java.util.ArrayList"%>
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
<h1>HERE THE BOOKS ARE</h1>
<table border="2px solid black">
        <tr>
        <th>Book_id</th>
        <th>Book_name</th>
        <th>Author_name</th>
        <th>No_of_pages</th>
        <th>pages</th>
        <th>delete</th>
        <th>update</th>
        </tr>
   <% ArrayList<Book> book=(ArrayList)request.getAttribute("book");
   for(Book b:book){%>
   <tr>
   <td><%= b.getBookid()%></td>
   <td><%= b.getBookname() %></td>
   <td><%=b.getBook_authorname()%></td>
   <td><%=b.getNoofpages()%></td>
   <td><%=b.getPrice() %></td>
    <td><a href="delete?id=<%=b.getBookid()%>">delete</a></td>
    <th><a href="update1?id=<%=b.getBookid()%>">edit</a></th>
    
   </tr>
   <%} %>
	 </table>
	 <h2><a href="welcome.html">home</a></h>
</body>
</html>