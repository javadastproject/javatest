package updatehouse;

import java.io.IOException;
import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;
import houses.Houses_host;

/**
 * Servlet implementation class Update_house
 */
@WebServlet("/Update_house")
public class Update_house extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String location = request.getParameter("location");
		String address = request.getParameter("address");
		String transport = request.getParameter("transport");
		String first_date = request.getParameter("first date");
		String last_date = request.getParameter("last date");
		String max_number_of_persons = request.getParameter("max number of persons");
		String min_value_of_tenancy = request.getParameter("min value of tenancy");
		String additional_cost_per_person = request.getParameter("additional cost per person");
		String type_of_rental_space = request.getParameter("type of rental space");
		String smoking = request.getParameter("smoking");
		String pets = request.getParameter("pets");
		String event = request.getParameter("event");
		String min_number_of_days = request.getParameter("min number of days");
		String description = request.getParameter("description");
		String number_of_beds = request.getParameter("number of beds");
		String number_of_baths = request.getParameter("number of baths");
		String number_of_bedrooms = request.getParameter("number of bedrooms");
		String living_room = request.getParameter("living room");
		String area = request.getParameter("area");
		request.setAttribute("location", location);
		request.setAttribute("address", address);
		request.setAttribute("transport", transport);
		request.setAttribute("first date", first_date);
		request.setAttribute("last date", last_date);
		request.setAttribute("max number of persons", max_number_of_persons);
		request.setAttribute("min value of tenancy", min_value_of_tenancy);
		request.setAttribute("additional cost per person", additional_cost_per_person);
		request.setAttribute("type of rental space", type_of_rental_space);
		request.setAttribute("smoking", smoking);
		request.setAttribute("pets", pets);
		request.setAttribute("event", event);
		request.setAttribute("min number of days", min_number_of_days);
		request.setAttribute("description", description);
		request.setAttribute("number of beds", number_of_beds);
		request.setAttribute("number of baths", number_of_baths);
		request.setAttribute("number of bedrooms", number_of_bedrooms);
		request.setAttribute("living room", living_room);
		request.setAttribute("area", area);
		java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.util.Date date2 = null;
		try {
			date = formatter.parse(first_date);
			date2 = formatter.parse(last_date);
			request.setAttribute("date", date);
			request.setAttribute("date2", date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		java.text.DateFormat formatter2 = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String date3 = formatter2.format(Houses_host.list.get(Houses_host.number - 1).getId().getFirst_date());
		String date4 = formatter2.format(Houses_host.list.get(Houses_host.number - 1).getId().getLast_date());
		em.getTransaction().begin();
		Query query = em.createNativeQuery("UPDATE House h SET h.location = '"+location+"', h.address = '"+address+"', h.transport = '"+transport+"', h.`first date` = '"+first_date+"', h.`last date` = '"+last_date+"', h.`max number of persons` = '"+max_number_of_persons+"', h.`min value of tenancy` = '"+min_value_of_tenancy+"', h.`additional cost per person`='"+additional_cost_per_person+"', h.`type of rental space`='"+type_of_rental_space+"', h.smoking='"+smoking+"', h.pets='"+pets+"', h.event='"+event+"', h.`min number of days`='"+min_number_of_days+"', h.description='"+description+"', h.`number of beds`='"+number_of_beds+"', h.`number of baths`='"+number_of_baths+"', h.`number of bedrooms`='"+number_of_bedrooms+"', h.`living room`='"+living_room+"', h.area='"+area+"' WHERE h.location='"+Houses_host.list.get(Houses_host.number - 1).getId().getLocation()+"' AND h.`first date`='"+date3+"' AND h.`last date`='"+date4+"' AND h.`max number of persons`='"+Houses_host.list.get(Houses_host.number - 1).getId().getMax_number_of_persons()+"' AND h.`min value of tenancy`='"+Houses_host.list.get(Houses_host.number - 1).getId().getMin_value_of_tenancy()+"'");
		query.executeUpdate();
		House house = em.find(House.class, Houses_host.list.get(Houses_host.number - 1).getId());
		house.setAddress(address);
		house.setTransport(transport);
		double cost = Double.parseDouble(additional_cost_per_person);
		house.setAdditional_cost_per_person(cost);
		house.setType_of_rental_space(type_of_rental_space);
		int smok = Integer.parseInt(smoking);
		house.setSmoking(smok);
		int pets2 = Integer.parseInt(pets);
		house.setPets(pets2);
		int event2 = Integer.parseInt(event);
		house.setEvent(event2);
		int days = Integer.parseInt(min_number_of_days);
		house.setMin_number_of_days(days);
		house.setDescription(description);
		int beds = Integer.parseInt(number_of_beds);
		house.setNumber_of_beds(beds);
		int baths = Integer.parseInt(number_of_baths);
		house.setNumber_of_baths(baths);
		int bedrooms = Integer.parseInt(number_of_bedrooms);
		house.setNumber_of_bedrooms(bedrooms);
		int living_room2 = Integer.parseInt(living_room);
		house.setLiving_room(living_room2);
		double area2 = Double.parseDouble(area);
		house.setArea(area2);
		em.getTransaction().commit();
		response.getWriter().println("Update successful.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
