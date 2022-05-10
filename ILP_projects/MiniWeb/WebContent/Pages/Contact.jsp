<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/red.css">
<title>Contact</title>
</head>
<script>
	function goBack() {
	  window.history.back();
	}
</script>
<body>
<jsp:include page="../partials/ContactMenu.jsp" />
<h1>Contact</h1>
<h3>Soon...</h3>

<button onclick="goBack()">Go Back</button>

</body>
</html>