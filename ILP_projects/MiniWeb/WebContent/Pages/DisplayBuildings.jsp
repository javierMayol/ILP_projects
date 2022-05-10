<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
	/*
	 * Solution for this radio button referenced from w3school.com
	 * link : https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_custom_radio
	 */
		/* The container */
		.container {
		  display: block;
		  position: relative;
		  padding-left: 35px;
		  margin-bottom: 12px;
		  cursor: pointer;
		  -webkit-user-select: none;
		  -moz-user-select: none;
		  -ms-user-select: none;
		  user-select: none;
		  font-family: helvetica;
		  font-size: 10 px;
		}
		
		/* Hide the browser's default radio button */
		.container input {
		  position: absolute;
		  opacity: 0;
		  cursor: pointer;
		}
		
		/* Create a custom radio button */
		.checkmark {
		  position: absolute;
		  top: 0;
		  left: 0;
		  height: 25px;
		  width: 25px;
		  background-color: #eee;
		  border-radius: 50%;
		}
		
		/* On mouse-over, add a grey background color */
		.container:hover input ~ .checkmark {
		  background-color: #ccc;
		}
		
		/* When the radio button is checked, add a blue background */
		.container input:checked ~ .checkmark {
		  background-color: #2196F3;
		}
		
		/* Create the indicator (the dot/circle - hidden when not checked) */
		.checkmark:after {
		  content: "";
		  position: absolute;
		  display: none;
		}
		
		/* Show the indicator (dot/circle) when checked */
		.container input:checked ~ .checkmark:after {
		  display: block;
		}
		
		/* Style the indicator (dot/circle) */
		.container .checkmark:after {
		 	top: 9px;
			left: 9px;
			width: 8px;
			height: 8px;
			border-radius: 50%;
			background: white;
		}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/red.css">
<title>CADB List</title>
</head>
<body>

	<jsp:include page="../partials/menu.jsp" />
	
	<table class="alternate">
	<thead>
	<tr>
	<th>Name</th>
	<th>Architect(s)</th>
	<th>Location</th>
	<th>Year</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="building" items="${buildings}">
		   <tr>
		      <td>
				<c:out value = "${building.buildingName}"/>
			  </td>
			  <td>
				<c:out value = "${building.architects}"/>
			  </td>
			  <td>
			  	<c:out value = "${building.address}"/>
			  </td>
			  <td>
			  	<c:out value = "${building.yearBuilt}"/>
			  </td>
			  <td class="noBorder">
			    <!--  /Building calls a servlet to fetch buildings by ID -->
				<a class="button" href="${pageContext.request.contextPath}/Building/List?id=${building.buildingId}">edit</a>
			  </td>
		   </tr>
		   
	</c:forEach>
	</tbody>
	</table>
	<form name="addBuilding" action="${pageContext.request.contextPath}/Building/List" method="GET" onSubmit="">
		<div style="margin-left: 80px;">
			<h5 style="font-family: helvetica;">Sort by year</h5>
			<label class="container">Ascending
		  		<input type="radio" checked="checked" name="radio" value="asc" />
		  		<span class="checkmark"></span>
			</label>
			<label class="container">Descending
			  	<input type="radio" name="radio" value="desc" />
			  	<span class="checkmark"></span>
			</label>
			<br/>
			<input type="submit" value="Submit">
		</div>
	</form><br/><br/><br/><br/>
</body>
</html>