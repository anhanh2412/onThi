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
        	<a href="insert">Them Ton Kho</a>
        	<a href="list">Danh Sach Ton Kho</a>
        	
        </h2>
</center>
	<div align="center">
		<c:if test="${tk != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${tk == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${tk != null}">
            			Edit Book
            		</c:if>
            		<c:if test="${tk == null}">
            			Add New Book
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${tk != null}">
        			<input type="hidden" name="id" value="<c:out value='${tk.id}'/>"/>
        		</c:if>            
            <tr>
                <th>ID cua hang: </th>
                <td>
                	<input type="number" name="idCH" size="45"
                	 value='${tk.idCH}'/>
                		
                </td>
            </tr>
            <tr>
                <th>ID mat hang: </th>
                <td>
                	<input type="number" name="idMH" size="45"
                	value="<c:out value='${tk.idMH}' />"/>
                			
                </td>
            </tr>
            <tr>
                <th>So luong: </th>
                <td>
                	<input type="number" name="sl" size="5"
                	value="<c:out value='${tk.sl}' />"/>
                			
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>