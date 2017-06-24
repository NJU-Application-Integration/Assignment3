#ifndef _RETAILSYSTEM_H_
#define _RETAILSYSTEM_H_

#include <list>
#include <string>

using namespace std;

#ifndef _RECORD_STRUCT
#define _RECORD_STRUCT
struct record {
	string source;
	string target;
	double amount;
};
#endif

class BankSystem {
public:
	virtual list<record> listHistory(string account, string password) = 0;
};

class GroupPurchaseManagementSystem {
public:
	virtual bool publishGroupPurchaseItem(string sellerSecretKey, string productName, string introduction, double price, int limit) = 0;
	virtual bool confirmPurchase(string sellerSecretKey, string confirm) = 0;
};

extern int launchRetailSystem(GroupPurchaseManagementSystem* gpms, BankSystem* bank);

#endif