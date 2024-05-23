<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import='java.sql.*'%>
<%@ page import='java.util.List'%>
<%@ page import='javax.persistence.EntityManager'%>
<%@ page import='javax.persistence.EntityManagerFactory'%>
<%@ page import='javax.persistence.Persistence'%>
<%@ page import='javax.persistence.TypedQuery'%>
<%@ page import='model.*'%>


<%
   int i=0;
   String usid = request.getParameter("username");
   String passwd = request.getParameter("password");
   //session.setAttribute("username", usid);
   //session.setAttribute("password", passwd);
   // Class.forName("com.mysql.jdbc.Driver");
   // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","root");
   // Statement st = con.createStatement();
   // ResultSet rs;
   // rs = st.executeQuery("select * from user where username= '" + usid + "' and password= '" +passwd + "'");
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Airbnb2");
    EntityManager em = emf.createEntityManager();
    TypedQuery<Manager> query = em.createQuery("SELECT m FROM Manager AS m WHERE m.username='"+usid+"' AND m.password='"+passwd+"'",Manager.class);
    List<Manager> result = query.getResultList();
    for(Manager results : result){  	

    if(results.getUsername().equals(usid) && results.getPassword().equals(passwd)){
            response.sendRedirect("Indexpage.html"); 
            i++;}
    }
    
    TypedQuery<Tenant> query1 = em.createQuery("SELECT t FROM Tenant AS t WHERE t.username='"+usid+"' AND t.password='"+passwd+"'",Tenant.class);
    List<Tenant> result1 = query1.getResultList();
    for(Tenant results : result1){
    
    if(results.getUsername().equals(usid) && results.getPassword().equals(passwd)){
        response.sendRedirect("Indexpage2.html"); 
        i++;}
    }
    
    TypedQuery<Host> query2 = em.createQuery("SELECT h FROM Host AS h WHERE h.username='"+usid+"' AND h.password='"+passwd+"'",Host.class);
    List<Host> result2 = query2.getResultList();
    for(Host results : result2){
    
    if(results.getUsername().equals(usid) && results.getPassword().equals(passwd)){
        response.sendRedirect("Indexpage3.html"); 
        i++;}
    }
    
    if(i == 0)
    	response.sendRedirect("administrator/error.jsp");
%>