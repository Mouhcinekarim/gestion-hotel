package beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.lang.model.element.TypeElement;

public class ZTest {
		public static void main(String[] args) {
			
			 RoomGroup gr = new RoomGroup();
			gr.setCinGuest1("v25558");
			
			User usr = new User();
			
			System.out.println(usr.getDateSignUp());
		}
}
