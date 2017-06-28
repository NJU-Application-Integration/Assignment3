package com.nju.bankSystem.corba;

import Bank.BankService;
import Bank.BankServiceHelper;
import Bank.BankServicePOA;
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

import javax.annotation.PostConstruct;

/**
 * Created by sbin on 2017/6/28.
 */
@Component
public class BankCorba {

    @PostConstruct
    public void init() throws
            InvalidName, AdapterInactive,
            org.omg.CosNaming.NamingContextPackage.InvalidName,
            ServantNotActive, WrongPolicy, NotFound, CannotProceed {
        String args[] = new String[2];
        args[0] = "-ORBInitialPort";
        args[1] = "2809";

        ORB orb = ORB.init(args,null);

        POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        poa.the_POAManager().activate();

        BankCorbaService bankCorbaService = new BankCorbaService();
        org.omg.CORBA.Object ref = poa.servant_to_reference(bankCorbaService);
        BankService href = BankServiceHelper.narrow(ref);

        org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objref);

        String name = "Bank";
        NameComponent[] nc = ncRef.to_name(name);
        ncRef.rebind(nc, href);

        new Thread(()->{
            System.out.println("CorbaServer ready and waiting......");
            orb.run();
        });

    }

}
