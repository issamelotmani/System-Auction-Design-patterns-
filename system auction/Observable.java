import java.util.ArrayList;

public class Observable {

    ArrayList<User> observers;

    Observable() {
        observers = new ArrayList<User>();
    }

    public void addObserver(User u){
        observers.add(u);
    }

    public void removeObserver(User u) {
        observers.remove(u);
    }


    public void notifyObservers(String notification_type,Bid bid){
        for (User u : observers){
            u.update(bid, notification_type);
        }
    }
    
}
