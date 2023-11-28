package servlets.forms;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.apache.tomcat.util.json.JSONParser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import beans.Customer;
import beans.Reservation;
import beans.Room;

import beans.User;
import dao.customer.CustomerDao;
import dao.reservation.ReservationDao;
import dao.reservation.ReservationDaoImpl;
import dao.user.ConnectDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import panier.crud.Rechercher;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/CustomerInfo")
public class CustomerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CustomerDao customerDao;
       private ReservationDao reservationDao;
       private Rechercher recherche;
       public void init() throws ServletException {
           ConnectDatabase instance = ConnectDatabase.getInstance();
           this.customerDao =instance.getCustomerDao();
           this.reservationDao= instance.getReservationDao();
            
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//this.getServletContext().getRequestDispatcher("/customerInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cin;
		cin=request.getParameter("cin");
			
		
		
		
		// TODO Auto-generated method stub
		///doGet(request, response);
		PrintWriter out=response.getWriter();
		try {
			
		out.println("1");
		//hr.send("res="+JSON.stringify(obj1)+";cus"+JSON.stringify(obj2));
		
		String res=request.getParameter("res");
		String cus=request.getParameter("cus");
		String chem=request.getParameter("chem");
		out.println("2");
		
		//out.print("hamza"+res+"     "+cus);
		//out.close();
		/*
		  var cus={
    Phone:"064353805",
    Cin:cin.value,
    CardNumber:"1234567890",
    DateStart:datrev.value,
    DateEnd:datedep.value

   }
  // chambres:chambres()
  var chem=chambres();
  
var res={
  IdCustomer:cin.value,
  TotalRooms:(nbr_sumple.value+nbr_multipl.value+nbr_famulial.value),
  DateReservation:datrev.value,
  NumberOfMembers:nb.value,
  prixtotal:(nbr_sumple.value*200+nbr_multipl.value*45+nbr_famulial.value*70)
  
}; 
		  
		 */
//		String  cus="{"+
//				  "  Phone":"064353805",
//				   " Cin":"22222",
//				   " CardNumber":"1234567890",
//				   " DateStart":"2020-05-03",
//				   " DateEnd":"2020-05-03"
//
//				   +"}";
		Customer customer = new Customer();
		out.println("3");
		Reservation reservation = new Reservation();
		out.println("4");
		Gson g = new Gson();  
		if(cus==null) out.println("null "+cus);
		else out.println(cus);
		customer = g.fromJson(cus, Customer.class) ;
		out.println("5");
		 customerDao.ajouter(customer);
		 out.println("6");
		 if(res==null) out.println("null "+res);
			else out.println(res);
		reservation = g.fromJson(res, Reservation.class) ;
		out.println("7");
		reservationDao.ajouter(reservation);
		out.println("8");
		////remplir les chambre
		
	     Room room ;
	     if(request.getParameter("simple")!=null) {
	    	 for(int i=0;i<Integer.parseInt(request.getParameter("simple"));i++) {
	    		 room= new Room();
	    		
	    		 room.setTypeRoom("simple");
	    		 reservationDao.ajouter(room);
	    		 
	    	 }
	     }
	     else  out.write("simple");
	     if(request.getParameter("double")!=null) {
	    	 for(int i=0;i<Integer.parseInt(request.getParameter("double"));i++) {
	    		 room= new Room();
	    		 
	    		 room.setTypeRoom("double");
	    		 reservationDao.ajouter(room);
	    		 reservationDao.ajouterHistory();
	    	 }
	     }
	     else  out.write("double");
	     if(request.getParameter("groupe")!=null) {
	    	 for(int i=0;i<Integer.parseInt(request.getParameter("groupe"));i++) {
	    		 room= new Room();
	    		
	    		 room.setTypeRoom("groupe");
	    		 reservationDao.ajouter(room);
	    		 reservationDao.ajouterHistory();
	    	 }
	     }
	     else out.write("groupe");
	     
		}
		catch(Exception E) {
			out.print(E.getMessage());
			out.close();
		}
	
		
		 
			
//		customer.setPhone(Integer.parseInt(request.getParameter("Phone")));
//		customer.setCin(request.getParameter("Cin"));
//		customer.setCardNumber(Integer.parseInt(request.getParameter("CardNumber")));
//		customer.setDateStart(request.getParameter("DateStart"));
//		customer.setDateEnd(request.getParameter("DateEnd"));
//		
//		customerDao.ajouter(customer);
//		HttpSession customerSession = request.getSession();
//		customerSession.setAttribute("Cin", request.getParameter("Cin"));
		
		//this.getServletContext().getRequestDispatcher("/roomsInfo.jsp").forward(request, response);
		}
	}


