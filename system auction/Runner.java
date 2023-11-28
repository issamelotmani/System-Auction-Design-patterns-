public class Runner {
    public static void main(String[] args) {
        // Auction System
        AuctionSystem sys = AuctionSystem.getInstance();
        // Users
        User u1 = new User("Ahmed", "paypal");
        User u2 = new User("Issam", "creditcard");
        User u3 = new User("Fadel", "bank");
        User u4 = new User("Redouane", "creditcard");
        sys.addObserver(u1);
        sys.addObserver(u2);
        sys.addObserver(u3);
        sys.addObserver(u4);
        // Items
        Item item1 = ItemFactory.createItem("Test Item 1", "Simple description", u1);
        // subscribe to item (interested)
        item1.addObserver(u1);
        item1.addObserver(u2);
        item1.addObserver(u3);
        item1.addObserver(u4);
        // Interactions
        // registering item in the auction system
        sys.addItem(item1);

        // bidding process
        sys.placeBid(u2, item1, 50);        
        sys.placeBid(u3, item1, 100);
        sys.placeBid(u2, item1, 150);        

        // should fail 
        sys.placeBid(u4, item1, 80);

        // ending auction
        System.out.println("The old owner is : " + item1.getOwner().getUsername());
        sys.endAuction(item1, u1);
        System.out.println("The new owner is : " + item1.getOwner().getUsername());

    }
}






