<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>Quan Ly Ton Kho</h1>
	<h2>
	<a href="new">Them Moi Ton Kho</a>
	</h2>
</center>
<table border="1" cellpadding="5">
	<caption> Danh Sach Ton Kho</caption>
	<tr> 
		<th> ID</th>
		<th> Ma Cua Hang</th>
		<th> Ma Mat Hang</th>
		<th> So Luong </th>
		<th> Them, Xoa</th>
	</tr>
	<c:forEach var="tk" items="${listTK}" >
		<tr>
			<th><c:out value="${tk.getId()}"></c:out> </th>		
			<th><c:out value="${tk.getIdCH()}"></c:out> </th>
			<th><c:out value="${tk.getIdMatHang()}"></c:out> </th>
			<th><c:out value="${tk.getSoLuong()}"></c:out> </th>
			
				<a href="edit?id=<c:out value="${tk.id}"/>">Edit</a>
				<a href="delete?id=<c:out value="${tk.id}"/>">Delete</a>
			</th>
			
		</tr>
	 </c:forEach>
</table>
</body>
</html>