public class User implements Observer {

    private String username;
    PaymentProxy p;

    public User(String username,String option) {
        this.username = username;
        this.p = PaymentOptionFactory.createOption(option);
    }

    public String getUsername() {
        return username;
    }


    public void update(Bid bid,String notif_type)  {
        System.out.println("######## Notification for " + this.getUsername() + " ##############" );
        switch (notif_type) {
            case "bid":
                System.out.println("New Bid registered for item " + bid.getItem().getName() + " for amount " + bid.getAmount());
                break;
            case "winner":
                System.out.println("Winner of item " + bid.getItem().getName() + " Is " + bid.getUser().getUsername());
                break;
            case "newitem":
                System.out.println("New Item Added to the auction system " + bid.getItem().getName());
                break;
        
            default:
                break;
        }
        System.out.println("##################################################################");

    }


    public void pay(double amount) {
        this.p.processPayment(this, amount);
    }

    
}
