package lab6;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(endpointInterface = "lab6.Calculator")
public class CalculatorService implements Calculator {

    @Override
    @WebMethod
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    @WebMethod
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    @WebMethod
    public int multiply(int a, int b) {
        return a * b;
    }
}
