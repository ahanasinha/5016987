public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Adapter Pattern");
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        payPalProcessor.processPayment();

        PaymentProcessor razorPayProcessor = new RazorPayAdapter(new RazorPay());
        razorPayProcessor.processPayment();
    }
}