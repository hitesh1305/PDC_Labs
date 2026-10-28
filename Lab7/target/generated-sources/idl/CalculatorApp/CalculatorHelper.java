package CalculatorApp;


/**
 * Generated from IDL interface "Calculator".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 23-Oct-2026, 4:58:29 am
 */

public abstract class CalculatorHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(CalculatorHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:CalculatorApp/Calculator:1.0", "Calculator");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final CalculatorApp.Calculator s)
	{
			any.insert_Object(s);
	}
	public static CalculatorApp.Calculator extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:CalculatorApp/Calculator:1.0";
	}
	public static Calculator read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(CalculatorApp._CalculatorStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final CalculatorApp.Calculator s)
	{
		_out.write_Object(s);
	}
	public static CalculatorApp.Calculator narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof CalculatorApp.Calculator)
		{
			return (CalculatorApp.Calculator)obj;
		}
		else if (obj._is_a("IDL:CalculatorApp/Calculator:1.0"))
		{
			CalculatorApp._CalculatorStub stub;
			stub = new CalculatorApp._CalculatorStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static CalculatorApp.Calculator unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof CalculatorApp.Calculator)
		{
			return (CalculatorApp.Calculator)obj;
		}
		else
		{
			CalculatorApp._CalculatorStub stub;
			stub = new CalculatorApp._CalculatorStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
