package panier.crud;

import java.util.List;

import beans.Customer;
import beans.Reservation;

public interface Crud {
	
		void ajouter(Reservation reservation);
		
		//Customer modifier(Customer customer);
		 void modifier(int IdCustomer,String date1,String date2);
		void supprimer(int id);
		List<Reservation> chercherReservation(int idCustomer);
		List<Customer> chercherCustomer(String Cin);
}
