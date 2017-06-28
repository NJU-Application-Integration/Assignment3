package Bank;

/**
* Bank/BankServiceHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��./bank.idl
* 2017��6��28�� ������ ����01ʱ05��25�� CST
*/

public final class BankServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public Bank.BankService value = null;

  public BankServiceHolder ()
  {
  }

  public BankServiceHolder (Bank.BankService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Bank.BankServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Bank.BankServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Bank.BankServiceHelper.type ();
  }

}
