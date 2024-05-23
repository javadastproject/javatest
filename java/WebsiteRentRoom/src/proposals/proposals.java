package proposals;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HouseDAO;
import dao.HouseDAOImpl;
import dao.TenantDAO;
import dao.TenantDAOImpl;
import model.House;
import model.Tenant;
import sign.Sign_in;

/**
 * Servlet implementation class proposals
 */
@WebServlet("/proposals")
public class proposals extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<String> list = new ArrayList<String>(); 
	public static List<String> list1 = new ArrayList<String>(); 
	public static List<String> list2 = new ArrayList<String>();
	public static List<House> list_houses_all = new ArrayList<House>();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		int i = 0;
		TenantDAO dao = new TenantDAOImpl();
		List<Tenant> result1 = dao.list(em);
	    for(Tenant results : result1) {
	    	java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
			String date1 = formatter.format(results.getFirst_date_house());
			String date2 = formatter.format(results.getLast_date_house());
	        if(results.getUsername().equals(Sign_in.username) && results.getPassword().equals(Sign_in.password) && !results.getLocation_house().equals(" ") && !date1.equals("0000-00-00") && !date2.equals("0000-00-00") && (results.getMax_number_of_persons_house() != 0) && (results.getMin_value_of_tenancy_house() != 0.0)) {
	            response.getWriter().println("The proposals will appear on the console. Please wait.");
	            i++;
	        }
	    }
	    if (i == 0) {
	    	list.add(Sign_in.first_date);
	    	list1.add(Sign_in.last_date);
	    	list2.add(Sign_in.location);
	    	HouseDAO dao2 = new HouseDAOImpl();
			List<House> list_houses = dao2.list_by_location(em, Sign_in.location);
			List<House> list_houses2 = new ArrayList<House>();
			java.util.Date date3 = null;
			java.util.Date date4 = null;
			java.text.DateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");
			int persons = Integer.parseInt(Sign_in.number_of_persons);
			try {
				date3 = formatter.parse(Sign_in.first_date);
				date4 = formatter.parse(Sign_in.last_date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (House h: list_houses) {
				if ((date3.compareTo(h.getId().getFirst_date()) >= 0) && (date3.compareTo(h.getId().getLast_date()) < 0)
					&& (date4.compareTo(h.getId().getFirst_date()) > 0) && (date4.compareTo(h.getId().getLast_date()) <= 0)
					&& (persons <= h.getId().getMax_number_of_persons())) {
					list_houses2.add(h);
				}
			}
			list_houses_all.addAll(list_houses2);
			response.getWriter().println("Searches:");
			response.getWriter().println("<br />");
	    	for (String str: list) {
	    		response.getWriter().println(str);
	    		response.getWriter().println("<br />");
	    	}
	    	for (String str2: list1) {
	    		response.getWriter().println(str2);
	    		response.getWriter().println("<br />");
	    	}
	    	for (String str3: list2) {
	    		response.getWriter().println(str3);
	    		response.getWriter().println("<br />");
	    	}
	    	response.getWriter().println("Spaces:");
			response.getWriter().println("<br />");
	    	for (House h: list_houses_all) {
	    		String date5 = formatter.format(h.getId().getFirst_date());
				String date6 = formatter.format(h.getId().getLast_date());
	    		response.getWriter().println(h.getId().getLocation());
	    		response.getWriter().println("<br />");
	    		response.getWriter().println(date5);
	    		response.getWriter().println("<br />");
	    		response.getWriter().println(date6);
	    		response.getWriter().println("<br />");
	    		response.getWriter().println(h.getId().getMax_number_of_persons());
	    		response.getWriter().println("<br />");
	    		response.getWriter().println(h.getId().getMin_value_of_tenancy());
	    		response.getWriter().println("<br />");
	    	}
	    }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
