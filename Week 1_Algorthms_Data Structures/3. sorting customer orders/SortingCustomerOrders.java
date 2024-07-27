import java.util.Scanner;

public class SortingCustomerOrders {

    public static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public int getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId +
                    ", customerName='" + customerName + '\'' +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }

    private static Scanner sc = new Scanner(System.in);
    private static Order[] orders = new Order[100];
    private static int orderCount = 0;

    public static void addOrder() {
        System.out.print("Enter order ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = sc.next();
        System.out.print("Enter total price: ");
        double totalPrice = sc.nextDouble();
        orders[orderCount++] = new Order(id, customerName, totalPrice);
    }

    public static void bubbleSort() {
        for (int i = 0; i < orderCount - 1; i++) {
            for (int j = 0; j < orderCount - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
        System.out.println("Orders sorted using Bubble Sort.");
    }

    public static void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    public static int partition(int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void displayOrders() {
        for (int i = 0; i < orderCount; i++) {
            System.out.println(orders[i]);
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.print("1. Add Order\n2. Sort Orders using Bubble Sort\n3. Sort Orders using Quick Sort\n4. Display Orders\n-1 to Exit\nYour choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    bubbleSort();
                    displayOrders();
                    break;
                case 3:
                    quickSort(0, orderCount - 1);
                    System.out.println("Orders sorted using Quick Sort.");
                    displayOrders();
                    break;
                case 4:
                    displayOrders();
                    break;
                case -1:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Incorrect choice, please try again.");
                    break;
            }
            if (choice == -1) {
                break;
            }
        }
        sc.close();
    }
}
