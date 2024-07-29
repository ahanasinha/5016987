import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    @Override
    public void register(Observer observer) {
        System.out.println("Registering observer " + observer);
        observers.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        System.out.println("Deregistering observer " + observer);
        observers.remove(observer);
    }

    @Override
    public void Notify() {
        System.out.println("Notifying observers");
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        Notify();
    }
}
