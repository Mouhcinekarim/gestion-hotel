package panier.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import beans.Customer;
import beans.Reservation;
import dao.user.ConnectDatabase;

public class Supprimer implements Crud{

	private ConnectDatabase connectDatabase;
	public Supprimer(ConnectDatabase connectDatabase){
		this.connectDatabase = connectDatabase;
	}
	@Override
	public void ajouter(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(int IdCustomer, String date1, String date2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		Connection connexion = null;
		try {
        	connexion = connectDatabase.getConnection();
        	PreparedStatement prepareStatement = connexion.prepareStatement("delete from reservation  where IdReservation = ?");
        	prepareStatement.setInt(1,id);
        	prepareStatement.executeUpdate();
	}catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public List<Reservation> chercherReservation(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> chercherCustomer(String Cin) {
		// TODO Auto-generated method stub
		return null;
	}

}
