#pragma once
#include "RetailSystem.h"
#include "retailSystem.hh"

class RemoteGroupPurchaseManagementSystem : 
	public GroupPurchaseManagementSystem {

public:
	RemoteGroupPurchaseManagementSystem(RsInterface::RetailSystemService_ptr groupSystemPtr)
		:groupSystemPtr(groupSystemPtr){};
	virtual ~RemoteGroupPurchaseManagementSystem(void);

	virtual bool publishGroupPurchaseItem(string sellerSecretKey, string productName, string introduction, double price, int limit);
	virtual bool confirmPurchase(string sellerSecretKey, string confirm);

private:
	RsInterface::RetailSystemService_ptr groupSystemPtr;

};

