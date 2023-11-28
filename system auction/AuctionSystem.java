import java.util.*;

public class AuctionSystem extends Observable {

    private static AuctionSystem instance;
    private List<Item> items;
    private Map<Item, List<Bid>> bids;

    private AuctionSystem() {
        this.items = new ArrayList<>();
        this.bids = new HashMap<>();
    }

    public static AuctionSystem getInstance() {
        if (instance == null) {
            synchronized (AuctionSystem.class) {
                if (instance == null) {
                    instance = new AuctionSystem();
                }
            }
        }
        return instance;
    }

    public void addItem(Item item) {
        this.items.add(item);
        this.bids.put(item, new ArrayList<>());
        notifyObservers("newitem", new Bid(null,item,0));
    }

    public void placeBid(User u , Item item , double amount) {
        if (items.contains(item)){
            Bid bid = new Bid(u, item, amount);
            boolean res = item.addBid(bid);
            if (res){
                List<Bid> itemBids = bids.getOrDefault(item, new ArrayList<>());
                itemBids.add(bid);
                bids.put(item, itemBids);
            }else{
                System.out.println("Failed Adding bid");
            }
        }else{
            System.out.println("Item not present in the system");
        }
        
        
    }

    public void endAuction(Item i, User u) {
        
        boolean r = i.endAuction(u);
        if (r) {
            items.remove(i);
            bids.remove(i);
        }else{
            System.out.println("Not owner");
        }
    }




    public List<Item> getItems() {
        return items;
    }
}
