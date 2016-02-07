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
	<h2>Products</h2>
	<a class="btn btn-primary btn-lg" href="/etnshop/product/newProduct" role="button">New Product</a>
	<a class="btn btn-primary btn-lg" href="/etnshop/product/search" role="button">Search for product</a>	
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Serial number</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.sn}</td>
					<td>
						<a class="btn btn-primary btn-lg" href="/etnshop/product/editProduct?id=${product.id}" role="button">Edit</a>
                        <a class="btn btn-primary btn-lg" href="/etnshop/product/deleteProduct?id=${product.id}" role="button">Delete</a>                        
                    </td>
				</tr>	
			</c:forEach>
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