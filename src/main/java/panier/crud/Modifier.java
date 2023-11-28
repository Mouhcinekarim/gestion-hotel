package panier.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import beans.Customer;
import beans.Reservation;
import beans.User;
import dao.user.ConnectDatabase;

public class Modifier implements Crud{

	private ConnectDatabase connectDatabase;
	public Modifier(ConnectDatabase connectDatabase){
		this.connectDatabase = connectDatabase;
	}
	
	@Override
	public void ajouter(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(int IdCustomer,String date1,String date2) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
		//Customer customer = new Customer();
			 Connection connexion = null;
		        //PreparedStatement preparedStatement = null;
		        
		        try {
		        	connexion = connectDatabase.getConnection();
		        	PreparedStatement prepareStatement = connexion.prepareStatement("update reservation set DateStart = ?,DateEnd = ? where IdReservation = ?");
		        	prepareStatement.setString(1,date1);
		        	prepareStatement.setString(2,date2);
					prepareStatement.setInt(3,IdCustomer);
					prepareStatement.executeUpdate();
					//prepareStatement.executeQuery();						        
		      } catch (SQLException e) {
		            e.printStackTrace();
		        }
		       
		}


	

	//@Override
//	public List<Reservation> chercherReservation(String Cin) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Customer> chercherCustomer(String Cin) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Customer modifier(Customer customer) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reservation> chercherReservation(int idCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

}
