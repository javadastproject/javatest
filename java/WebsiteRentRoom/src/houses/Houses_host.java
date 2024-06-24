package houses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;
import model.Tenant;
import sign.Sign_in;

/**
 * Servlet implementation class Houses_host
 */
@WebServlet("/Houses_host")
public class Houses_host extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<House> list;
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
		String house_number = request.getParameter("house number");
		request.setAttribute("username", Sign_in.username);
		request.setAttribute("page", page);
		request.setAttribute("page2", page2);
		request.setAttribute("house number", house_number);
		int pagenumber, pagenumber2;
		pagenumber = Integer.parseInt(page);
		request.setAttribute("pagenumber", pagenumber);
		pagenumber2 = Integer.parseInt(page2);
		request.setAttribute("pagenumber2", pagenumber2);
		number = Integer.parseInt(house_number);
		request.setAttribute("number", number);
		TypedQuery<House> query = em.createQuery("SELECT h FROM House AS h WHERE h.username_host = :parameter0", House.class).setParameter(":parameter0", Sign_in.host.getUsername());
		list = query.getResultList();
		Sign_in.host.setHouses(list);
		request.setAttribute("filepath", Sign_in.host.getFilepath());
		request.setAttribute("list", list);
		
		for (House h: list) {
			List<Tenant> list_tenants = new ArrayList<Tenant>();
			h.setTenants(list_tenants);
		}
		
		RequestDispatcher disp = request.getRequestDispatcher("/Houses.jsp");
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
