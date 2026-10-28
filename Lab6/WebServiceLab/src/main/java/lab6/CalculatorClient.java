package lab6;

import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;

public class CalculatorClient {

    public static void main(String[] args) throws Exception {

        URL wsdlURL = new URL(
            "http://localhost:8080/calculator?wsdl"
        );

        QName serviceName = new QName(
            "http://lab6/",
            "CalculatorServiceService"
        );

        Service service = Service.create(wsdlURL, serviceName);

        Calculator calculator =
            service.getPort(Calculator.class);

        int a = 20;
        int b = 10;

        System.out.println("Connected to Calculator Web Service\n");
        System.out.println(a + " + " + b + " = " + calculator.add(a, b));
        System.out.println(a + " - " + b + " = " + calculator.subtract(a, b));
        System.out.println(a + " * " + b + " = " + calculator.multiply(a, b));
    }
}