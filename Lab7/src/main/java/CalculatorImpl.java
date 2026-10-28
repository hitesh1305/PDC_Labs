import CalculatorApp.CalculatorPOA;

public class CalculatorImpl extends CalculatorPOA {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return 0.0;
        }
        return (double) a / b;
    }
}
