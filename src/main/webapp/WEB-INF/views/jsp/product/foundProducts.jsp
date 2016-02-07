<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>etnShop</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
<body>
<div class="container">
	<h2>Found products</h2>	
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Serial number</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${foundProducts}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.sn}</td>					
				</tr>	
			</c:forEach>
				<tr>
					<td colspan="3" align="right"><a class="btn btn-primary btn-lg" href="/etnshop/product/list" role="button">Back</a></td>		
				</tr>	
		</tbody>
	</table>
	<hr>
	<footer>
		<p>&copy; Etnetera a.s. 2015</p>
	</footer>
</div>

<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${bootstrapJs}"></script>
</body>
</html>