package com.nju.groupPurchaseManagementSystem;

import com.nju.groupPurchaseManagementSystem.bankSystemMQ.TransferMessageSender;
import com.nju.groupPurchaseManagementSystem.purchaseRMI.GroupPurchaseManagementSystemFactory;
import com.nju.groupPurchaseManagementSystem.smsService.ShortMessageSender;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.rmi.RemoteException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupPurchaseManagementSystemApplicationTests {

	@Resource
	private TransferMessageSender sender;

	@Test
	public void testMQ() {
		sender.transfer("buyer", "123", "seller", 100);
	}

	@Test
	public void testSMS() throws RemoteException {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(ShortMessageSender.class);
		factoryBean.setAddress("http://192.168.1.106:8080/SMSender");
		ShortMessageSender shortMessageSender = (ShortMessageSender)factoryBean.create();

		shortMessageSender.sendMessage("1234567890",
				"Your confirm code is: ");
	}

}
