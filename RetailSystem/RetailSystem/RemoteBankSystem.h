#pragma once
#include "RetailSystem.h"
#include "bank.hh"

class RemoteBankSystem :
	public BankSystem
{
public:
	RemoteBankSystem(Bank::BankService_ptr bankPtr):
	  bankPtr(bankPtr){};

	virtual list<record> listHistory(string account, string password);

	~RemoteBankSystem(void);

private:
	Bank::BankService_ptr bankPtr;
};

