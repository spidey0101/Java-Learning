import java.util.*;  

class paypalPayment implements paymentType {

    @Override
    public void setPayment(String number, String pin) {
        System.out.println("Payment Successful through Paypal, account number: "+number);
    }
 }


