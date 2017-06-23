package com.nju.bankSystem;

import com.nju.bankSystem.rabbitmq.MockSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankSystemJavaApplicationTests {

	@Resource
	private MockSender sender;

	@Test
	public void contextLoads() {
		sender.send();
	}

}
