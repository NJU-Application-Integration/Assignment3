package Bank;


/**
* Bank/BankServiceOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��./bank.idl
* 2017��6��28�� ������ ����01ʱ05��25�� CST
*/

public interface BankServiceOperations 
{
  Bank.record[] listHistory (String account, String password);
} // interface BankServiceOperations
