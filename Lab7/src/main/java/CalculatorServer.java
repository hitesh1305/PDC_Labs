
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;

public class CalculatorServer {

    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            POA rootPOA = POAHelper.narrow(
                orb.resolve_initial_references("RootPOA")
            );
            rootPOA.the_POAManager().activate();

            CalculatorImpl calculatorImpl = new CalculatorImpl();

            org.omg.CORBA.Object reference =
                rootPOA.servant_to_reference(calculatorImpl);

            Calculator calculator =
                CalculatorHelper.narrow(reference);

            org.omg.CORBA.Object namingReference =
                orb.resolve_initial_references("NameService");

            NamingContextExt namingContext =
                NamingContextExtHelper.narrow(namingReference);

            NameComponent[] path =
                namingContext.to_name("Calculator");

            namingContext.rebind(path, calculator);

            System.out.println("CORBA Calculator Server is ready...");
            orb.run();

        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
