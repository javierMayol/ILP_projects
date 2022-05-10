<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/red.css">

<style>
		body {
		  font-family: helvetica;
		  background: white;
		}
		
		p{
			margin: 50px;
		}
		
</style>

<script>
	function goBack() {
	  window.history.back();
	}
	
</script>

<title>Edit Building Data</title>
</head>
<body>
<jsp:include page="../partials/menu.jsp" />
<!--  ${message}<p/> -->

<div class="w3-container w3-gray">
	<h2>Update Building Info</h2>
</div>
<form name="updateBuildings" action="${pageContext.request.contextPath}/Building" method="POST" onSubmit="">
	
	<p>
		<lable>Building name </lable>
			<input type="text" name="building_name" value="${building.buildingName}" required><br/>
			
		<lable>Architect(s)</lable>
			<input type="text" name="architects" value="${building.architects}" required><br/>
			
		<lable>Address</lable> 
			<input type="text" name="address" value="${building.address}" required><br/>
			
		<lable>Year</lable> 
			<input type="text" name="year_built" value="${building.yearBuilt}" required><br/>
		
		<input type="hidden" name="building_id" value="${building.buildingId}"><br/>
		<input type="hidden" name="action" value="update"/>
	
		<input type = "submit" value="Submit"/><br/>
		
		<button  onclick="goBack()">Cancel</button>
	</p>
</form>
<br/>
</body>
</html>