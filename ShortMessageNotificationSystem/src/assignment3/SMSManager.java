package assignment3;

import javax.xml.ws.Endpoint;

public class SMSManager {
	   public static void main(String[] args){
		  
         ShortMessageSender sms =  ShortMessageSenderFactory.createShortMessageSender();
	     Endpoint.publish("http://localhost:8080/SMSender",sms);
	     System.out.println("server ready...");

	    }
	   
}