public class Bid {

    User user;
    Item item;
    double amount;

    Bid(User user, Item item, double amount) {
        this.user = user;
        this.item = item;
        this.amount = amount;
    }


    public User getBidder() {
        return this.getUser();
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    
    
}