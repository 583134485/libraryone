<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>borrow List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of borrow</span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>borrowid</th>
				        <th>bookid</th>
				        <th>userid</th>
				        <th>borrowdate</th>
				        <th>returndate</th>
				        <th>borrowstate</th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${borrows}" var="borrow">
					<tr>
						<td>${borrow.borrowid}</td>
						<td>${borrow.bookid}</td>
						<td>${borrow.userid}</td>
						<td>${borrow.borrowdate}</td>
						<th>${borrow.returndate}</th>
						<th>${borrow.borrowstate}</th>
						<td><a href="<c:url value='/edit-borrow-${borrow.borrowid}' />" class="btn btn-success custom-width">edit</a></td>
						<td><a href="<c:url value='/delete-borrow-${borrow.borrowid}' />" class="btn btn-danger custom-width">delete</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newborrow' />"> New Borrow</a>
	 	</div>
   	</div>
</body>
</html>