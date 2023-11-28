package beans;

public class Room {
		
		private int IdROOM;
		private boolean IsReserved;
		private String TypeRoom;
		
		
		public int getIdROOM() {
			return IdROOM;
		}
		public void setIdROOM(int idROOM) {
			IdROOM = idROOM;
		}
		public String getTypeRoom() {
			return TypeRoom;
		}
		public void setTypeRoom(String typeRoom) {
			TypeRoom = typeRoom;
		}
		public boolean isIsReserved() {
			return IsReserved;
		}
		public void setIsReserved(boolean isReserved) {
			IsReserved = isReserved;
		}
}
