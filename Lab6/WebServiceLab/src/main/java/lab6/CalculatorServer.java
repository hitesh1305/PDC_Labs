package lab6;

import jakarta.xml.ws.Endpoint;

public class CalculatorServer {

    public static void main(String[] args) {

        String url = "http://localhost:8080/calculator";

        Endpoint.publish(url, new CalculatorService());

        System.out.println("Calculator Web Service Started...");
        System.out.println("Service URL: " + url);
        System.out.println("WSDL URL: " + url + "?wsdl");
    }
}
