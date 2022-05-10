<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<!-- dropdown menu style referenced from w3school.com dropdrown tutorials -->
<style>
	
		.navbar {
		  overflow: hidden;
		  background-color: #333;
		  font-family: Arial, Helvetica, sans-serif;
		}
		
		.navbar a {
		  float: left;
		  font-size: 16px;
		  color: white;
		  text-align: center;
		  padding: 14px 16px;
		  text-decoration: none;
		}
		
				
		.dropdown {
		  float: left;
		  overflow: hidden;
		}
		
		.dropdown .dropbtn {
		  cursor: pointer;
		  font-size: 16px;  
		  border: none;
		  outline: none;
		  color: white;
		  padding: 14px 16px;
		  background-color:  #333;
		  font-family: inherit;
		  margin: 0;
		}
		
		.navbar a:hover, .dropdown:hover .dropbtn, .dropbtn:focus {
		  background-color: #7a7977;
		}
		
		.dropdown-content {
		  display: none;
		  position: absolute;
		  background-color: #f9f9f9;
		  min-width: 160px;
		  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		  z-index: 1;
		}
		
		.dropdown-content a {
		  float: none;
		  color: black;
		  padding: 12px 16px;
		  text-decoration: none;
		  display: block;
		  text-align: left;
		}
		
		.dropdown-content a:hover {
		  background-color: #ddd;
		}
		
		.show {
		  display: block;
		}
		body {
		  font-family: helvetica;
		  background: white;
		  padding-bottom: 125px;
		}
		
		.container {
		  position: relative;
		  font-family: Arial;
		}
		
		.text-block {
		  position: absolute;
		  bottom: 20px;
		  right: 20px;
		  background-color: rgba(0, 0, 0, 0.7);
		  color: white;
		  padding-left: 20px;
		  padding-right: 20px;
		}
		
		img {
		  max-width: 100%;
		  height: auto;
		}
	
	</style>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/red.css">
	<title>Mini Web</title>
</head>
<script>
    function loadChoices() {
    	document.getElementById("myDropdown").classList.toggle("show");
   }
    
 // Close the dropdown if the user clicks outside of it
    window.onclick = function(event) {
      if (!event.target.matches('.dropbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
          var openDropdown = dropdowns[i];
          if (openDropdown.classList.contains('show')) {
            openDropdown.classList.remove('show');
          }
        }
      }
    }
</script>
<body>
	<div class="container">
		<img src="${pageContext.request.contextPath}/Chicago_sunrise_1-1024x325.jpg" alt="${pageContext.request.contextPath}/chicagoskyline.jpg">
		<div class="text-block">
			<h2> Welcome to the Chicago Architecture Database.</h2>
				<br>
				<p>
					This database is still very small considering that Chicago is home to some of the most prominent architecture of the World.
					You can add more to our database by using the add building feature.
					Enjoy! 
				</p>
		</div>
	</div>
	<div class="navbar">
	<div class="dropdown">
  		<button onclick="loadChoices()" class="dropbtn">Content</button>
  				<div id="myDropdown" class="dropdown-content">
   					<a href="${pageContext.request.contextPath}/Building/List" >Database</a>
   					<a href="${pageContext.request.contextPath}/Pages/AddBuilding.jsp" >Add Building</a>
    				<a href="${pageContext.request.contextPath}/Pages/About.jsp">About</a>
    				<a href="${pageContext.request.contextPath}/Pages/Contact.jsp">Contact</a>
  				</div>
	</div>
	</div>
	
	
	
		<!--  button type="button" onclick="loadDBList();">Load DB Page</button>
		-->

</body>
</html>