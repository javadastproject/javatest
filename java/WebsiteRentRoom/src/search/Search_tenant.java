package search;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HouseDAO;
import dao.HouseDAOImpl;
import model.House;
import model.Tenant;
import sign.Sign_in;

/**
 * Servlet implementation class Search_tenant
 */
@WebServlet("/Search_tenant")
public class Search_tenant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<House> list1;
	public static int number;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		String page = request.getParameter("page");
		String page2 = request.getParameter("page2");
		String page3 = request.getParameter("page3");
		String house_number = request.getParameter("house number");
		String room_type = request.getParameter("room type");
		String maximum_cost = request.getParameter("maximum cost");
		String wireless_internet = request.getParameter("wireless internet");
		String cooling = request.getParameter("cooling");
		String heating = request.getParameter("heating");
		String kitchen = request.getParameter("kitchen");
		String television = request.getParameter("television");
		String parking = request.getParameter("parking");
		String lift = request.getParameter("lift");
		request.setAttribute("page", page);
		request.setAttribute("page2", page2);
		request.setAttribute("page3", page3);
		request.setAttribute("house number", house_number);
		request.setAttribute("room type", room_type);
		request.setAttribute("maximum cost", maximum_cost);
		request.setAttribute("wireless internet", wireless_internet);
		request.setAttribute("cooling", cooling);
		request.setAttribute("heating", heating);
		request.setAttribute("kitchen", kitchen);
		request.setAttribute("television", television);
		request.setAttribute("parking", parking);
		request.setAttribute("lift", lift);
		java.util.Date date = null;
		java.util.Date date2 = null;
		int totalpages, results_per_page = 10, pagenumber, pagenumber2, pagenumber3;
		java.text.DateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");
		int persons = Integer.parseInt(Sign_in.number_of_persons);
		request.setAttribute("persons", persons);
		try {
			date = formatter.parse(Sign_in.first_date);
			date2 = formatter.parse(Sign_in.last_date);
			request.setAttribute("date", date);
			request.setAttribute("date2", date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HouseDAO dao = new HouseDAOImpl();
		List<House> list = dao.list_by_location(em, Sign_in.location);
		
		for (House h: list) {
			List<Tenant> list_tenants = new ArrayList<Tenant>();
			h.setTenants(list_tenants);
		}
		
		list1 = new ArrayList<House>();
		for (House h: list) {
			if ((date.compareTo(h.getId().getFirst_date()) >= 0) && (date.compareTo(h.getId().getLast_date()) < 0)
				&& (date2.compareTo(h.getId().getFirst_date()) > 0) && (date2.compareTo(h.getId().getLast_date()) <= 0)
				&& (persons <= h.getId().getMax_number_of_persons())) {
					list1.add(h);
			}
		}
		int results = list1.size();
		totalpages = (int) Math.ceil((double) results / results_per_page);
		request.setAttribute("totalpages", totalpages);
		pagenumber = Integer.parseInt(page);
		pagenumber2 = Integer.parseInt(page2);
		pagenumber3 = Integer.parseInt(page3);
		number = Integer.parseInt(house_number);
		request.setAttribute("pagenumber", pagenumber);
		request.setAttribute("pagenumber2", pagenumber2);
		request.setAttribute("pagenumber3", pagenumber3);
		request.setAttribute("number", number);
		request.setAttribute("results per page", results_per_page);
		int offset = (pagenumber - 1) * results_per_page;
		int max_results = (pagenumber - 1) * results_per_page + results_per_page;
		List<House> sublist;
		if (results > max_results) {
			sublist = list1.subList(offset, max_results);
		}
		else {
			sublist = list1.subList(offset, results);
		}
		request.setAttribute("sublist", sublist);
		request.setAttribute("list2", list1);
		RequestDispatcher disp = request.getRequestDispatcher("/Results.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
