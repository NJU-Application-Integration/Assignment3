#include <iostream>
#include "RSCorba.h"

using namespace std;

int main(int argc,char* argv[]){

	try{
        //Init orb
        CORBA::ORB_var orb = CORBA::ORB_init(argc,argv);
        CORBA::Object_var nsobj = orb->resolve_initial_references ("NameService");
        CosNaming::NamingContext_var nc = CosNaming::NamingContext::_narrow (nsobj);
        if (CORBA::is_nil (nc)) {
            cerr << "oops, I cannot access the Naming Service!" << endl;
            exit (1);
        }
        CosNaming::Name name;
        name.length(1);
        name[0].id = CORBA::string_dup ("Hello");
        name[0].kind = CORBA::string_dup (""); 
        /*
        * try to find that node in the Naming Service tree
        */
        CORBA::Object_var obj;
        cout << "Looking up HelloWorld " << flush;
        obj = nc->resolve (name);
 
		RsInterface::RetailSystemService_var var = RsInterface::RetailSystemService::_narrow(obj);
        if(CORBA::is_nil(var)) {
            cerr<<"Narrow err"<<endl;
            throw 0;
        }
    }catch(const CORBA::Exception&){
        cerr<<"Uncaught CORBA exception "<<endl;
        return 1;
    }
    return 0;

}