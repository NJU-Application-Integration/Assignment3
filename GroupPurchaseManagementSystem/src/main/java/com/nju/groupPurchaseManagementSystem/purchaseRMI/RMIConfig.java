package com.nju.groupPurchaseManagementSystem.purchaseRMI;

import assignment3.GroupPurchaseManagementSystem;
import com.nju.groupPurchaseManagementSystem.ConfigInfos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import javax.annotation.Resource;

/**
 * Created by Srf on 2017/6/24
 */

@Configuration
public class RMIConfig {

    @Resource
    private GroupPurchaseManagementSystemImpl system;

    @Bean
    public RmiServiceExporter initRmiServiceExporter() {
        RmiServiceExporter exporter=new RmiServiceExporter();
        exporter.setServiceInterface(GroupPurchaseManagementSystem.class);
        exporter.setServiceName(ConfigInfos.rmiServiceName);
        exporter.setService(system);
        exporter.setRegistryPort(ConfigInfos.rmiPort);
        System.out.println("rmi start");
        return exporter;
    }

}
