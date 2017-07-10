#include <iostream>
#include "RSCorba.h"
#include "RemoteBankSystem.h"
#include "RemoteGroupPurchaseManagementSystem.h"
#include "RetailSystem.h"
#include "bank.hh"

using namespace std;

void startSystem(RsInterface::RetailSystemService_ptr groupSystemPtr,Bank::BankService_ptr bankPtr){
	RemoteBankSystem bank(bankPtr);
	RemoteGroupPurchaseManagementSystem gpms(groupSystemPtr);

	launchRetailSystem(&gpms, &bank);
}

CORBA::Object_var resolveObject(CosNaming::NamingContext_var nc,const char* serviceName){
	CosNaming::Name name;
    name.length(1);
    name[0].id = CORBA::string_dup (serviceName);
    name[0].kind = CORBA::string_dup ("");
    return nc->resolve (name);
}

int main(int argc,char* argv[]){

	try{
        //Init orb
		const char* options[][2] = { { "InitRef", "NameService=corbaloc:iiop:localhost:2809/NameService" }, { 0, 0 }};
        CORBA::ORB_var orb = CORBA::ORB_init(argc,argv,"omniORB4",options);
        CORBA::Object_var nsobj = orb->resolve_initial_references ("NameService");
        CosNaming::NamingContext_var nc = CosNaming::NamingContext::_narrow (nsobj);
        if (CORBA::is_nil (nc)) {
            cerr << "oops, I cannot access the Naming Service!" << endl;
            exit (1);
        }
       
		CORBA::Object_var groupSysObj = resolveObject(nc,"GroupPurchase");
		RsInterface::RetailSystemService_ptr groupSystemPtr = 
			RsInterface::RetailSystemService::_narrow(groupSysObj);
		if(CORBA::is_nil(groupSystemPtr)) {
            cerr<<"GroupPurchase narrow err"<<endl;
            throw 0;
        }

		CORBA::Object_var bankObj = resolveObject(nc,"Bank");
		Bank::BankService_ptr bankPtr = Bank::BankService::_narrow(bankObj);
		if(CORBA::is_nil(bankPtr)) {
			cerr<<"Bank narrow err"<<endl;
			throw 0;
		}

		startSystem(groupSystemPtr,bankPtr);
    }catch(const CORBA::Exception& e){
		
        cerr<<"Uncaught CORBA exception "<<endl;
		cin.get();
        return 1;
    }

	cin.get();
    return 0;

}