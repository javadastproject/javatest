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
 * Servlet implementation class Delete_message
 */
@WebServlet("/Delete_message")
public class Delete_message extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number = request.getParameter("number");
		request.setAttribute("number", number);
		List<String> list_messages = new ArrayList<String>();
		Houses_host.list.get(Houses_host.number - 1).setMessages2(list_messages);
		String[] array_messages = Houses_host.list.get(Houses_host.number - 1).getMessages().split("/");
		for (String str: array_messages) {
			Houses_host.list.get(Houses_host.number - 1).getMessages2().add(str);
		}
		String messages;
		int num = Integer.parseInt(number);
		Houses_host.list.get(Houses_host.number - 1).removeMessage(Houses_host.list.get(Houses_host.number - 1).getMessages2().get(num));
		if (!Houses_host.list.get(Houses_host.number - 1).getMessages2().isEmpty()) {
			messages = Houses_host.list.get(Houses_host.number - 1).getMessages2().get(0);
			for (int i = 1; i < Houses_host.list.get(Houses_host.number - 1).getMessages2().size(); i++) {
				messages = messages.concat("/");
				messages = messages.concat(Houses_host.list.get(Houses_host.number - 1).getMessages2().get(i));
			}
		}
		else {
			messages = " ";
		}
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		em.getTransaction().begin();
		Query query = em.createNativeQuery("UPDATE House h SET h.messages = :parameter0"+" WHERE h.location=:parameter1"+" AND h.`first date`=:parameter2"+" AND h.`last date`=:parameter3"+" AND h.`max number of persons`=:parameter4"+" AND h.`min value of tenancy`=:parameter5").setParameter(":parameter0", messages).setParameter(":parameter1", Houses_host.list.get(Houses_host.number - 1).getId().getLocation()).setParameter(":parameter2", formatter.format(Houses_host.list.get(Houses_host.number - 1).getId().getFirst_date())).setParameter(":parameter3", formatter.format(Houses_host.list.get(Houses_host.number - 1).getId().getLast_date())).setParameter(":parameter4", Houses_host.list.get(Houses_host.number - 1).getId().getMax_number_of_persons()).setParameter(":parameter5", Houses_host.list.get(Houses_host.number - 1).getId().getMin_value_of_tenancy());
		query.executeUpdate();
		House house = em.find(House.class, Houses_host.list.get(Houses_host.number - 1).getId());
		house.setMessages(messages);
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
