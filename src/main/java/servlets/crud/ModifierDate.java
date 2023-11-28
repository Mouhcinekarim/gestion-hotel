package servlets.crud;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import beans.Customer;
import dao.user.ConnectDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import panier.crud.Crud;

/**
 * Servlet implementation class ModifierImpl
 */
@WebServlet("/ModifierDate")
public class ModifierDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Crud customer;
	
	public void init() throws ServletException {
        ConnectDatabase instance = ConnectDatabase.getInstance();
        this.customer = instance.getCrudM();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//this.getServletContext().getRequestDispatcher("/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		int id = request.getParameter("IdCusomer");
      PrintWriter out=response.getWriter();
      out.println("ka");
      out.println("1");
		Customer cust = new Customer();
		out.println("2");
		out.println(Integer.parseInt(request.getParameter("id"))+" "+request.getParameter("date1")+" "+request.getParameter("date2"));
		customer.modifier(Integer.parseInt(request.getParameter("id")), request.getParameter("date1"), request.getParameter("date2"));
		out.println("3");
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//cust.setIdCustomer(Integer.parseInt(request.getParameter("IdCustomer")));
		//cust.setDateStart(request.getParameter("date1"));
		//cust.setDateEnd(request.getParameter("date2"));
		//request.setAttribute("customer",cust);
		out.println("4");
		//this.getServletContext().getRequestDispatcher("/reservation.html").forward(request, response);
		 out.close();
	}

}
