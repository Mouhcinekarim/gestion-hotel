package panier.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Customer;
import beans.Reservation;
//import beans.Utilisateur;
import dao.user.ConnectDatabase;
//import jakarta.websocket.Session;


public class Rechercher implements Crud{
	
	private ConnectDatabase connectDatabase;
	public Rechercher(ConnectDatabase connectDatabase){
		this.connectDatabase = connectDatabase;
	}
	@Override
	public void ajouter(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

	


	@Override
	public List<Reservation> chercherReservation(int cin) {
		
		// TODO Auto-generated method stub
	        List<Reservation> reservations = new ArrayList<Reservation>();
	       
	        Connection connexion = null;
//	        Statement statement = null;
//	        ResultSet resultat = null;
	        

	        try {
	            connexion = connectDatabase.getConnection();
//	            statement = connexion.createStatement();
//	            
//	            resultat = statement.executeQuery("SELECT IdReservation, TotalRooms FROM reservation,customer where customer.Cin ="+Cin+";");
//	            
	            PreparedStatement prepareStatement = connexion.prepareStatement("SELECT IdReservation, DateStart,DateEnd from reservation where   cin = ?");
				 prepareStatement.setInt(1,cin);
					ResultSet resultat = prepareStatement.executeQuery();
	            while (resultat.next() ) {
	                int IdReservation = resultat.getInt("IdReservation");
	                String date1 = resultat.getString("DateStart");
	                String date2 = resultat.getString("DateEnd");
	                Reservation reservation = new Reservation();	                
	                reservation.setIdReservation(IdReservation);
	                reservation.setDateStart(date1);
	                reservation.setDateEnd(date2);
	                reservations.add(reservation);            
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
				connexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return reservations;
	    }
//	@Override
//	public List<Reservation> chercherRservation(String Cin) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	public List<Customer> chercherCustomer(String Cin) {
		// TODO Auto-generated method stub
		 List<Customer> Customers  = new ArrayList<Customer>();
		 Connection connexion = null;
//	        Statement statement2 = null;
//	        ResultSet resultat2 = null;
	        try {
	        	connexion = connectDatabase.getConnection();
//	            statement2 = connexion.createStatement();
//	        	resultat2 = statement2.executeQuery("SELECT Phone, DateStart,DateEnd FROM customer where IdCustomer = "+Cin+";");
	        	PreparedStatement prepareStatement = connexion.prepareStatement("SELECT Phone, DateStart,DateEnd FROM customer where Cin = '?'");
				 prepareStatement.setString(1,Cin);
					ResultSet resultat2 = prepareStatement.executeQuery();
	        	while( resultat2.next()) {
	    	        
	    	        int Phone = resultat2.getInt("Phone");
	                String DateStart = resultat2.getString("DateStart");
	                String DateEnd = resultat2.getString("DateEnd");
	                Customer customer = new Customer();
	                customer.setPhone(Phone);
//	                customer.setDateStart(DateStart);
//	                customer.setDateEnd(DateEnd);
	                
	                Customers.add(customer);
	        	}

	        } catch (Exception e) {
				// TODO: handle exception
			}
	        		return Customers;
	}
//@Override
//public Customer modifier(Customer customer) {
//	// TODO Auto-generated method stub
//	return null;
//}
@Override
public void supprimer(int id) {
	// TODO Auto-generated method stub
	
}
@Override
public void modifier(int IdCustomer, String date1, String date2) {
	// TODO Auto-generated method stub
	
}
//@Override
//public List<Reservation> chercherReservation(int idCustomer) {
//	// TODO Auto-generated method stub
//	return null;
//}
	
	

}
