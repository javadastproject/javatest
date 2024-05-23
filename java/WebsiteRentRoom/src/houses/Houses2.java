package houses;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.HouseDAO;
import dao.HouseDAOImpl;
import model.House;
import model.HousePK;
import model.Tenant;
import sign.Sign_in;

/**
 * Servlet implementation class Houses2
 */
@WebServlet("/Houses2")
@MultipartConfig
public class Houses2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<House> list = new ArrayList<House>();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
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
		Part photo = request.getPart("datafile");
		Collection<Part> parts = request.getParts();
		String stars = request.getParameter("stars");
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
		request.setAttribute("stars", stars);
		java.text.DateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");
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
		HouseDAO dao = new HouseDAOImpl();
		em.getTransaction().begin();
		HousePK id = new HousePK();
		House house = new House();
		id.setLocation(Houses.location);
		id.setFirst_date(date);
		id.setLast_date(date2);
		int persons = Integer.parseInt(max_number_of_persons);
		id.setMax_number_of_persons(persons);
		double tenancy = Double.parseDouble(min_value_of_tenancy);
		id.setMin_value_of_tenancy(tenancy);
		house.setAddress(Houses.address);
		house.setTransport(Houses.transport);
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
		house.setId(id);
		house.setPhoto(photo);
		String path = photo.getSubmittedFileName();
		String path2 = path.substring(0, 2);
		String path3 = path.substring(2, path.length());
		String path4 = path2.concat("/");
		String filepath = path4.concat(path3);
		house.setFilepath(filepath);
		String filepaths;
		List<String> filepaths2 = new ArrayList<String>();
		for (Part p: parts) {
			String str = p.getSubmittedFileName();
			if ((str != null) && (!str.equals(path))) {
				filepaths2.add(str);
			}
		}
		filepaths = filepaths2.get(0);
		for (int i = 1; i < filepaths2.size(); i++) {
			filepaths = filepaths.concat(",");
			filepaths = filepaths.concat(filepaths2.get(i));
		}
		house.setFilepaths(filepaths);
		house.setFilepaths2(filepaths2);
		int stars2 = Integer.parseInt(stars);
		house.setStars(stars2);
		house.setReviews(0);
		house.setReviews_host(0);
		house.setHost(Sign_in.host);
		house.setUsername_host(Sign_in.host.getUsername());
		List<String> list_messages = new ArrayList<String>();
		List<Tenant> list_tenants = new ArrayList<Tenant>();
		house.setMessages(" ");
		house.setMessages2(list_messages);
		house.setTenants(list_tenants);
		dao.create(em, house);
		em.getTransaction().commit();
		list.add(house);
		Sign_in.host.addHous(house);
		response.getWriter().println("Save successful.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
