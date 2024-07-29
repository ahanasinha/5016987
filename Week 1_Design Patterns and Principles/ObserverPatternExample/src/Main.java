public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        MobileApp m=new MobileApp();
        WebApp w=new WebApp();

        stockMarket.register(m);
        stockMarket.register(w);

        stockMarket.setStockPrice(100.0);
        stockMarket.setStockPrice(101.5);

        stockMarket.deregister(m);
        stockMarket.setStockPrice(102.0);
    }
}