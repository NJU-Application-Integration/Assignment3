package Bank;


/**
* Bank/BankServiceOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从./bank.idl
* 2017年6月28日 星期三 下午04时16分13秒 CST
*/

public interface BankServiceOperations 
{
  Bank.record[] listHistory (String account, String password);
  String[] listInListString (String account, String password);
} // interface BankServiceOperations
