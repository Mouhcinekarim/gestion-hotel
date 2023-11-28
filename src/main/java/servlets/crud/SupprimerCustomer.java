package servlets.crud;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import dao.user.ConnectDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import panier.crud.Crud;

/**
 * Servlet implementation class SupprimerCustomer
 */
@WebServlet("/SupprimerCustomer")
public class SupprimerCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Crud customer;
	
	public void init() throws ServletException {
        ConnectDatabase instance = ConnectDatabase.getInstance();
        this.customer = instance.getCrudS();
    }
    /**
     *  @see HttpServlet#HttpServlet()
     */
    public SupprimerCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//TODO  :  Home makaynack
		
	//	this.getServletContext().getRequestDispatcher("/supprimer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		customer.supprimer(Integer.parseInt(request.getParameter("id")));
		
		//this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	}

}
