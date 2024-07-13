package com.example.d288_project.BootStrap;

import com.example.d288_project.dao.CustomerRepository;
import com.example.d288_project.dao.DivisionRepository;
import com.example.d288_project.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BootStrapData.class);

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) {
        log.info("BootStrapData run method started");

        // Check if there is only one customer (the default one) to avoid overwriting
        if (customerRepository.count() == 1) {
            log.info("Adding sample customers");
            addSampleCustomers();
        } else {
            log.info("Customers already exist or no need to insert sample data.");
        }
    }

    private void addSampleCustomers() {
        Customer david = new Customer();
        david.setFirstName("David");
        david.setLastName("Shapiro");
        david.setAddress("777 Lucky Road");
        david.setPhone("(777)777-7777");
        david.setPostal_code("11111");
        david.setDivision(divisionRepository.getReferenceById(52L));
        customerRepository.save(david);
        log.info("Added customer: David Shapiro");

        Customer aaron = new Customer();
        aaron.setFirstName("Aaron");
        aaron.setLastName("Cortez");
        aaron.setAddress("999 Gold Street");
        aaron.setPhone("(999)999-9999");
        aaron.setPostal_code("99999");
        aaron.setDivision(divisionRepository.getReferenceById(4L));
        customerRepository.save(aaron);
        log.info("Added customer: Aaron Cortez");

        Customer kevin = new Customer();
        kevin.setFirstName("Kevin");
        kevin.setLastName("Meehan");
        kevin.setAddress("333 Ocean Ave");
        kevin.setPhone("(333)333-3333");
        kevin.setPostal_code("33333");
        kevin.setDivision(divisionRepository.getReferenceById(25L));
        customerRepository.save(kevin);
        log.info("Added customer: Kevin Meehan");

        Customer samantha = new Customer();
        samantha.setFirstName("Samantha");
        samantha.setLastName("Sterling");
        samantha.setAddress("222 Silver Street");
        samantha.setPhone("(222)222-2222");
        samantha.setPostal_code("22222");
        samantha.setDivision(divisionRepository.getReferenceById(65L));
        customerRepository.save(samantha);
        log.info("Added customer: Samantha Sterling");

        Customer julia = new Customer();
        julia.setFirstName("Julia");
        julia.setLastName("Ortega");
        julia.setAddress("444 Happy Lane");
        julia.setPhone("(444)444-4444");
        julia.setPostal_code("44444");
        julia.setDivision(divisionRepository.getReferenceById(104L));
        customerRepository.save(julia);
        log.info("Added customer: Julia Ortega");
    }
}
