package sign;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HostDAO;
import dao.HostDAOImpl;
import dao.ManagerDAO;
import dao.ManagerDAOImpl;
import dao.TenantDAO;
import dao.TenantDAOImpl;
import model.Host;
import model.Manager;
import model.Tenant;

/**
 * Servlet implementation class Sign_in
 */
@WebServlet("/Sign_in")
public class Sign_in extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Host host;
	public static Tenant tenant;
	public static String username;
	public static String password;
	public static String location;
	public static String first_date;
	public static String last_date;
	public static String number_of_persons;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		username = request.getParameter("username");
		password = request.getParameter("password");
		location = request.getParameter("location");
		first_date = request.getParameter("first date");
		last_date = request.getParameter("last date");
		number_of_persons = request.getParameter("number of persons");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("location", location);
		request.setAttribute("first date", first_date);
		request.setAttribute("last date", last_date);
		request.setAttribute("number of persons", number_of_persons);
		HostDAO dao1 = new HostDAOImpl();
		host = dao1.find(em, username);
		TenantDAO dao2 = new TenantDAOImpl();
		tenant = dao2.find(em, username);
		ManagerDAO dao3 = new ManagerDAOImpl();
		Manager manager = dao3.find(em, username);
		request.setAttribute("host", host);
		request.setAttribute("tenant", tenant);
		request.setAttribute("manager", manager);
		if (!username.equals("Anonymous")) {
			RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
			disp.forward(request, response);
		}
		else {
			RequestDispatcher disp = request.getRequestDispatcher("/Search_tenant.html");
			disp.forward(request, response);
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
