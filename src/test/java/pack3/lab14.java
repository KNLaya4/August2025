package pack3;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class lab14 {
	 public static void main(String[] args) {
	        ZonedDateTime timeInIndia = ZonedDateTime.now(ZoneId.of( "Asia/Kolkata" ));
	        System.out.println("Current time in India: " + timeInIndia);
	    }
}
