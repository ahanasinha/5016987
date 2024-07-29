public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("example.jpg");
        System.out.println("loading initially");
        image.display();
        System.out.println("Already cached so not loaded again");
        image.display();
    }
}
