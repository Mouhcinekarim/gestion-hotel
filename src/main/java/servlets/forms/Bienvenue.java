package servlets.forms;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.catalina.User;

import com.google.gson.Gson;

import dao.user.ConnectDatabase;
import dao.user.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class Bienvenue
 */
@WebServlet("/Bienvenue")
public class Bienvenue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
    
    public void init() throws ServletException {
        ConnectDatabase instance = ConnectDatabase.getInstance();
        this.userDao = instance.getUserDao();
        
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bienvenue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//	this.getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out =response.getWriter();
//		String UserName = request.getParameter("UserName");
//		
//		HttpSession userSession = request.getSession();
//		
//		//TODO : insert in all pages this session
//		
//		userSession.setAttribute("UserName", UserName);
////		request.setAttribute("UserName", nom);
//		this.getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		beans.User  user=userDao.connexion(email, password);
		if(user!=null) {
			
			String json = new Gson().toJson(user);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(json);
		}
		else {
			out.print("false");
			
		}
		
		
		
		
		
	}

}
