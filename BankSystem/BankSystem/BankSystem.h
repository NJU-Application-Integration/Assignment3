// header file for the bansk system.
#include <string>
#include <iostream>
#include <list>
#ifndef _BANKSYSTEM_H_
#define _BANKSYSTEM_H_

using namespace std;

#ifndef _RECORD_STRUCT
#define _RECORD_STRUCT
struct record {
	string source;
	string target;
	double amount;
};
#endif

extern bool transfer(string account, string password, string target, double amount);
extern list<record> listHistory(string account, string password);

#endif