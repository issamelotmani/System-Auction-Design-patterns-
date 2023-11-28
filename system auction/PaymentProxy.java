

class PaymentProxy {
    private PaymentProcessor realPaymentProcessor;

    public PaymentProxy(PaymentProcessor p) {
        this.realPaymentProcessor = p;
    }


    public void processPayment(User bidder, double amount) {
        realPaymentProcessor.processPayment(bidder, amount);
    }
}