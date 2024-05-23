package houses;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Houses
 */
@WebServlet("/Houses")
@MultipartConfig
public class Houses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String location;
	public static String address;
	public static String transport;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		location = request.getParameter("location");
		address = request.getParameter("address");
		transport = request.getParameter("transport");
		request.setAttribute("location", location);
		request.setAttribute("address", address);
		request.setAttribute("transport", transport);
		RequestDispatcher disp = request.getRequestDispatcher("/Houses2.html");
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
