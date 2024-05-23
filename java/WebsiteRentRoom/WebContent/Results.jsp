<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.House" %>
<%@ page import="model.Host" %>
<%@ page import="pair.pair" %>
<%@ page import="pair.pair_operations" %>
<%@ page import="intersection.intersection" %>
<%@ page import='javax.persistence.EntityManager'%>
<%@ page import='javax.persistence.EntityManagerFactory'%>
<%@ page import='javax.persistence.Persistence'%>
<%@ page import='javax.persistence.TypedQuery'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Houses</title>
</head>
<body>
	<%
	@SuppressWarnings("unchecked")
	List<House> list = (List<House>) request.getAttribute("sublist");%>
	<%int persons = (int) request.getAttribute("persons"); %>
	<%int page1 = (int) request.getAttribute("pagenumber"); %>
	<%int page2 = (int) request.getAttribute("pagenumber2"); %>
	<%int page3 = (int) request.getAttribute("pagenumber3"); %>
	<%int number = (int) request.getAttribute("number"); %>
	<%int results_per_page = (int) request.getAttribute("results per page"); %>
	<%int houses = 0; %>
	<%int house_number; %>
	<% if (page2 == 1) {%>
		<%for (House h: list) {
		%>
			<%houses++; %>
			<%house_number = houses + (page1 - 1) * results_per_page;%>
			<table border="1" cellpadding="5" cellspacing="5">
			<tr>
			<%String path = h.getFilepath(); %>
			<td><a href = "Search_tenant?page=<%=page1%>&page2=2&page3=<%=page3%>&house+number=<%=house_number%>">
			Photo of space:<img src = <%= path %>>
			<br>
			Min Value of Tenancy: <%=h.getId().getMin_value_of_tenancy() %>
			<br>
			Type of rental space: <%=h.getType_of_rental_space() %>
			<br>
			Number of beds: <%=h.getNumber_of_beds() %>
			<br>
			<%if (h.getReviews() != 0) {%>
			Reviews: <%= h.getReviews() %>
			<%}%>
			<br>
			<% for (int i = 1; i <= h.getStars(); i++) {%>
			<span style="font-size:300%;color:yellow;">&starf;</span>
			<%}%>
			</a>
			</td>
			</tr>
			</table>
		<%}%>
		<table border="1" cellpadding="5" cellspacing="5">
			<%for (int i = 1; i <= (int) request.getAttribute("totalpages"); i++) {
			%>
			<tr>
				<td><a href="Search_tenant?page=<%=i%>&page2=1&page3=<%=page3%>&house+number=<%=number%>"><%=i%></a></td>
			</tr>
			<%}%>
		</table>
	<%} else if (page2 == 2) {%>
		<%number = number - (page1 - 1) * results_per_page; %>
		<%List<pair<Double>> list_pair = new ArrayList<pair<Double>>(); %>
		<%pair<Double> p = new pair<Double>(); %>
		<%p.setString("Number of beds:"); %>
		<%p.setVar((double) list.get(number - 1).getNumber_of_beds()); %>
		<%list_pair.add(p); %>
		
		<%pair<Double> p2 = new pair<Double>(); %>
		<%p2.setString("Number of baths:"); %>
		<%p2.setVar((double) list.get(number - 1).getNumber_of_baths()); %>
		<%list_pair.add(p2); %>
		
		<%pair<Double> p3 = new pair<Double>(); %>
		<%p3.setString("Number of bedrooms:"); %>
		<%p3.setVar((double) list.get(number - 1).getNumber_of_bedrooms()); %>
		<%list_pair.add(p3); %>
		
		<%pair<Double> p4 = new pair<Double>(); %>
		<%p4.setString("Area:"); %>
		<%p4.setVar(list.get(number - 1).getArea()); %>
		<%list_pair.add(p4); %>
		
		<%pair_operations<Double> pair = new pair_operations<Double>(); %>
		<%pair.bubblesort(list_pair);%>
		
		<%List<pair<String>> list_pair2 = new ArrayList<pair<String>>(); %>
		<%pair<String> p5 = new pair<String>(); %>
		<%p5.setString("Type of rental space:"); %>
		<%p5.setVar(list.get(number - 1).getType_of_rental_space()); %>
		<%list_pair2.add(p5); %>
		
		<%pair<String> p6 = new pair<String>(); %>
		<%p6.setString(null); %>
		<%if (list.get(number - 1).getLiving_room() == 1) {%>
		<%p6.setVar("There is living room.");%>
		<%}else { %>
		<%p6.setVar("There isn't living room.");%>
		<%}%>
		<%list_pair2.add(p6); %>
		
		<%pair_operations<String> pair2 = new pair_operations<String>(); %>
		<%pair2.bubblesort(list_pair2);%>
		
		<%List<pair<String>> list_pair3 = new ArrayList<pair<String>>(); %>
		<%pair<String> p7 = new pair<String>(); %>
		<%p7.setString(null); %>
		<%if (list.get(number - 1).getSmoking() == 1) {%>
		<%p7.setVar("Smoking allowed.");%>
		<%}else { %>
		<%p7.setVar("No smoking.");%>
		<%}%>
		<%list_pair3.add(p7); %>
		
		<%pair<String> p8 = new pair<String>(); %>
		<%p8.setString(null); %>
		<%if (list.get(number - 1).getPets() == 1) {%>
		<%p8.setVar("Pets allowed.");%>
		<%}else { %>
		<%p8.setVar("No pets.");%>
		<%}%>
		<%list_pair3.add(p8); %>
		
		<%pair<String> p9 = new pair<String>(); %>
		<%p9.setString(null); %>
		<%if (list.get(number - 1).getEvent() == 1) {%>
		<%p9.setVar("Event allowed.");%>
		<%}else { %>
		<%p9.setVar("No event.");%>
		<%}%>
		<%list_pair3.add(p9); %>
		
		<%pair_operations<String> pair3 = new pair_operations<String>(); %>
		<%pair3.bubblesort(list_pair3);%>
		
		<%List<pair<String>> list_pair4 = new ArrayList<pair<String>>(); %>
		<%pair<String> p10 = new pair<String>(); %>
		<%p10.setString("Address:"); %>
		<%p10.setVar(list.get(number - 1).getAddress()); %>
		<%list_pair4.add(p10); %>
		
		<%pair<String> p11 = new pair<String>(); %>
		<%p11.setString("Location:"); %>
		<%p11.setVar(list.get(number - 1).getId().getLocation()); %>
		<%list_pair4.add(p11); %>
		
		<%pair<String> p12 = new pair<String>(); %>
		<%p12.setString("Transport:"); %>
		<%p12.setVar(list.get(number - 1).getTransport()); %>
		<%list_pair4.add(p12); %>
		
		<%pair_operations<String> pair4 = new pair_operations<String>(); %>
		<%pair4.bubblesort(list_pair4);%>
		
		<table border="1" cellpadding="5" cellspacing="5">
		<tr>
		<td>
		<%=list_pair.get(0).getString() %>
		<%=list_pair.get(0).getVar().intValue() %>
		<br>
		<%=list_pair.get(1).getString() %>
		<%=list_pair.get(1).getVar().intValue() %>
		<br>
		<%if (list_pair2.get(0).getString() != null) { %>
		<%=list_pair2.get(0).getString() %>
		<%}%>
		<%=list_pair2.get(0).getVar() %>
		<br>
		<%=list_pair.get(2).getString() %>
		<%=list_pair.get(2).getVar().intValue() %>
		<br>
		<%if (list_pair2.get(1).getString() != null) { %>
		<%=list_pair2.get(1).getString() %>
		<%}%>
		<%=list_pair2.get(1).getVar() %>
		<br>
		<%=list_pair.get(3).getString() %>
		<%=list_pair.get(3).getVar() %>
		<br>
		Description: <%=list.get(number - 1).getDescription() %>
		<br>
		<%for (pair<String> element: list_pair3) {%>
		<%= element.getVar()%>
		<br>
		<%}%>
		Min Number of days: <%=list.get(number - 1).getMin_number_of_days() %>
		<br>
		<%String url = "https://maps.google.com/maps?q="; %>
		<%if (list.get(number - 1).getId().getLocation().contains(" ")) {%>
		<%String newlocation = list.get(number - 1).getId().getLocation().replace(" ", "+"); %>
		<%String url2 = url.concat(newlocation); %>
		<%String url3 = url2.concat("%2C%20GR&t=&z=14&ie=UTF8&iwloc=&output=embed"); %>
		<iframe width="600" height="500" id="gmap_canvas" src=<%=url3 %> frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
		<br>
		<%}else{ %>
		<%String url2 = url.concat(list.get(number - 1).getId().getLocation()); %>
		<%String url3 = url2.concat("%2C%20GR&t=&z=14&ie=UTF8&iwloc=&output=embed"); %>
		<iframe width="600" height="500" id="gmap_canvas" src=<%=url3 %> frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
		<br>
		<%} %>
		<%for (int i = 0; i < list_pair4.size(); i++) { %>
		<%=list_pair4.get(i).getString() %>
		<%=list_pair4.get(i).getVar() %>
		<br>
		<%} %>
		<br>
		<%String[] paths = list.get(number - 1).getFilepaths().split(","); %>
		Photos of space:
		<br>
		<%for (String path: paths) {%>
			<img src = <%= path %>>
			<br>
		<%}%>
		<%EntityManagerFactory emf = Persistence.createEntityManagerFactory("Airbnb2"); %>
    	<%EntityManager em = emf.createEntityManager();%>
    	<%TypedQuery<Host> query = em.createQuery("SELECT h FROM Host AS h WHERE h.username='"+list.get(number - 1).getUsername_host()+"'",Host.class); %>
		<%List<Host> mylist = query.getResultList(); %>
		<%String file = mylist.get(0).getFilepath();%>
		Photo of host:
		<br>
		<%if (!list.get(number - 1).getMessages().isEmpty() && !list.get(number - 1).getMessages().equals(" ")) {%>
		<%house_number = number + (page1 - 1) * results_per_page; %>
		<a href = "Search_tenant?page=<%=page1%>&page2=4&page3=<%=page3%>&house+number=<%=house_number%>"><img src = <%= file %>>
		<br>
		<%if (list.get(number - 1).getReviews_host() != 0) {%>
		Reviews host: <%=list.get(number - 1).getReviews_host() %>
		<%}%>
		<br>
		</a>
		<%} else { %>
		<a href = "Messages.html"><img src = <%= file %>>
		<br>
		<%if (list.get(number - 1).getReviews_host() != 0) {%>
		Reviews host: <%=list.get(number - 1).getReviews_host() %>
		<%}%>
		<br>
		</a>
		<%}%>
		<form method ="get" action ="Reviews.html">
		    <input type="submit" value="Reservation" />
		</form>
		</td>
		</tr>
		</table>
	<%} else if (page2 == 3) {%>
		<%List<House> list1 = new ArrayList<House>();%> 
		<%List<House> list2 = new ArrayList<House>();%> 
		<%List<House> intersection = new ArrayList<House>();%> 
		<%if (request.getAttribute("room type").equals("two beds room")) {%>
			<%for (House h: list) { 
			%>
				<%if (h.getNumber_of_beds() == 2) { %>
					<%list1.add(h); %>
				<%}%>
			<%}%>
		<%} else if (request.getAttribute("room type").equals("three beds room")) {%>
			<%for (House h: list) { 
			%>
				<%if (h.getNumber_of_beds() == 3) { %>
					<%list1.add(h); %>
				<%}%>
			<%}%>
		<%} else if (request.getAttribute("room type").equals("more beds room")) {%>
			<%for (House h: list) { 
			%>
				<%if (h.getNumber_of_beds() > 3) { %>
					<%list1.add(h); %>
				<%}%>
			<%}%>
		<%}%>
		<%if (request.getAttribute("maximum cost").equals("1.2")) { %>
			<%for (House h: list) { 
			%>
				<%if (h.getId().getMin_value_of_tenancy() == 1.2) { %>
					<%list2.add(h); %>
				<%} %>
			<%} %>
		<%} else if (request.getAttribute("maximum cost").equals("Other cost")) {  %>
			<%for (House h: list) { 
			%>
				<%if (h.getId().getMin_value_of_tenancy() != 1.2) { %>
					<%list2.add(h); %>
				<%} %>
			<%} %>
		<%}%>
		<%intersection inter = new intersection(); %>
		<%intersection = inter.intersection_lists(list1, list2); %>
		<%List<House> list3 = new ArrayList<House>();%> 
		<%List<House> intersection2 = new ArrayList<House>();%>
		
		<%if (request.getAttribute("wireless internet").equals("Yes")) { %>
			<%for (House h: list) { 
			%>
				<%if (h.getDescription().contains("wireless internet")) { %>
					<%list3.add(h); %>
				<%} %>
			<%} %>
		<%} else if (request.getAttribute("wireless internet").equals("No")) {  %>
			<%for (House h: list) { 
			%>
				<%if (!h.getDescription().contains("wireless internet")) { %>
					<%list3.add(h); %>
				<%} %>
			<%} %>
		<%}%>
		<%intersection inter2 = new intersection(); %>
		<%intersection2 = inter2.intersection_lists(intersection, list3); %>
		<%List<House> list4 = new ArrayList<House>();%> 
		<%List<House> intersection3 = new ArrayList<House>();%>
		
		<%if (request.getAttribute("cooling").equals("Yes")) { %>
			<%for (House h: list) { 
			%>
				<%if (h.getDescription().contains("cooling")) { %>
					<%list4.add(h); %>
				<%} %>
			<%} %>
		<%} else if (request.getAttribute("cooling").equals("No")) {  %>
			<%for (House h: list) { 
			%>
				<%if (!h.getDescription().contains("cooling")) { %>
					<%list4.add(h); %>
				<%} %>
			<%} %>
		<%}%>
		<%intersection inter3 = new intersection(); %>
		<%intersection3 = inter3.intersection_lists(intersection2, list4); %>
		<%List<House> list5 = new ArrayList<House>();%> 
		<%List<House> intersection4 = new ArrayList<House>();%>
		
		<%if (request.getAttribute("heating").equals("Yes")) { %>
			<%for (House h: list) { 
			%>
				<%if (h.getDescription().contains("heating")) { %>
					<%list5.add(h); %>
				<%} %>
			<%} %>
		<%} else if (request.getAttribute("heating").equals("No")) {  %>
			<%for (House h: list) { 
			%>
				<%if (!h.getDescription().contains("heating")) { %>
					<%list5.add(h); %>
				<%} %>
			<%} %>
		<%}%>
		<%intersection inter4 = new intersection(); %>
		<%intersection4 = inter4.intersection_lists(intersection3, list5); %>
		<%List<House> list6 = new ArrayList<House>();%> 
		<%List<House> intersection5 = new ArrayList<House>();%>
		
		<%if (request.getAttribute("kitchen").equals("Yes")) { %>
			<%for (House h: list) { 
			%>
				<%if (h.getDescription().contains("kitchen")) { %>
					<%list6.add(h); %>
				<%} %>
			<%} %>
		<%} else if (request.getAttribute("kitchen").equals("No")) {  %>
			<%for (House h: list) { 
			%>
				<%if (!h.getDescription().contains("kitchen")) { %>
					<%list6.add(h); %>
				<%} %>
			<%} %>
		<%}%>
		<%intersection inter5 = new intersection(); %>
		<%intersection5 = inter.intersection_lists(intersection4, list6); %>
		<%List<House> list7 = new ArrayList<House>();%> 
		<%List<House> intersection6 = new ArrayList<House>();%>
		
		<%if (request.getAttribute("television").equals("Yes")) { %>
			<%for (House h: list) { 
			%>
				<%if (h.getDescription().contains("television")) { %>
					<%list7.add(h); %>
				<%} %>
			<%} %>
		<%} else if (request.getAttribute("television").equals("No")) {  %>
			<%for (House h: list) { 
			%>
				<%if (!h.getDescription().contains("television")) { %>
					<%list7.add(h); %>
				<%} %>
			<%} %>
		<%}%>
		<%intersection inter6 = new intersection(); %>
		<%intersection6 = inter.intersection_lists(intersection5, list7); %>
		<%List<House> list8 = new ArrayList<House>();%> 
		<%List<House> intersection7 = new ArrayList<House>();%>
		
		<%if (request.getAttribute("parking").equals("Yes")) { %>
			<%for (House h: list) { 
			%>
				<%if (h.getDescription().contains("parking")) { %>
					<%list8.add(h); %>
				<%} %>
			<%} %>
		<%} else if (request.getAttribute("parking").equals("No")) {  %>
			<%for (House h: list) { 
			%>
				<%if (!h.getDescription().contains("parking")) { %>
					<%list8.add(h); %>
				<%} %>
			<%} %>
		<%}%>
		<%intersection inter7 = new intersection(); %>
		<%intersection7 = inter.intersection_lists(intersection6, list8); %>
		<%List<House> list9 = new ArrayList<House>();%> 
		<%List<House> intersection8 = new ArrayList<House>();%>
		
		<%if (request.getAttribute("lift").equals("Yes")) { %>
			<%for (House h: list) { 
			%>
				<%if (h.getDescription().contains("lift")) { %>
					<%list9.add(h); %>
				<%} %>
			<%} %>
		<%} else if (request.getAttribute("lift").equals("No")) {  %>
			<%for (House h: list) { 
			%>
				<%if (!h.getDescription().contains("lift")) { %>
					<%list9.add(h); %>
				<%} %>
			<%} %>
		<%}%>
		<%intersection inter8 = new intersection(); %>
		<%intersection8 = inter.intersection_lists(intersection7, list9); %>
		
		<%for (House h: intersection8) { 
		%>
			<table border="1" cellpadding="5" cellspacing="5">
			<tr>
			<%String path = h.getFilepath(); %>
			<td>Photo of space:<br><img src = <%= path %>>
			<br>
			Min Value of Tenancy: <%=h.getId().getMin_value_of_tenancy() %>
			<br>
			Type of rental space: <%=h.getType_of_rental_space() %>
			<br>
			Number of beds: <%=h.getNumber_of_beds() %>
			<br>
			Number of baths: <%=h.getNumber_of_baths() %>
			<br>
			Number of bedrooms: <%=h.getNumber_of_bedrooms() %>
			<br>
			Description: <%=h.getDescription() %>
			<br>
			Area: <%=h.getArea() %>
			<br>
			<%if (h.getLiving_room() == 1) {%>
			There is living room.
			<%} else {%>
			There isn't living room.
			<%}%>
			<br>
			<%if (h.getSmoking() == 1) {%>
			Smoking allowed.
			<%} else {%>
			No smoking.
			<%}%>
			<br>
			<%if (h.getPets() == 1) {%>
			Pets allowed.
			<%} else {%>
			No pets.
			<%}%>
			<br>
			<%if (h.getEvent() == 1) {%>
			Event allowed.
			<%} else {%>
			No event.
			<%}%>
			<br>
			Address: <%=h.getAddress() %>
			<br>
			Location: <%=h.getId().getLocation() %>
			<br>
			Transport: <%=h.getTransport() %>
			<br>
			<%if (h.getReviews() != 0) {%>
			Reviews: <%= h.getReviews() %>
			<%}%>
			<br>
			<% for (int i = 1; i <= h.getStars(); i++) {%>
			<span style="font-size:300%;color:yellow;">&starf;</span>
			<%}%>
			<br>
			<%String[] paths = list.get(number - 1).getFilepaths().split(","); %>
			Photos of space:
			<br>
			<%for (String path2: paths) {%>
			<img src = <%= path2 %>>
			<br>
			<%}%>
			<%EntityManagerFactory emf = Persistence.createEntityManagerFactory("Airbnb2"); %>
    		<%EntityManager em = emf.createEntityManager();%>
    		<%TypedQuery<Host> query = em.createQuery("SELECT h FROM Host AS h WHERE h.username='"+list.get(number - 1).getUsername_host()+"'",Host.class); %>
			<%List<Host> mylist = query.getResultList(); %>
			<%String file = mylist.get(0).getFilepath();%>
			Photo of host:
			<img src = <%= file %>>
			<br>
			<%if (h.getReviews_host() != 0) {%>
			Reviews host: <%=h.getReviews_host() %>
			<%}%>
			<br>
			</td>
			</tr>
			</table>
		<%}%>
	<%} else if (page2 == 4) {%>
		<%number = number - (page1 - 1) * results_per_page; %>
		<%List<String> list_messages = new ArrayList<String>(); %>
		<%list.get(number - 1).setMessages2(list_messages); %>
		<%if (list.get(number - 1).getMessages().contains("/")) {%>
			<%String[] array_messages = list.get(number - 1).getMessages().split("/"); %>
			<%for (String str: array_messages) {%>
				<%list.get(number - 1).addMessage(str); %>
			<%} %>
		<%}else { %>
			<%list.get(number - 1).addMessage(list.get(number - 1).getMessages()); %>
		<%} %>
		<%int messages = list.get(number - 1).getMessages2().size();%>
		<%int messages_per_page = 5; %>
		<%int totalpages = (int) Math.ceil((double) messages / messages_per_page); %>
		<%int offset = (page3 - 1) * messages_per_page;%>
		<%int max_messages = (page3 - 1) * messages_per_page + messages_per_page;%>
		<%List<String> sublist_messages;%>
		<%if (messages > max_messages) {%>
			<%sublist_messages = list.get(number - 1).getMessages2().subList(offset, max_messages);%>
		<%} else {%>
			<%sublist_messages = list.get(number - 1).getMessages2().subList(offset, messages);%>
		<%}%>
		<form method="get" action="Conversations_tenant.html">
		<input type="submit" value="New theme" />
		<br>
		<%for (String str: sublist_messages) {%>
			<textarea name="conversations" id="conversations" rows="30" cols="60"><%=str%></textarea>
			<br>
		<%} %>
		</form>
		<table border="1" cellpadding="5" cellspacing="5">
		<%for (int i = 1; i <= totalpages; i++) {
		%>
		<tr>
			<td><a href="Search_tenant?page=<%=page1%>&page2=4&page3=<%=i%>&house+number=<%=number%>"><%=i%></a></td>
		</tr>
		<%}%>
		</table>
	<%}%>
</body>
</html>