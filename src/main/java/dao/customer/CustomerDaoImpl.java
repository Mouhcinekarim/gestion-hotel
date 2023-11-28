package dao.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Customer;
import dao.user.ConnectDatabase;

public class CustomerDaoImpl implements CustomerDao{

	private ConnectDatabase connectDatabase;
	private Connection connexion = null;
    private PreparedStatement preparedStatement = null;
	public CustomerDaoImpl(ConnectDatabase connectDatabase ){
		this.connectDatabase = connectDatabase;
	}
	@Override
	public void ajouter(Customer customer) {
		// TODO Auto-generated method stub
		
        
        try {
            connexion = connectDatabase.getConnection();
            System.out.println(if_exist(customer.getCin()));
            if(!if_exist(customer.getCin())) {
            preparedStatement = connexion.prepareStatement("INSERT INTO customer(Phone, Cin,CardNumber) VALUES(?, ?, ?);");
            preparedStatement.setInt(1, customer.getPhone());
            preparedStatement.setString(2, customer.getCin());
            preparedStatement.setInt(3, customer.getCardNumber());
            }
            else {
            	preparedStatement = connexion.prepareStatement("update customer set Phone=?,CardNumber=? where Cin=? ;");
            	preparedStatement.setInt(1, customer.getPhone());
            	 preparedStatement.setInt(2, customer.getCardNumber());
            	 preparedStatement.setString(3, customer.getCin());
            	 System.out.println("2 c");
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(if_exist(customer.getCin()));
        }
        
        try {
			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private boolean if_exist(String cin) {
		System.out.println(cin);
		try {
			System.out.print("if 2");
			connexion = connectDatabase.getConnection();
			System.out.print("3");
			preparedStatement = connexion.prepareStatement("SELECT * FROM customer where Cin = ?;");
			System.out.print("4");
			preparedStatement.setString(1,cin);
			System.out.print("5");
				ResultSet resultat = preparedStatement.executeQuery();
				System.out.print("6");
				//System.out.println(cin);
				while(resultat.next()) {
					System.out.println("karim");
					
					return true;}
				System.out.println("7");
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}


