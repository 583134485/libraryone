<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>LoginForm</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="generic-container">
	<div class="well lead">User longin</div>
 	<form:form method="POST" modelAttribute="user" class="form-horizontal">
 	<!-- loing 不需要下面这个 -->
		<%-- <form:input type="hidden" path="userid" id="userid" /> --%>
		 <form:input type="hidden" path="userclass" id="userclass" />
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="username">username</label>
				<div class="col-md-7">
					<form:input type="text" path="username" id="username" class="form-control input-sm"/>
					 <div class="has-error">
						<form:errors path="username" class="help-inline"/>
					</div>  
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="userpassword">userpassword</label>
				<div class="col-md-7">
					<form:input type="password" path="userpassword" id="userpassword" class="form-control input-sm" />
					  <div class="has-error">
						<form:errors path="userpassword" class="help-inline"/>
					</div>  
				</div>
			</div>
		</div>

		<%-- <div class="row">
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
			<input type="submit" value="Login" class="btn btn-primary btn-sm"/> 
			or <a href="<c:url value='/' />">Cancel</a>
			<!--  <a href="<c:url value='/success' />这样写会错，原油马，估计不知道和controller 灭有“/success有关”    -->
			</div>
		   </div> 
	</form:form>
	</div>
	<%-- </div>
		<div class="row">
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/userlist' />">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/userlist' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div> 
	</form:form>
	</div> --%>
</body>
</html>