<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Bookborrow List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">BooksBorrow </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>BorrowID</th>
				        <th>BookId</th>
				        <th>UserId</th>
				        <th>BorrowDate</th>
				        <th>ReturnDate</th>
				        <th>BorrowState</th> 
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${book_borrow}" var="bookborrow">
					<tr>
						<td>${bookborrow.borrowid}</td>
						<th>${bookborrow.bookid}</th>
                        <th>${bookborrow.userid}</th>
						<td>${bookborrow.borrowdate}</td> 
						<td>${bookborrow.returndate}</td>
						<td>${bookborrow.borrowstate}</td> 
						<td><a href="<c:url value='/edit-bookborrow-${bookborrow.borrowid}' />" class="btn btn-success custom-width">edit</a></td>
					  <td><a href="<c:url value='/delete-bookborrow-${bookborrow.borrowid}' />" class="btn btn-danger custom-width">delete</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newborrow' />">NewBorrowBook</a>
	 	</div>
   	</div>
</body>
</html>