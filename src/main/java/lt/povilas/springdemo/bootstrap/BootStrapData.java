package lt.povilas.springdemo.bootstrap;

import lt.povilas.springdemo.repository.CustomerRepository;
import lt.povilas.springdemo.repository.ProductLinesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private CustomerRepository customerRepository;
    private ProductLinesRepository productLinesRepository;


    public BootStrapData(CustomerRepository customerRepository, ProductLinesRepository productLinesRepository) {
        this.customerRepository = customerRepository;
        this.productLinesRepository = productLinesRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.findAll().forEach(System.out::println);
        System.out.println("\n=================\n");
        System.out.println(customerRepository.findById(112));
        System.out.println("\n=================\n");
        productLinesRepository.findAll().forEach(System.out::println);
        System.out.println(productLinesRepository.findById("Ships"));

    }
}
