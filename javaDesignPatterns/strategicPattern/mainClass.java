import java.util.*;  

class mainClass {

    public static void main(String[] args) {
        mainClass clazz = new mainClass();
        clazz.handlePayment();
        
    }

    private void handlePayment() {
       // Scanner sc=new Scanner(System.in);  
       // String paymentType = sc.nextLine();
        System.out.println("You chose: Paypal");
        paymentHandler paymentHandler=new paymentHandler(new paytmPayment());
        paymentHandler.payForMe("9877253751","7005");

        paymentHandler paymentHandler2=new paymentHandler(new paypalPayment());
        paymentHandler2.payForMe("9877253751","7005");

        paymentHandler paymentHandler3=new paymentHandler(new wisePayment());
        paymentHandler3.payForMe("9877253751","7005");

    }
}