import java.util.Scanner;

public class FinancialForecast {

    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Predict future value");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter present value: ");
                    double presentValue = sc.nextDouble();

                    System.out.print("Enter growth rate (as a decimal, e.g., 0.05 for 5%): ");
                    double growthRate = sc.nextDouble();

                    System.out.print("Enter number of periods: ");
                    int periods = sc.nextInt();

                    double futureValue = calculateFutureValue(presentValue, growthRate, periods);
                    System.out.printf("The future value after %d periods is: %.2f%n", periods, futureValue);
                    break;

                case 2:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
