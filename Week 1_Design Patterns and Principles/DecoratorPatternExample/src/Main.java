public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Decorator Pattern");
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);
        slackNotifier.send("This is a test message.");
    }
}