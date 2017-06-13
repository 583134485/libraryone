<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>borrow Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="generic-container">
	<div class="well lead">borow editForm</div>
 	<form:form method="POST"  modelAttribute="book_borrow" class="form-horizontal">
		<form:input type="hidden" path="borrowid" id="borrowid" />
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="bookid">bookid</label>
				<div class="col-md-7">
					<form:input type="text" path="bookid" id="bookid" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="bookid" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="userid">userid</label>
				<div class="col-md-7">
					<form:input type="text" path="userid" id="userid" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="userid" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
	<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="borrowdate">borrowdate</label>
				<div class="col-md-7">
					<form:input type="text" path="borrowdate" id="borrowdate" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="borrowdate" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
			<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="returndate">returndate</label>
				<div class="col-md-7">
					<form:input type="text" path="returndate" id="returndate" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="returndate" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
				<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="borrowstate">borrowstate</label>
				<div class="col-md-7">
					<form:input type="text" path="borrowstate" id="borrowstate" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="borrowstate" class="help-inline"/>
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
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/bookborrowlist' />">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/bookborrowlist' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div> 
	</form:form>
	</div>
</body>
</html>