<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>New/Edit Product</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
<body>
<div class="container">
    
        <h2>Search for product</h2>
        <form action="doSearch" method="post">
        <table class="table">
            <tr>
                <td>Search for:</td>
                <td><input type="text" name="searchText" class="form-control" /></td>
            </tr>            
            <tr>
            	<td colspan="2" align="right">            	
            	 <div class="btn-toolbar">
                    <a class="btn btn-primary btn-lg" href="/etnshop/product/list" role="button">Back</a>
                    <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                 </div>            	
            	</td>
            </tr>
        </table>
        </form>

<%-- <form action="doSearch" method="post"> --%>
<!-- Search for: -->
<!-- 	<input type="text"  name="searchText"/>	 -->
<!-- 	<input type="submit" name="SUBMIT"> -->
<%-- </form> --%>

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