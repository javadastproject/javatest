<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import='java.sql.*'%>	
<%@ page import='model.Manager'%>
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
<link rel="stylesheet" href="css/adminprofile.css" />
<title>Administration profile user</title>
</head>
<body>

<%
  
  EntityManagerFactory emf = 
  Persistence.createEntityManagerFactory("Airbnb2");
  EntityManager em = emf.createEntityManager();
  TypedQuery<Manager> query = em.createQuery("SELECT m FROM Manager m",Manager.class);
  List<Manager> nt = query.getResultList();
  for (Manager nts : nt) {
	  
%>

	<nav>
	<img style="margin:7px;" align="left" src="images/image (2).png" alt="Smiley face" width="42" height="42">
	<a  href="Welcome_page.html" style="float: right; margin: 7.99px; color:red;">Log out </a>
		<div class="container">
			<div class="admenu">
				<ul>
					<li><a href="List1.jsp"> User info </a></li>
					<li><a href="/Airbnb2/adminprofile.html"> Change user info </a></li>

				</ul>
			</div>
		</div>
	</nav>
	<div class="index">
		<h2 class="containindex">Administration profile user</h2>

		<div class="prf">
			<form>
			    <label for="uname">User Name</label> 
				<input type="text" id="uname" name="username" placeholder="Your username.." value='<%= nts.getUsername() %>'>
				<label for="fname">First Name</label> 
				<input type="text" id="fname" name="firstname" placeholder="Your name.." value='<%= nts.getFirst_name() %>'>
				<label for="lname">Last Name</label> <input type="text" id="lname" name="lastname" placeholder="Your last name.." value='<%= nts.getLast_name() %>'> 
				<label
					for="pass">Password</label> <input type="text" id="pass"
					name="password" placeholder="Your password.." value='<%= nts.getPassword() %>'> <label
					for="email">Email</label> <input type="text" id="email"
					name="email" placeholder="Your email.." value='<%= nts.getEmail() %>'> <label
					for="telephone">Telephone</label> <input type="text" id="telephone"
					name="telephone" placeholder="Your telephone.." value='<%= nts.getTelephone() %>'>

			</form>
			<% } %>
		</div>

	</div>

</body>
</html>