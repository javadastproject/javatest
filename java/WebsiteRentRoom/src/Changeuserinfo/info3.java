package Changeuserinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class info
 */
@WebServlet("/info")
public class info3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String fname =  request.getParameter("firstname");
		String uname = request.getParameter("username");
		String eml = request.getParameter("email");
		String tel = request.getParameter("telephone");
		String lname = request.getParameter("lastname");
		String passwd = request.getParameter("password");
		
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if (fname.isEmpty() || uname.isEmpty() || eml.isEmpty() || tel.isEmpty() || lname.isEmpty() || passwd.isEmpty()){
			return;
		}
	    em.createNativeQuery("UPDATE Manager nte SET nte.username = :parameter0"+", nte.`first name`= :parameter1"+", nte.email=:parameter2"+", nte.telephone=:parameter3"+", nte.`last name`=:parameter4"+", nte.password=:parameter5").setParameter(":parameter0", request.getParameter("username")).setParameter(":parameter1", request.getParameter("firstname")).setParameter(":parameter2", request.getParameter("email")).setParameter(":parameter3", request.getParameter("telephone")).setParameter(":parameter4", request.getParameter("lastname")).setParameter(":parameter5", request.getParameter("password")).executeUpdate();
	    em.getTransaction().commit();
		
			
		PrintWriter printWriter  = response.getWriter();
 		response.setContentType("text/html;charset=UTF-8");
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>");
        printWriter.println("<title></title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h2 align='center'>Succesfull Change User Info</h2>");
        printWriter.println("<p align='center'><a href='administrator/adminpage.html'>Return in previous pages</a> </p>");
        printWriter.println("</body>");
        printWriter.println("</html>");
      
	}

	
	protected void doGet_fix(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String fname =  request.getParameter("firstname");
		String uname = request.getParameter("username");
		String eml = request.getParameter("email");
		String tel = request.getParameter("telephone");
		String lname = request.getParameter("lastname");
		String passwd = request.getParameter("password");
		
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if (fname.isEmpty() || uname.isEmpty() || eml.isEmpty() || tel.isEmpty() || lname.isEmpty() || passwd.isEmpty()){
			return;
		}

		Query updateQuery = em.createNativeQuery("UPDATE Manager nte SET nte.username = :username, nte.`first name`= :firstName, nte.email= :email, nte.telephone= :telephone, nte.`last name`= :lastName, nte.password= :password");
		updateQuery.setParameter("username", uname);
		updateQuery.setParameter("firstName", fname);
		updateQuery.setParameter("email", eml);
		updateQuery.setParameter("telephone", tel);
		updateQuery.setParameter("lastName", lname);
		updateQuery.setParameter("password", passwd);
		updateQuery.executeUpdate();
	    
	    em.getTransaction().commit();
		
			
		PrintWriter printWriter  = response.getWriter();
 		response.setContentType("text/html;charset=UTF-8");
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>");
        printWriter.println("<title></title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h2 align='center'>Succesfull Change User Info</h2>");
        printWriter.println("<p align='center'><a href='administrator/adminpage.html'>Return in previous pages</a> </p>");
        printWriter.println("</body>");
        printWriter.println("</html>");
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
