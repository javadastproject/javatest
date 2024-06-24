package updatehouse;

import java.io.IOException;
import java.util.ArrayList;
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

import houses.Houses_host;
import model.House;

/**
 * Servlet implementation class Delete_photo
 */
@WebServlet("/Delete_photo")
public class Delete_photo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number = request.getParameter("number");
		request.setAttribute("number", number);
		List<String> filepaths = new ArrayList<String>();
		Houses_host.list.get(Houses_host.number - 1).setFilepaths2(filepaths);
		String[] path = Houses_host.list.get(Houses_host.number - 1).getFilepaths().split(",");
		for (String str: path) {
			Houses_host.list.get(Houses_host.number - 1).getFilepaths2().add(str);
		}
		int num = Integer.parseInt(number);
		Houses_host.list.get(Houses_host.number - 1).getFilepaths2().remove(num);
		String filepaths2 = Houses_host.list.get(Houses_host.number - 1).getFilepaths2().get(0);
		for (int i = 1; i < Houses_host.list.get(Houses_host.number - 1).getFilepaths2().size(); i++) {
			filepaths2 = filepaths2.concat(",");
			filepaths2 = filepaths2.concat(Houses_host.list.get(Houses_host.number - 1).getFilepaths2().get(i));
		}
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		em.getTransaction().begin();
		Query query = em.createNativeQuery("UPDATE House h SET h.filepaths = :parameter0"+" WHERE h.location=:parameter1"+" AND h.`first date`=:parameter2"+" AND h.`last date`=:parameter3"+" AND h.`max number of persons`=:parameter4"+" AND h.`min value of tenancy`=:parameter5").setParameter(":parameter0", filepaths2).setParameter(":parameter1", Houses_host.list.get(Houses_host.number - 1).getId().getLocation()).setParameter(":parameter2", formatter.format(Houses_host.list.get(Houses_host.number - 1).getId().getFirst_date())).setParameter(":parameter3", formatter.format(Houses_host.list.get(Houses_host.number - 1).getId().getLast_date())).setParameter(":parameter4", Houses_host.list.get(Houses_host.number - 1).getId().getMax_number_of_persons()).setParameter(":parameter5", Houses_host.list.get(Houses_host.number - 1).getId().getMin_value_of_tenancy());
		query.executeUpdate();
		House house = em.find(House.class, Houses_host.list.get(Houses_host.number - 1).getId());
		house.setFilepaths(filepaths2);
		em.getTransaction().commit();
		Houses_host.list.get(Houses_host.number - 1).setFilepaths(filepaths2);
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
