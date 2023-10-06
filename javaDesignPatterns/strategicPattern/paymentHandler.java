
class paymentHandler {
    private paymentType type;
    public paymentHandler(paymentType type) {
        this.type=type;
    }

    public void payForMe(String number, String pin){
        type.setPayment(number,pin);
    }
}
