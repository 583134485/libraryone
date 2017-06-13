<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Book Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="generic-container">
	<div class="well lead">Book editForm</div>
 	<form:form method="POST" modelAttribute="book" class="form-horizontal">
		<form:input type="hidden" path="bookid" id="bookid" />
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="bookname">bookname</label>
				<div class="col-md-7">
					<form:input type="text" path="bookname" id="bookname" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="bookname" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

<%-- 		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="username">username</label>
				<div class="col-md-7">
					<form:input type="text" path="username" id="username" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="username" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="userclass">userclass</label>
				<div class="col-md-7">
					<c:choose>
						<c:when test="${edit}">
							<form:input type="text" path="userclass" id="userclass" class="form-control input-sm" />
						</c:when>
						<c:otherwise>
							<form:input type="text" path="userclass" id="userclass" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="userclass" class="help-inline"/>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div> --%>

	<%-- 	<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="password">Password</label>
				<div class="col-md-7">
					<form:input type="password" path="password" id="password" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="password" class="help-inline"/>
					</div>
				</div>
			</div>
		</div> --%>

<%-- 		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email">Email</label>
				<div class="col-md-7">
					<form:input type="text" path="email" id="email" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="email" class="help-inline"/>
					</div>
				</div>
			</div>
		</div> --%>

	<%-- 	<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="userProfiles">Roles</label>
				<div class="col-md-7">
					<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="userProfiles" class="help-inline"/>
					</div>
				</div>
			</div>
		</div> --%>

		<div class="row">
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/booklist' />">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/booklist' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div> 
	</form:form>
	</div>
</body>
</html>