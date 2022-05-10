<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
		body {
		  font-family: helvetica;
		  background: white;
		}
		
		p{
			margin: 50px;
		}
	</style>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/red.css">
	<title>Add Building Data</title>
	<script>
		function goBack() {
		  window.history.back();
		}
		
	</script>
</head>
<body>
<jsp:include page="../partials/AddMenu.jsp" />


<div class="w3-container w3-gray">
	<h2>Add Building</h2>
</div>
<form name="addBuilding" action="${pageContext.request.contextPath}/Building" method="POST" onSubmit="">
	
	<p>
		<lable>Building name </lable>
			<input type="text" name="building_name" required><br/>
			
		<lable>Architect(s)</lable>
			<input type="text" name="architects" required><br/>
			
		<lable>Address</lable> 
			<input type="text" name="address" required><br/>
			
		<lable>Year</lable> 
			<input type="text" name="year_built" required><br/>
		
		<input type="hidden" name="action" value="add"/><br/>
	
		<input type = "submit" value="Submit"/><br/>
		
		<button onclick="goBack()">Cancel</button>
	</p>
</form>
<br/>

</body>
</html>