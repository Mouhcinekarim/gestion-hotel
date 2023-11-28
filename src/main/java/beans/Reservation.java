package beans;



public class Reservation {
	    
		private int IdReservation;
		private String DateStart;
		private String DateEnd;
		private int cin;
		
		private int TotalRooms;
		


		public int getCin() {
			return cin;
		}
		public void setCin(int cin) {
			this.cin = cin;
		}


		private int NumberOfMembers;
		private String DateReservation;
		private String prixtotal;
		public String getDateStart() {
			return DateStart;
		}
		public void setDateStart(String dateStart) {
			DateStart = dateStart;
		}
		public String getDateEnd() {
			return DateEnd;
		}
		public void setDateEnd(String dateEnd) {
			DateEnd = dateEnd;
		}
		public int getIdReservation() {
			return IdReservation;
		}
		public void setIdReservation(int idReservation) {
			IdReservation = idReservation;
		}

		
		public String getPrixtotal() {
			return prixtotal;
		}
		public void setPrixtotal(String prixtotal) {
			this.prixtotal = prixtotal;
		}
		public void setDateReservation(String dateReservation) {
			DateReservation = dateReservation;
		}
		
		public int getTotalRooms() {
			return TotalRooms;
		}
		public void setTotalRooms(int totalRooms) {
			TotalRooms = totalRooms;
		}
		public int getNumberOfMembers() {
			return NumberOfMembers;
		}
		public void setNumberOfMembers(int numberOfMembers) {
			NumberOfMembers = numberOfMembers;
		}
		
		
		/**
		 * @return the dateReservation
		 */
		public String getDateReservation() {
			//DateReservation = java.time.LocalDate.now().toString();
			return DateReservation;
		}
}
