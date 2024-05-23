package sign;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.HostDAO;
import dao.HostDAOImpl;
import dao.ManagerDAO;
import dao.ManagerDAOImpl;
import dao.TenantDAO;
import dao.TenantDAOImpl;
import model.Host;
import model.House;
import model.Manager;
import model.Tenant;

/**
 * Servlet implementation class Sign_up
 */
@WebServlet("/Sign_up")
@MultipartConfig
public class Sign_up extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("password");
		String first_name = request.getParameter("first name");
		String last_name = request.getParameter("last name");
		String email = request.getParameter("e-mail");
		String telephone = request.getParameter("telephone");
		String role = request.getParameter("role");
		Part photo = request.getPart("datafile");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("confirm_password", confirm_password);
		request.setAttribute("first_name", first_name);
		request.setAttribute("last_name", last_name);
		request.setAttribute("email", email);
		request.setAttribute("telephone", telephone);
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/Message.jsp");
		if (role.equals("host")) {
			HostDAO dao1 = new HostDAOImpl();
			Host host = dao1.find(em, username);
			if (host == null) {
				em.getTransaction().begin();
				Host host1 = new Host();
				host1.setUsername(username);
				host1.setPassword(password);
				host1.setFirst_name(first_name);
				host1.setLast_name(last_name);
				host1.setEmail(email);
				host1.setTelephone(telephone);
				host1.setPhoto(photo);
				String path = photo.getSubmittedFileName();
				String path2 = path.substring(0, 2);
				String path3 = path.substring(2, path.length());
				String path4 = path2.concat("/");
				String filepath = path4.concat(path3);
				host1.setFilepath(filepath);
				List<House> list_houses = new ArrayList<House>();
				host1.setHouses(list_houses);
				dao1.create(em, host1);
				em.getTransaction().commit();
				disp.forward(request, response);
			}
			else {
				response.getWriter().println("Host with username" + " " + username + " " + "already exists.");
				response.getWriter().println("Please give new username.");
			}
		}
		else if (role.equals("manager")) {
			ManagerDAO dao2 = new ManagerDAOImpl();
			Manager manager = dao2.find(em, username);
			if (manager == null) {
				em.getTransaction().begin();
				Manager manager1 = new Manager();
				manager1.setUsername(username);
				manager1.setPassword(password);
				manager1.setFirst_name(first_name);
				manager1.setLast_name(last_name);
				manager1.setEmail(email);
				manager1.setTelephone(telephone);
				manager1.setPhoto(photo);
				String path = photo.getSubmittedFileName();
				String path2 = path.substring(0, 2);
				String path3 = path.substring(2, path.length());
				String path4 = path2.concat("/");
				String filepath = path4.concat(path3);
				manager1.setFilepath(filepath);
				dao2.create(em, manager1);
				em.getTransaction().commit();
				disp.forward(request, response);
			}
			else {
				response.getWriter().println("Manager with username" + " " + username + " " + "already exists.");
				response.getWriter().println("Please give new username.");
			}
		}
		else if (role.equals("tenant")) {
			TenantDAO dao3 = new TenantDAOImpl();
			Tenant tenant = dao3.find(em, username);
			if (tenant == null) {
				em.getTransaction().begin();
				Tenant tenant1 = new Tenant();
				tenant1.setUsername(username);
				tenant1.setPassword(password);
				tenant1.setFirst_name(first_name);
				tenant1.setLast_name(last_name);
				tenant1.setEmail(email);
				tenant1.setTelephone(telephone);
				tenant1.setPhoto(photo);
				String path = photo.getSubmittedFileName();
				String path2 = path.substring(0, 2);
				String path3 = path.substring(2, path.length());
				String path4 = path2.concat("/");
				String filepath = path4.concat(path3);
				tenant1.setFilepath(filepath);
				tenant1.setLocation_house(" ");
				String date1 = "00-00-0000";
				String date2 = "00-00-0000";
				java.text.DateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");
				java.util.Date date3 = null;
				java.util.Date date4 = null;
				try {
					date3 = formatter.parse(date1);
					date4 = formatter.parse(date2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tenant1.setFirst_date_house(date3);
				tenant1.setLast_date_house(date4);
				tenant1.setMax_number_of_persons_house(0);
				tenant1.setMin_value_of_tenancy_house(0.0);
				dao3.create(em, tenant1);
				em.getTransaction().commit();
				disp.forward(request, response);
			}
			else {
				response.getWriter().println("Tenant with username" + " " + username + " " + "already exists.");
				response.getWriter().println("Please give new username.");
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
