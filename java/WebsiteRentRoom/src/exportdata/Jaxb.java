package exportdata;




import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;






import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.*;

//import javax.xml.bind.annotation.XmlAttribute;


/**
 * Servlet implementation class Jaxb
 */
@WebServlet("/Jaxb")
public class Jaxb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Jaxb(){
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void jb(HttpServletRequest request,HttpServletResponse response,Per per,File file,int i,OutputStreamWriter writer){
		try {
	        //File file = new File("C:\\Users/alex/Downloads/file.xml");
	        JAXBContext jaxbContext = JAXBContext.newInstance(Per.class);
	 	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 	  
			
	 		// output pretty printed
	 		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
         
	 		//jaxbMarshaller.marshal(per, file);
	 		jaxbMarshaller.marshal(per, writer);
			jaxbMarshaller.marshal(per, System.out);	 		
	 		
	} catch (JAXBException e) {
	 		e.printStackTrace();
	 	      }
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		int i;//j = 0;
 		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Airbnb2");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    TypedQuery<Manager> query = em.createQuery("SELECT m FROM Manager m",Manager.class);
	    List<Manager> result = query.getResultList();
	    TypedQuery<Host> query1 = em.createQuery("SELECT h FROM Host h",Host.class);
	    List<Host> result1 = query1.getResultList();
	    TypedQuery<House> query2 = em.createQuery("SELECT h FROM House h",House.class);
	    List<House> result2 = query2.getResultList();
	    TypedQuery<Tenant> query3 = em.createQuery("SELECT t FROM Tenant t",Tenant.class);
	    List<Tenant> result3 = query3.getResultList();
	    Per per = new Per();
	    File file = new File("C:\\Users/Στυλιανός Σέρβος/file.xml");
	    
	    
	    FileOutputStream fileOutputStream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
	    
	    for(i=0; i<result.size(); i++){

	     //if(i<result.size()){
	    	per.setusername(result.get(i).getUsername());
	    	per.setfirstname(result.get(i).getFirst_name());
	    	per.setlastname(result.get(i).getLast_name());
	    	per.setemail(result.get(i).getEmail());
	    	per.setpassword(result.get(i).getPassword());
	    	per.settelephone(result.get(i).getTelephone());
	    	per.setmfilepath(result.get(i).getFilepath());
	    	jb(request,response,per,file,i,writer);
	    	}
	     // if(i<result1.size()){
	    for(int i1=0; i1<result1.size(); i1++){
	    	per.sethusername(result1.get(i1).getUsername());
	    	per.sethfirstname(result1.get(i1).getFirst_name());
	    	per.sethlastname(result1.get(i1).getLast_name());
	    	per.sethemail(result1.get(i1).getEmail());
	    	per.sethpassword(result1.get(i1).getPassword());
	    	per.sethtelephone(result1.get(i1).getTelephone());
	    	per.sethfilepath(result1.get(i1).getFilepath());
	    	jb(request,response,per,file,i,writer);}
	    //  if(i<result2.size()){
	    for(int i2=0; i2<result2.size(); i2++){
		    per.setacpp(result2.get(i2).getAdditional_cost_per_person());
		    per.setarea(result2.get(i2).getArea());
		    per.setdescription(result2.get(i2).getDescription());
		    per.setmvot(result2.get(i2).getId().getMin_value_of_tenancy());
		    per.setevent(result2.get(i2).getEvent());
		    per.setfilepath(result2.get(i2).getFilepath());
		    per.setfilepaths(result2.get(i2).getFilepaths());
		    per.settfrs(result2.get(i2).getType_of_rental_space());
		    per.setlastdate(result2.get(i2).getId().getLast_date());
		    per.setpets(result2.get(i2).getPets());
		    per.setliving_room(result2.get(i2).getLiving_room());
		    per.setlocation(result2.get(i2).getId().getLocation());
		    per.setaddress(result2.get(i2).getAddress());
		    per.settransport(result2.get(i2).getTransport());
		    per.setfirstdate(result2.get(i2).getId().getFirst_date());
		    per.setsmoking(result2.get(i2).getSmoking());
		    per.setmnop(result2.get(i2).getId().getMax_number_of_persons());
		    per.setnob(result2.get(i2).getNumber_of_beds());
		    per.setnobb(result2.get(i2).getNumber_of_baths());
		    per.setnobbv(result2.get(i2).getNumber_of_bedrooms());
		    per.setmnod(result2.get(i2).getMin_number_of_days());
		    per.setstars(result2.get(i2).getStars());
		    per.setreviews(result2.get(i2).getReviews());
		    per.setreviews_host(result2.get(i2).getReviews_host());
		    per.setmessages(result2.get(i2).getMessages());
		    per.setusername_host(result2.get(i2).getUsername_host());
		    jb(request,response,per,file,i,writer);}
            
	   //   if(i<result3.size()){
	    for(int i3=0; i3<result3.size(); i3++){
		    per.settusername(result3.get(i3).getUsername());
		    per.settfirstname(result3.get(i3).getFirst_name());
		    per.settlastname(result3.get(i3).getLast_name());
		    per.settemail(result3.get(i3).getEmail());
		    per.settpassword(result3.get(i3).getPassword());
		    per.setttelephone(result3.get(i3).getTelephone());
		    per.settfilepath(result3.get(i3).getFilepath());
		    per.setlocation_house(result3.get(i3).getLocation_house());
		    per.setfirstdate_house(result3.get(i3).getFirst_date_house());
		    per.setlastdate_house(result3.get(i3).getLast_date_house());
		    per.setmnop_house(result3.get(i3).getMax_number_of_persons_house());
		    per.setmvot_house(result3.get(i3).getMin_value_of_tenancy_house());
		    jb(request,response,per,file,i,writer);}
	    
	    
	    PrintWriter printWriter  = response.getWriter();
 		response.setContentType("text/html;charset=UTF-8");
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8'>");
        printWriter.println("<link rel='stylesheet' href='administrator/css/adminpage.css' />");
        printWriter.println("<title> Administration Page </title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<nav>"); 
        printWriter.println("    <div class=container>");
        printWriter.println("      <div class=admenu>");
        printWriter.println("		<ul>");
        printWriter.println("		  <li> <a href=List.jsp> List of users </a> </li>");
        printWriter.println("		  <li> <a href=Reser.jsp> Reservations </a> </li>");
        printWriter.println("		  <li> <a href=/Project/Jaxb> Export xml </a> </li>");
        printWriter.println("		  <li> <a href=adminprofile.html> Admin profile </a> </li>");
        printWriter.println("		</ul>");
        printWriter.println("      </div>");
        printWriter.println("    </div>");
        printWriter.println("  </nav>");
        printWriter.println("<div class='index'>");
        printWriter.println("       <h2 class='containindex'> Administration Index </h2>");
        printWriter.println("	   <p style='margin: -50px; margin-top:10px; margin-bottom: -20px; padding: 10px;'> 1. List of user &nbsp;&nbsp;&nbsp; 2.  Reservations &nbsp;&nbsp;&nbsp; 3.  Export xml </p>");
        printWriter.println("       <p style='margin: 20px;'> Succesfull export xml </p>");
        printWriter.println("      </p>");
                 
        printWriter.println("  </div>");

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
