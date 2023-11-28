package servlets.crud;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import beans.Reservation;
//import dao.DaoFactory;
import dao.user.ConnectDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import panier.crud.Crud;
import panier.crud.Rechercher;

/**
 * Servlet implementation class Search
 */
@WebServlet("/SearchReservation")
public class SearchReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Crud list;
	
	public void init() throws ServletException {
        ConnectDatabase instance = ConnectDatabase.getInstance();
        this.list = instance.getCrudR();
    }
    public SearchReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		//TODO : comment transferer une session entre les servlets
		String cin =request.getParameter("cin");
		//out.println(cin);
		//ut.print("kkkkkk");
		List<Reservation>  list1=list.chercherReservation(Integer.parseInt(cin));
		String json = new Gson().toJson(list1);
		out.print(json);
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//HttpSession Cin = request.getSession();
		
		//request.setAttribute("reservations", );
		
		//
		//request.setAttribute("customers", list.chercherCustomer("v25688"));
	//	this.getServletContext().getRequestDispatcher("/reservation.jsp").forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//HttpSession cinSession = request.getSession();
		
		
	}

}
