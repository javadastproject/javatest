package conversations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import houses.Houses_host;
import model.House;

/**
 * Servlet implementation class Conversations_host
 */
@WebServlet("/Conversations_host")
public class Conversations_host extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text = request.getParameter("conversations2");
		request.setAttribute("conversations2", text);
		String messages = null;
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String date1 = formatter.format(Houses_host.list.get(Houses_host.number - 1).getId().getFirst_date());
		String date2 = formatter.format(Houses_host.list.get(Houses_host.number - 1).getId().getLast_date());
		if (!Houses_host.list.get(Houses_host.number - 1).getMessages().isEmpty() && !Houses_host.list.get(Houses_host.number - 1).getMessages().equals(" ")) {
			String line = "/";
			messages = Houses_host.list.get(Houses_host.number - 1).getMessages().concat(line);
			messages = messages.concat(text);
		}
		else {
			messages = text;
		}
		em.getTransaction().begin();
		Query query = em.createNativeQuery("UPDATE House h SET h.messages = '"+messages+"' WHERE h.location='"+Houses_host.list.get(Houses_host.number - 1).getId().getLocation()+"' AND h.`first date`='"+date1+"' AND h.`last date`='"+date2+"' AND h.`max number of persons`='"+Houses_host.list.get(Houses_host.number - 1).getId().getMax_number_of_persons()+"' AND h.`min value of tenancy`='"+Houses_host.list.get(Houses_host.number - 1).getId().getMin_value_of_tenancy()+"'");
		query.executeUpdate();
		House house = em.find(House.class, Houses_host.list.get(Houses_host.number - 1).getId());
		house.setMessages(messages);
		em.getTransaction().commit();
		List<String> list_messages = new ArrayList<String>();
		Houses_host.list.get(Houses_host.number - 1).setMessages2(list_messages);
		if (messages.contains("/")) {
			for (String str: messages.split("/")) {
				Houses_host.list.get(Houses_host.number - 1).addMessage(str);
			}
		}
		else {
			Houses_host.list.get(Houses_host.number - 1).addMessage(messages);
		}
		request.setAttribute("list2", Houses_host.list.get(Houses_host.number - 1).getMessages2());
		RequestDispatcher disp = request.getRequestDispatcher("/Messages_host.jsp");
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
