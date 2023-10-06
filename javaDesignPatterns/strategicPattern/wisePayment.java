import java.util.*;  

class wisePayment implements paymentType {

    @Override
    public void setPayment(String number, String pin) {
        System.out.println("Payment Successful through Wise, account number: "+number);
    }
 }


