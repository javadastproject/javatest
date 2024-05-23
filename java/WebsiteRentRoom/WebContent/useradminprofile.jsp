<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import='model.Tenant'%>
<%@ page import='javax.persistence.Persistence'%>
<%@ page import='javax.persistence.EntityManagerFactory'%>
<%@ page import='javax.persistence.EntityManager'%>
<%@ page import='javax.persistence.TypedQuery'%>
<%@ page import='java.util.*'%>
<%@ page import='javax.persistence.Query'%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="administrator/css/adminprofile.css" />
<title>Administration profile user</title>
</head>
<body>

<%

  Tenant tenant = (Tenant) request.getAttribute("tenant");
	  
%>

	<nav>
	<img style="margin:7px;" align="left" src="administrator/images/image (2).png" alt="Smiley face" width="42" height="42">
	<a  href="Welcome_page.html" style="float: right; margin: 7.99px; color:red;">Log out </a>
		<div class="container">
			<div class="admenu">
				<ul>
					<li><a href="useradminprofile"> User info </a></li>
					<li><a href="infolist.html"> Change user info </a></li>

				</ul>
			</div>
		</div>
	</nav>
	<div class="index">
		<h2 class="containindex">Administration profile user</h2>

		<div class="prf">
			<form>
			    <label for="uname">User Name</label> 
				<input type="text" id="uname" name="username" placeholder="Your username.." value='<%= tenant.getUsername() %>'>
				<label for="fname">First Name</label> 
				<input type="text" id="fname" name="firstname" placeholder="Your first name.." value='<%= tenant.getFirst_name() %>'>
				<label for="lname">Last Name</label> <input type="text" id="lname" name="lastname" placeholder="Your last name.." value='<%= tenant.getLast_name() %>'> 
				<label
					for="pass">Password</label> <input type="text" id="pass"
					name="password" placeholder="Your password.." value='<%= tenant.getPassword() %>'> <label
					for="email">Email</label> <input type="text" id="email"
					name="email" placeholder="Your email.." value='<%= tenant.getEmail() %>'> <label
					for="telephone">Telephone</label> <input type="text" id="telephone"
					name="telephone" placeholder="Your telephone.." value='<%= tenant.getTelephone() %>'><label
					for="telephone">Image</label> <input type="text" id="image"
					name="image" placeholder="Your image..">
			</form>
		</div>

	</div>

</body>
</html>