import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {

    public static class Product {
        private int productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(int productId, String productName, int quantity, double price) {
            setProductId(productId);
            setProductName(productName);
            setQuantity(quantity);
            setPrice(price);
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productId='" + productId + '\'' +
                    ", productName='" + productName + '\'' +
                    ", quantity=" + quantity +
                    ", price=" + price +
                    '}';
        }
    }

    static Scanner sc=new Scanner(System.in);
    InventoryManagementSystem inventory = new InventoryManagementSystem();
    private static Map<Integer, Product> productMap = new HashMap<>();

    public static void addProduct(int id) {
        System.out.print("Enter name: "); String name=sc.next();
        System.out.print("Enter quantity: "); int qt=sc.nextInt();
        System.out.print("Enter price: "); double price=sc.nextDouble();
        Product product=new Product(id++, name, qt, price);
        productMap.put(product.getProductId(), product);
    }

    public static void updateProduct(int productId) {
        if (productMap.containsKey(productId)) {
            System.out.print("Enter new name: "); String name_new=sc.next();
            System.out.print("Enter new quantity: "); int qt_new=sc.nextInt();
            System.out.print("Enter new price: "); double price_new=sc.nextDouble();
            Product updatedProduct=new Product(productId, name_new, qt_new, price_new);
            productMap.put(productId, updatedProduct);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public static void deleteProduct(int productId) {
        if (productMap.containsKey(productId)) {
            productMap.remove(productId);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public static void displayProducts() {
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        int id=1;
        while(true){
            System.out.print("1. Add product\n2. Update product\n3. Delete product\n -1 to exit\n Your choice: ");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Product id: "+id);
                    addProduct(id++);
                    displayProducts();
                    break;
                case 2:
                    System.out.print("Enter id: "); int enter_id=sc.nextInt();
                    updateProduct(enter_id);
                    displayProducts();
                    break;
                case 3:
                    System.out.print("Enter id: "); int del_id=sc.nextInt();
                    deleteProduct(del_id);
                    displayProducts();
                    break;
                case -1:
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
            if(choice==-1){break;}
        }
        sc.close();
    }
}
