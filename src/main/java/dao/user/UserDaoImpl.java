package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class UserDaoImpl implements UserDao{
	 Connection connexion = null;
     PreparedStatement preparedStatement = null;
	private ConnectDatabase connectDatabase;
	UserDaoImpl(ConnectDatabase connectDatabase){
		this.connectDatabase = connectDatabase;
	}
	public void ajouter(User user) {
		// TODO Auto-generated method stub
		
	        
	        try {
	            connexion = connectDatabase.getConnection();
	            
preparedStatement = connexion.prepareStatement("INSERT INTO user(UserName, Password,Email,DateSignUp) VALUES(?, ?, ?, ?);");
	            preparedStatement.setString(1, user.getUserName());
	            preparedStatement.setString(2, user.getPassword());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, user.getDateSignUp());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	public User connexion(String email, String password) {
		// TODO Auto-generated method stub
		User user=null;
		String requette;
	
		try {
			connexion = connectDatabase.getConnection();
			preparedStatement=connexion.prepareStatement("select * from user where Email=? and Password=?;");
preparedStatement.setString(1,email);
			 preparedStatement.setString(2,password);
			ResultSet re= preparedStatement.executeQuery();
			if(re.next()) {
				user= new User();
				re.getString("UserName");
				user.setUserName(re.getString("UserName"));
				
				user.setEmail(re.getString("Email"));
				return user;
			}
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
