package CalculatorApp;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Calculator".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 23-Oct-2026, 4:58:29 am
 */

public class CalculatorPOATie
	extends CalculatorPOA
{
	private CalculatorOperations _delegate;

	private POA _poa;
	public CalculatorPOATie(CalculatorOperations delegate)
	{
		_delegate = delegate;
	}
	public CalculatorPOATie(CalculatorOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public CalculatorApp.Calculator _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		CalculatorApp.Calculator __r = CalculatorApp.CalculatorHelper.narrow(__o);
		return __r;
	}
	public CalculatorApp.Calculator _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		CalculatorApp.Calculator __r = CalculatorApp.CalculatorHelper.narrow(__o);
		return __r;
	}
	public CalculatorOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(CalculatorOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public int multiply(int a, int b)
	{
		return _delegate.multiply(a,b);
	}

	public int subtract(int a, int b)
	{
		return _delegate.subtract(a,b);
	}

	public int add(int a, int b)
	{
		return _delegate.add(a,b);
	}

	public double divide(int a, int b)
	{
		return _delegate.divide(a,b);
	}

}
