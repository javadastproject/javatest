<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import='java.sql.*'%>
<%@ page import='javax.persistence.Persistence'%>
<%@ page import='javax.persistence.EntityManagerFactory'%>
<%@ page import='javax.persistence.EntityManager'%>
<%@ page import='javax.persistence.TypedQuery'%>
<%@ page import='java.util.*'%>
<%@ page import='javax.persistence.Query'%>
<%@ page import='model.*'%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/adminpage.css" />
<title></title>
</head>
<body>




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
		<h2 class="containindex">View Users Data</h2>


		<table>
		 <%
		    

		    EntityManagerFactory emf = 
		    Persistence.createEntityManagerFactory("Airbnb2");
		    EntityManager em = emf.createEntityManager();
		    TypedQuery<Tenant> query = em.createQuery("SELECT t FROM Tenant t",Tenant.class);
			List<Tenant> nt = query.getResultList();
		    for (Tenant nts : nt) {  %>
			<tr align="right">
			    <td><%= nts.getFirst_name() %></td> 
			    <td><%= nts.getLast_name() %></td>
			    <td><%= nts.getEmail() %></td>
			    <td><%= nts.getPassword() %></td>
			    <td><%= nts.getUsername() %></td>
			    <td><%= nts.getTelephone() %></td>
			</tr>
		 <% } %>
		 <%
		    TypedQuery<Manager> query1 = em.createQuery("SELECT m FROM Manager m",Manager.class);
			List<Manager> nt1 = query1.getResultList();
		    for (Manager nts : nt1) {  %>
			<tr align="right">
			    <td><%= nts.getFirst_name() %></td> 
			    <td><%= nts.getLast_name() %></td>
			    <td><%= nts.getEmail() %></td>
			    <td><%= nts.getPassword() %></td>
			    <td><%= nts.getUsername() %></td>
			    <td><%= nts.getTelephone() %></td>
			</tr>
			<% } %>
			<%
		    TypedQuery<Host> query2 = em.createQuery("SELECT h FROM Host h",Host.class);
			List<Host> nt2 = query2.getResultList();
		    for (Host nts : nt2) {  %>
			<tr align="right">
			    <td><%= nts.getFirst_name() %></td> 
			    <td><%= nts.getLast_name() %></td>
			    <td><%= nts.getEmail() %></td>
			    <td><%= nts.getPassword() %></td>
			    <td><%= nts.getUsername() %></td>
			    <td><%= nts.getTelephone() %></td>
			</tr>
			<% } %>
		</table>

	</div>
</body>
</html>