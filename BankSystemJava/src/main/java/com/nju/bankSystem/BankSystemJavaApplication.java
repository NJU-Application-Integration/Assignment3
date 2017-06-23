package com.nju.bankSystem;

import com.nju.bankSystem.bankJNI.BankJNI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankSystemJavaApplication {

	public static void main(String[] args) {
//		BankJNI.transfer("buyer", "123", "seller", 100);
//		BankJNI.listHistory("buyer", "123");
		SpringApplication.run(BankSystemJavaApplication.class, args);
	}

}
