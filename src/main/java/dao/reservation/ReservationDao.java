package dao.reservation;


import beans.Reservation;
import beans.Room;


public interface ReservationDao {
		void ajouter(Reservation customer);
		void ajouter(Room customer);
		void ajouterHistory();
}