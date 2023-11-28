public class BankTransferProcessor implements PaymentProcessor {
    public void processPayment(User u ,double amount){
        System.out.println("Paying Using bank transfer the amount : " + amount + " From user " + u.getUsername());
    }
}
