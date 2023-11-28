public class PaypalProcessor implements PaymentProcessor {
    public void processPayment(User u ,double amount){

        System.out.println("Paying Using paypal the amount : " + amount + " From user " + u.getUsername());
    }
}
