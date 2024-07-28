public class PayPalAdapter implements PaymentProcessor{
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment() {
        payPal.makePayment();
    }
}
