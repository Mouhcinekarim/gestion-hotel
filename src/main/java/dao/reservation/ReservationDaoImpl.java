package dao.reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Customer;
import beans.Reservation;
import beans.Room;

import dao.user.ConnectDatabase;

public class ReservationDaoImpl implements ReservationDao{
private ConnectDatabase connectDatabase;
static private int nb=0;
static private int ch=0;
Connection connexion = null;
PreparedStatement preparedStatement = null;
	public ReservationDaoImpl(ConnectDatabase connectDatabase ){
		this.connectDatabase = connectDatabase;
	}
	@Override
	public void ajouter(Reservation reservation) {
		// TODO Auto-generated method stub
		
		nb++;
      
        
        try {
            connexion = connectDatabase.getConnection();
            
preparedStatement = connexion.prepareStatement("INSERT INTO reservation(cin, DateReservation,	TotalPrice,TotalRooms,	NumberOfMembers	,DateStart,DateEnd) VALUES(?, ?, ?, ?, ?,?,?);");
            preparedStatement.setInt(1, reservation.getCin());
            preparedStatement.setString(2, reservation.getDateReservation());
            preparedStatement.setString(3, reservation.getPrixtotal());
            preparedStatement.setInt(4, reservation.getTotalRooms());
            preparedStatement.setInt(5, reservation.getNumberOfMembers());
         preparedStatement.setString(6, reservation.getDateStart());
          preparedStatement.setString(7, reservation.getDateEnd());

            preparedStatement.executeUpdate();
            nb++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ajouter(Room room) {
		
		
         
		 try {
			 connexion = connectDatabase.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO `room`(`typeChambre`, `isReserve`) VALUES (?,?)");
			 preparedStatement.setString(1,room.getTypeRoom());
			 preparedStatement.setBoolean(2,true);
			  preparedStatement.executeUpdate();
			 ch++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ajouterHistory() {
		// TODO Auto-generated method stub
		 try {
			connexion = connectDatabase.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO `roomhistory`(`IdReservation`, `idRoom`) VALUES (?,?)");
			preparedStatement.setInt(1, nb);
			preparedStatement.setInt(2, ch);
			  preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}







