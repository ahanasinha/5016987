public class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Logger constructor created");
    }

    public static Logger getInstance() {
        if (instance == null) {
            System.out.println("Logger instance created");
            instance = new Logger();
        }
        return instance;
    }
}
