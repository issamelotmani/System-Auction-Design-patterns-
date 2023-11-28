public class PaymentOptionFactory {


    public static PaymentProxy createOption(String option) {
        PaymentProcessor p;
        switch (option){
            case "paypal":
                p = new PaypalProcessor();
                break;
            case "creditcard":
                p = new CreditCardProcessor();
                break;
            case "bank":
                p = new BankTransferProcessor();
                break;
            default:
                p = new CreditCardProcessor();
        }
        return new PaymentProxy(p);
    }
}
