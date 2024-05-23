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
		// TODO Auto-generated method stub
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
	    em.createNativeQuery("UPDATE House h SET h.`username host` = '"+uname+"' WHERE h.`username host`='"+Sign_in.host.getUsername()+"'").executeUpdate();
	    em.getTransaction().commit();
	    
		em.getTransaction().begin();
	    em.createNativeQuery("UPDATE Host nte SET nte.username = '"+uname+"', nte.`first name`= '"+fname+"', nte.email='"+eml+"', nte.telephone='"+tel+"', nte.`last name`='"+lname+"', nte.password='"+passwd+"' WHERE nte.username='"+Sign_in.host.getUsername()+"'").executeUpdate();
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
