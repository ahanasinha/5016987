public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(null);

        PaymentStrategy creditCardPayment = new CreditCardPayment();
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(250.00);

        PaymentStrategy payPalPayment = new PayPalPayment();
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(350.00);
    }
}
