<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.House" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Houses</title>
</head>
<body>
	<% 
	@SuppressWarnings("unchecked")
	List<House> list = (List<House>) request.getAttribute("list");%>
	<%int pagenumber = (int) request.getAttribute("pagenumber"); %>
	<%int pagenumber2 = (int) request.getAttribute("pagenumber2"); %>
	<%int number = (int) request.getAttribute("number"); %>
	<%String username = (String) request.getAttribute("username"); %>
	<%int houses = 0; %>
	<%String filepath = (String) request.getAttribute("filepath"); %>
	<%List<House> list2 = new ArrayList<House>(); %>
	<% if (pagenumber == 1) {%>
	<%for (House h: list) { 
	%>
		<%houses++; %>
		<table border="1" cellpadding="5" cellspacing="5">
		<tr>
		<%String path = h.getFilepath(); %>
		<td><a href = "Houses_host?page=2&page2=1&house+number=<%=houses%>"><img src = <%= path %>>
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
		<%if (h.getLiving_room() == 1) {%>
		There is living room.
		<%}else { %>
		There isn't living room.
		<%}%>
		<br>
		Area: <%=h.getArea() %>
		<br>
		Description: <%=h.getDescription() %>
		<br>
		<%if (h.getSmoking() == 1) {%>
		Smoking allowed.
		<%}else { %>
		No smoking.
		<%}%>
		<br>
		<%if (h.getPets() == 1) {%>
		Pets allowed.
		<%}else { %>
		No pets.
		<%}%>
		<br>
		<%if (h.getEvent() == 1) {%>
		Event allowed.
		<%}else { %>
		No event.
		<%}%>
		<br>
		Min Number of days: <%=h.getMin_number_of_days() %>
		<br>
		Address: <%=h.getAddress() %>
		<br>
		Location: <%=h.getId().getLocation() %>
		<br>
		Transport: <%=h.getTransport() %>
		<br>
		<%String[] path2 = h.getFilepaths().split(","); %>
		<%for (String path3: path2) {%>
			<img src = <%= path3 %>>
			<br>
		<%}%>
		</a>
		</td>
		</tr>
		</table>
	<%}%>
	<%} else if (pagenumber == 2) {%>
		Location:
		<input type="text" name="location" value = <%=list.get(number - 1).getId().getLocation() %>/>
		<br>
		Address:
		<input type="text" name="address" value = <%=list.get(number - 1).getAddress() %>/>
		<br>
		Transport:
		<input type="text" name="transport" value = <%=list.get(number - 1).getTransport() %>/>
		<br>
		First Date:
	 	<input type="text" name="first date" value = <%=list.get(number - 1).getId().getFirst_date() %>/>
	 	<br>
	 	Last Date:
		<input type="text" name="last date" value = <%=list.get(number - 1).getId().getLast_date() %>/>
		<br>
		Max Number of persons:
		<input type="text" name="max number of persons" value = <%=list.get(number - 1).getId().getMax_number_of_persons() %>/>
		<br>
		Min Value of tenancy:
		<input type="text" name="min value of tenancy" value = <%=list.get(number - 1).getId().getMin_value_of_tenancy() %>/>
		<br>
		Additional Cost per person:
		<input type="text" name="additional cost per person" value = <%=list.get(number - 1).getAdditional_cost_per_person() %>/>
		<br>
		Type of rental space:
		<input type="text" name="type of rental space" value = <%=list.get(number - 1).getType_of_rental_space() %>/>
		<br>
		Smoking:
		<input type="text" name="smoking" value = <%=list.get(number - 1).getSmoking() %>/>
		<br>
		Pets:
		<input type="text" name="pets" value = <%=list.get(number - 1).getPets() %>/>
		<br>
		Event:
		<input type="text" name="event" value = <%=list.get(number - 1).getEvent() %>/>
		<br>
		Min Number of days:
		<input type="text" name="min number of days" value = <%=list.get(number - 1).getMin_number_of_days() %>/>
		<br>
		Description:
		<input type="text" name="description" value = <%=list.get(number - 1).getDescription() %>/>
		<br>
		Number of beds:
		<input type="text" name="number of beds" value = <%=list.get(number - 1).getNumber_of_beds() %>/>
		<br>
		Number of baths:
		<input type="text" name="number of baths" value = <%=list.get(number - 1).getNumber_of_baths() %>/>
		<br>
		Number of bedrooms:
		<input type="text" name="number of bedrooms" value = <%=list.get(number - 1).getNumber_of_bedrooms() %>/>
		<br>
		Living room:
		<input type="text" name="living room" value = <%=list.get(number - 1).getLiving_room() %>/>
		<br>
		Area:
		<input type="text" name="area" value = <%=list.get(number - 1).getArea() %>/>
		<br>
		<form method="get" action="Update.html">
	 		<input type="submit" value="Update" />
	 	</form>
		<%String path = list.get(number - 1).getFilepath(); %>
		Photo of space:<img src = <%= path %>>
		<br>
		<%if (list.get(number - 1).getReviews() != 0) {%>
		Reviews: <%= list.get(number - 1).getReviews() %>
		<%}%>  
		<br>
		<% for (int i = 1; i <= list.get(number - 1).getStars(); i++) {%>
		<span style="font-size:300%;color:yellow;">&starf;</span>
		<%}%>
		<br>
		<%String[] path2 = list.get(number - 1).getFilepaths().split(","); %>
		Photos of space:
		<br>
		<%for (String path3: path2) {%>
			<img src = <%= path3 %>>
			<br>
		<%}%>
		<form method="get" action="UploadFile.html">
	 		<input type="submit" value="Upload files" />
	 	</form>
	 	<form method="get" action="Delete_photo.html">
	 		<input type="submit" value="Delete photo" />
	 	</form>
		Photo of host:
		<img src = <%= filepath %>>
		<br>
		<%if (list.get(number - 1).getReviews_host() != 0) {%>
		Reviews host: <%=list.get(number - 1).getReviews_host() %>
		<%}%>
		<br>
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
		<%int offset = (pagenumber2 - 1) * messages_per_page;%>
		<%int max_messages = (pagenumber2 - 1) * messages_per_page + messages_per_page;%>
		<%List<String> sublist;%>
		<%if (messages > max_messages) {%>
			<%sublist = list.get(number - 1).getMessages2().subList(offset, max_messages);%>
		<%} else {%>
			<%sublist = list.get(number - 1).getMessages2().subList(offset, messages);%>
		<%}%>
		<form method="get" action="Conversations_host.html">
			<input type="submit" value="New theme" />
			<br>
			<%for (String str: sublist) {%>
				<textarea name="conversations2" id="conversations2" rows="30" cols="60"><%=str%></textarea>
				<br>
			<%} %>
		</form>
		<table border="1" cellpadding="5" cellspacing="5">
		<%for (int i = 1; i <= totalpages; i++) {
		%>
		<tr>
			<td><a href="Houses_host?page=2&page2=<%=i%>&house+number=<%=number%>"><%=i%></a></td>
		</tr>
		<%}%>
		</table>
		<form method="get" action="Delete_message.html">
	 		<input type="submit" value="Delete message" />
	 	</form>
	<%}%>
</body>
</html>