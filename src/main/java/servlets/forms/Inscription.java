package servlets.forms;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;

import com.google.gson.Gson;

import beans.User;
import dao.user.ConnectDatabase;
import dao.user.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//import metier.Produit;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private UserDao userDao;
      
      public void init() throws ServletException {
          ConnectDatabase instance = ConnectDatabase.getInstance();
          this.userDao = instance.getUserDao();
      }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		PrintWriter out= response.getWriter();
		 if( request.getParameter("json")!=null) {
				
				String text = request.getParameter("json");
			
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				//System.out.println(json);
				Gson g = new Gson();  
			    user = g.fromJson(text, User.class) ;
			    userDao.ajouter(user);
				out.print(text);
				 out.close();
		  }
		  else {
			  out.print("karim");
			  out.close();
		  }
//		String UserName = request.getParameter("UserName");
//		user.setUserName(UserName);
//		user.setPassword(request.getParameter("Password"));
//		user.setEmail(request.getParameter("Email"));
//			
		
//		HttpSession UserSession = request.getSession();
//		UserSession.setAttribute("UserName",UserName);
		//response.sendRedirect("bienvenue.jsp");
		//this.getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);		
	}

}
