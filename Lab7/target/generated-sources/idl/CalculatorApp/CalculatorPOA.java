package CalculatorApp;


/**
 * Generated from IDL interface "Calculator".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 23-Oct-2026, 4:58:29 am
 */

public abstract class CalculatorPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, CalculatorApp.CalculatorOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "multiply", Integer.valueOf(0));
		m_opsHash.put ( "subtract", Integer.valueOf(1));
		m_opsHash.put ( "add", Integer.valueOf(2));
		m_opsHash.put ( "divide", Integer.valueOf(3));
	}
	private String[] ids = {"IDL:CalculatorApp/Calculator:1.0"};
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
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // multiply
			{
				int _arg0=_input.read_long();
				int _arg1=_input.read_long();
				_out = handler.createReply();
				_out.write_long(multiply(_arg0,_arg1));
				break;
			}
			case 1: // subtract
			{
				int _arg0=_input.read_long();
				int _arg1=_input.read_long();
				_out = handler.createReply();
				_out.write_long(subtract(_arg0,_arg1));
				break;
			}
			case 2: // add
			{
				int _arg0=_input.read_long();
				int _arg1=_input.read_long();
				_out = handler.createReply();
				_out.write_long(add(_arg0,_arg1));
				break;
			}
			case 3: // divide
			{
				int _arg0=_input.read_long();
				int _arg1=_input.read_long();
				_out = handler.createReply();
				_out.write_double(divide(_arg0,_arg1));
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
