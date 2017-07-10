#include "RemoteGroupPurchaseManagementSystem.h"
#include <iostream>



RemoteGroupPurchaseManagementSystem::~RemoteGroupPurchaseManagementSystem(void)
{
}

bool RemoteGroupPurchaseManagementSystem::publishGroupPurchaseItem(string sellerSecretKey, string productName, string introduction, double price, int limit){
	groupSystemPtr->publishGroupPurchaseItem(sellerSecretKey.c_str(),productName.c_str(),introduction.c_str(),price,limit);
	return true;
}

bool RemoteGroupPurchaseManagementSystem::confirmPurchase(string sellerSecretKey, string confirm){
	cout<<sellerSecretKey<<endl;
	cout<<confirm<<endl;
	groupSystemPtr->confirmPurchase(sellerSecretKey.c_str(),confirm.c_str());
	return true;
}