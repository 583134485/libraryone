<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Books List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Books </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>BookID</th>
				        <th>BookName</th>
				     <!--    <th>姓名</th>
				        <th>班级</th> -->
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td>${book.bookid}</td>
						<td>${book.bookname}</td>
					<%-- 	<td>${user.username}</td>
						<td>${user.userclass}</td> --%>
						<td><a href="<c:url value='/edit-book-${book.bookid}' />" class="btn btn-success custom-width">edit</a></td>
						<td><a href="<c:url value='/delete-book-${book.bookid}' />" class="btn btn-danger custom-width">delete</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newbook' />">Add New Book</a>
	 	</div>
   	</div>
</body>
</html>