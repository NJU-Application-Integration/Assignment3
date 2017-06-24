package com.nju.groupPurchaseManagementSystem.retailCorba;

import com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService;
import com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemServiceHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * Created by Srf on 2017/6/24
 */

@Component
public class CorbaServer {

    public CorbaServer() throws InvalidName, AdapterInactive, ServantNotActive, WrongPolicy, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {

        String args[] = new String[2];
        args[0] = "-ORBInitialPort";
        args[1] = "1050";
        Properties props = new Properties();
        props.put("org.omg.CORBA.ORBInitialPort", "1050");
        props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        ORB orb = ORB.init(args, props);

        POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        poa.the_POAManager().activate();

        RetailSystemServiceImpl retailSystem = new RetailSystemServiceImpl();
        org.omg.CORBA.Object ref = poa.servant_to_reference(retailSystem);
        RetailSystemService href = RetailSystemServiceHelper.narrow(ref);

        org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objref);

        String name = "Hello";
        NameComponent[] nc = ncRef.to_name(name);
        ncRef.rebind(nc, href);
        System.out.println("CorbaServer ready and waiting......");

        orb.run();

    }

}
