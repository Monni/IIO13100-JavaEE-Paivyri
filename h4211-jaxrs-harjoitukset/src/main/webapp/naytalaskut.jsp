<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercise02</title>
</head>
<body>
<h1>Exercise04b: Tietojen nayttaminen kannasta</h1>
<sql:setDataSource var="snapshot" driver="org.h2.Driver"
     url="jdbc:h2:tcp://localhost/~/softat/h2/demo;DATABASE_TO_UPPER=false;MODE=MySQL;"
     user="sa"  password=""/>
     <sql:query dataSource="${snapshot}" var="rs">
     SELECT * FROM calculation
     </sql:query>

<table border="1" width="100%">
<tr>
<th>ID</th>
<th>LEFT</th>
<th>OPERATION</th>
<th>RIGHT</th>
<th>RESULT</th>
</tr>
<c:forEach var="row" items="${rs.rows}">
<tr>
<td><c:out value="${row.id}"/></td>
<td><c:out value="${row.left}"/></td>
<td><c:out value="${row.operation}"/></td>
<td><c:out value="${row.right}"/></td>
<td><c:out value="${row.result}"/></td>
</tr>
</c:forEach>
</table>


</body>
</html>
