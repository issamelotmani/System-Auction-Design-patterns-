public class CreditCardProcessor implements PaymentProcessor {
    public void processPayment(User u ,double amount){
        System.out.println("Paying Using credit card the amount : " + amount + " From user " + u.getUsername());
    }
}
