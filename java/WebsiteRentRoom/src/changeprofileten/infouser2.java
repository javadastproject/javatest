package changeprofileten;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sign.Sign_in;

/**
 * Servlet implementation class infouser2
 */
@WebServlet("/infouser2")
public class infouser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public infouser2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
        	
        
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("Airbnb2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.createNativeQuery("UPDATE House h SET h.`username host` = :parameter0"+" WHERE h.`username host`=:parameter1").setParameter(":parameter0", request.getParameter("username")).setParameter(":parameter1", Sign_in.host.getUsername()).executeUpdate();
	    em.getTransaction().commit();
	    
		em.getTransaction().begin();
	    em.createNativeQuery("UPDATE Host nte SET nte.username = :parameter0"+", nte.`first name`= :parameter1"+", nte.email=:parameter2"+", nte.telephone=:parameter3"+", nte.`last name`=:parameter4"+", nte.password=:parameter5"+" WHERE nte.username=:parameter6").setParameter(":parameter0", request.getParameter("username")).setParameter(":parameter1", request.getParameter("firstname")).setParameter(":parameter2", request.getParameter("email")).setParameter(":parameter3", request.getParameter("telephone")).setParameter(":parameter4", request.getParameter("lastname")).setParameter(":parameter5", request.getParameter("password")).setParameter(":parameter6", Sign_in.host.getUsername()).executeUpdate();
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
        printWriter.println("<p align='center'><a href='useradminprofile2'>Return in previous pages</a> </p>");
        printWriter.println("</body>");
        printWriter.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
