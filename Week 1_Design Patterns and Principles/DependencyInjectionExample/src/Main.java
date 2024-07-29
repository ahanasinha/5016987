public class Main {
    public static void main(String[] args) {
        System.out.println("Testing dependency injection");
        CustomerRepository cr=new CustomerRepositoryImpl();

        CustomerService cs=new CustomerService(cr);

        cs.findCustomerById(1);
    }
}