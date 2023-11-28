package beans;

import java.util.Date;

public class User {
		 
		private String UserName;
		private String Password;
		private String Email;
		private String DateSignUp;
		
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		/**
		 * @return the dateSignUp
		 */
		public String getDateSignUp() {
			DateSignUp = java.time.LocalDate.now().toString();
			return DateSignUp;
		}
		/**
		 * @param dateSignUp the dateSignUp to set
		 */
//		public void setDateSignUp(String dateSignUp) {
//			DateSignUp = dateSignUp;
//		}
//		
				
}
