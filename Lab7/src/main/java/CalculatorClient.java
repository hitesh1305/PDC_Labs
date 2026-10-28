
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;

public class CalculatorClient {

    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object namingReference =
                orb.resolve_initial_references("NameService");

            NamingContextExt namingContext =
                NamingContextExtHelper.narrow(namingReference);

            Calculator calculator =
                CalculatorHelper.narrow(
                    namingContext.resolve_str("Calculator")
                );

            int a = 20;
            int b = 10;

            System.out.println("Connected to CORBA Calculator Server");
            System.out.println(a + " + " + b + " = " + calculator.add(a, b));
            System.out.println(a + " - " + b + " = " + calculator.subtract(a, b));
            System.out.println(a + " * " + b + " = " + calculator.multiply(a, b));
            System.out.println(a + " / " + b + " = " + calculator.divide(a, b));

            orb.destroy();

        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
