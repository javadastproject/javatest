package reviews;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TenantDAO;
import dao.TenantDAOImpl;
import model.House;
import model.Tenant;
import search.Search_tenant;
import sign.Sign_in;

/**
 * Servlet implementation class Reviews
 */
@WebServlet("/Reviews")
public class Reviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reviews = request.getParameter("reviews");
		String reviews_host = request.getParameter("reviews host");
		request.setAttribute("reviews", reviews);
		request.setAttribute("reviews host", reviews_host);
		int reviews2 = Integer.parseInt(reviews);
		request.setAttribute("reviews2", reviews2);
		int reviews3 = Integer.parseInt(reviews_host);
		request.setAttribute("reviews3", reviews3);
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String date1 = formatter.format(Search_tenant.list1.get(Search_tenant.number - 1).getId().getFirst_date());
		String date2 = formatter.format(Search_tenant.list1.get(Search_tenant.number - 1).getId().getLast_date());
		em.getTransaction().begin();
	    Query query = em.createNativeQuery("UPDATE House h SET h.reviews = '"+reviews2+"', h.`reviews host`= '"+reviews3+"' WHERE h.location=:parameter0"+" AND h.`first date`=:parameter1"+" AND h.`last date`=:parameter2"+" AND h.`max number of persons`=:parameter3"+" AND h.`min value of tenancy`=:parameter4").setParameter(":parameter0", Search_tenant.list1.get(Search_tenant.number - 1).getId().getLocation()).setParameter(":parameter1", formatter.format(Search_tenant.list1.get(Search_tenant.number - 1).getId().getFirst_date())).setParameter(":parameter2", formatter.format(Search_tenant.list1.get(Search_tenant.number - 1).getId().getLast_date())).setParameter(":parameter3", Search_tenant.list1.get(Search_tenant.number - 1).getId().getMax_number_of_persons()).setParameter(":parameter4", Search_tenant.list1.get(Search_tenant.number - 1).getId().getMin_value_of_tenancy());
	    query.executeUpdate();
	    House house = em.find(House.class, Search_tenant.list1.get(Search_tenant.number - 1).getId());
	    house.setReviews(reviews2);
	    house.setReviews_host(reviews3);
	    em.getTransaction().commit();
	    TenantDAO dao = new TenantDAOImpl();
	    List<Tenant> list = dao.list_by_house(em, Search_tenant.list1.get(Search_tenant.number - 1).getId().getLocation(), date1, date2, Search_tenant.list1.get(Search_tenant.number - 1).getId().getMax_number_of_persons(), Search_tenant.list1.get(Search_tenant.number - 1).getId().getMin_value_of_tenancy());
		Sign_in.tenant.setHouse(Search_tenant.list1.get(Search_tenant.number - 1));
		Search_tenant.list1.get(Search_tenant.number - 1).setTenants(list);
		if (Search_tenant.list1.get(Search_tenant.number - 1).getTenants().size() < Search_tenant.list1.get(Search_tenant.number - 1).getId().getMax_number_of_persons()) {
			Search_tenant.list1.get(Search_tenant.number - 1).addTenant(Sign_in.tenant);
			em.getTransaction().begin();
		    Query query2 = em.createNativeQuery("UPDATE Tenant t SET t.`location house`=:parameter0"+", t.`first date house`=:parameter1"+", t.`last date house`=:parameter2"+", t.`max number of persons house`=:parameter3"+", t.`min value of tenancy house`=:parameter4"+" WHERE t.username=:parameter5").setParameter(":parameter0", Search_tenant.list1.get(Search_tenant.number - 1).getId().getLocation()).setParameter(":parameter1", formatter.format(Search_tenant.list1.get(Search_tenant.number - 1).getId().getFirst_date())).setParameter(":parameter2", formatter.format(Search_tenant.list1.get(Search_tenant.number - 1).getId().getLast_date())).setParameter(":parameter3", Search_tenant.list1.get(Search_tenant.number - 1).getId().getMax_number_of_persons()).setParameter(":parameter4", Search_tenant.list1.get(Search_tenant.number - 1).getId().getMin_value_of_tenancy()).setParameter(":parameter5", Sign_in.tenant.getUsername());
		    query2.executeUpdate();
		    Tenant tenant = em.find(Tenant.class, Sign_in.tenant.getUsername());
		    tenant.setLocation_house(Search_tenant.list1.get(Search_tenant.number - 1).getId().getLocation());
		    tenant.setFirst_date_house(Search_tenant.list1.get(Search_tenant.number - 1).getId().getFirst_date());
		    tenant.setLast_date_house(Search_tenant.list1.get(Search_tenant.number - 1).getId().getLast_date());
		    tenant.setMax_number_of_persons_house(Search_tenant.list1.get(Search_tenant.number - 1).getId().getMax_number_of_persons());
		    tenant.setMin_value_of_tenancy_house(Search_tenant.list1.get(Search_tenant.number - 1).getId().getMin_value_of_tenancy());
		    em.getTransaction().commit();
			response.getWriter().println("Reservation successful.");
		}
		else {
			response.getWriter().println("Reservation failed.");
		}
	}

}
