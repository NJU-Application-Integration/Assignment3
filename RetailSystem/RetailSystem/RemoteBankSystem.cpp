#include "RemoteBankSystem.h"
#include <iostream>
#include "rapidjson/document.h"

list<record> RemoteBankSystem::listHistory(string account, string password){

	/*Bank::recordList& rList = * bankPtr->listHistory(account.c_str(),password.c_str());
	list<record> result;
	
	for(int i=0 ; i<rList.length() ;i++ ){
		record r;
		double a = rList[i]->amount();
		const char* s = rList[i]->source();
		const char* t = rList[i]->target();
		r.amount = a;
		r.source = s;
		r.target = t;
		result.push_back(r);
	}
	return result;*/
	

	list<record> result;
	Bank::recordListString& listString = *bankPtr->listInListString(account.c_str(),password.c_str());
	for(int i=0;i<listString.length();i++){
		rapidjson::Document d;
		d.Parse((const char *)listString[i]);

		record r;
		r.source = d["source"].GetString();
		r.target = d["target"].GetString();
		r.amount = d["amount"].GetDouble();
		result.push_back(r);
	}
	return result;
}

RemoteBankSystem::~RemoteBankSystem(void)
{
}
