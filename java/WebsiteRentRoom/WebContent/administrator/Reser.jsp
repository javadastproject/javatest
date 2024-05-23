<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import='java.sql.*'%>
<%@ page import='javax.persistence.Persistence'%>
<%@ page import='javax.persistence.EntityManagerFactory'%>
<%@ page import='javax.persistence.EntityManager'%>
<%@ page import='javax.persistence.TypedQuery'%>
<%@ page import='java.util.*'%>
<%@ page import='model.House'%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/adminpage.css" />
<title></title>
</head>
<body>



<%
   //Class.forName("com.mysql.jdbc.Driver");
   //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","root");
   //Statement st = con.createStatement();
   //ResultSet rs;
   //rs = st.executeQuery("select * from new_table");

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
		<h2 class="containindex">View reservations</h2>

        
		<table style="position:fixed;">
		    <%
		    

		    EntityManagerFactory emf = 
		    Persistence.createEntityManagerFactory("Airbnb2");
		    EntityManager em = emf.createEntityManager();
		    TypedQuery<House> query = em.createQuery("SELECT h FROM House h",House.class);
			List<House> nt = query.getResultList();
		    for (House nts : nt) {  %>
			<tr>
				<td> <%= nts.getId().getLocation() %> </td>
				<td> <%= nts.getId().getFirst_date() %> </td>
				<td> <%= nts.getId().getLast_date() %> </td>
				<td> <%= nts.getId().getMax_number_of_persons() %> </td>
				<td> <%= nts.getId().getMin_value_of_tenancy() %> </td>
			</tr>
			<% } %>
		</table>

	</div>
</body>
</html>