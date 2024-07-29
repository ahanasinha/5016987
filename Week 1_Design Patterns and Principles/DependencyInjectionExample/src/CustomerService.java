public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void findCustomerById(int id) {
        customerRepository.findCustomerById(id);
        System.out.println("Finding customer by id: " + id +" | Using dependency");
    }
}
