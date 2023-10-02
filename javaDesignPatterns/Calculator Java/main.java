public class Main {
    public static void main(String[] args) {
        // Create a calculator
        Calculator calculator = new Calculator();

        // Perform some operations
        double result1 = calculator.calculate(10, 5, new AdditionOperation());
        double result2 = calculator.calculate(20, 7, new SubtractionOperation());
        double result3 = calculator.calculate(8, 4, new MultiplicationOperation());
        double result4 = calculator.calculate(16, 2, new DivisionOperation());

        // Display results
        System.out.println("Addition Result: " + result1);
        System.out.println("Subtraction Result: " + result2);
        System.out.println("Multiplication Result: " + result3);
        System.out.println("Division Result: " + result4);
    }
}
