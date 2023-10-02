public class Calculator {
    public double calculate(double num1, double num2, Operation operation) {
        return operation.execute(num1, num2);
    }
}
