public class Item extends Observable {

    private String name;
    private String description;
    private Bid highestBid;
    private User owner;
    private boolean isActive;

    public Item(String name, String description, User owner) {
        this.name = name;
        this.description = description;
        this.isActive = true;
        this.owner = owner;
    }

    public void startAuction() {
        System.out.println("Auction started for item: " + name);
    }

    public boolean addBid(Bid bid) {
        if (this.isActive) {
            if (highestBid == null || bid.getAmount() > highestBid.getAmount()) {
                highestBid = bid;
                this.notifyObservers("bid", bid);
                return true;
            } else {
                System.out.println("Amount not enough");
            }
        } else {
            System.out.println("Auction ended");
        }
        return false;

    }

    public boolean endAuction(User owner) {
        if (this.owner == owner) {
            this.isActive = false;
            this.notifyObservers("winner", highestBid);
            this.getHighestBidder().pay(getHighestBidAmount());
            this.owner = this.highestBid.getUser();
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public double getHighestBidAmount() {
        return highestBid.getAmount();
    }

    public User getHighestBidder() {
        return highestBid.getUser();
    }

    public User getOwner() {
        return owner;
    }

    public boolean isActive() {
        return isActive;
    }

}
