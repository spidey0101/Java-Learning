import java.util.*;  

class paytmPayment implements paymentType {

    @Override
    public void setPayment(String number, String pin) {
        System.out.println("Payment Successful through Paytm, account number: "+number);
    }
 }


