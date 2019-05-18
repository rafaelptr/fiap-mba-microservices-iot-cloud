package br.com.fiap.customer.service;

import br.com.fiap.customer.entity.Customer;
import br.com.fiap.customer.json.request.CustomerRequest;
import br.com.fiap.customer.json.response.CustomerCreateResponse;
import br.com.fiap.customer.json.response.CustomerResponse;
import br.com.fiap.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.stream.Stream;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponse findById(Integer id) {


        Customer customer = customerRepository
                .findById(id)
                //.map( cus ->  customerResponse)
                .orElseThrow(()->
                        new HttpClientErrorException(HttpStatus.NOT_FOUND,"Customer not found"));

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setName(customer.getName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setGender(customer.getGender());
        customerResponse.setAge(customer.getAge());

        return customerResponse;

    }

    @Override
    public CustomerCreateResponse create(CustomerRequest customerRequest) {
        validateGender(customerRequest.getGender());

        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setLastName(customerRequest.getLastName());
        customer.setGender(customerRequest.getGender());
        customer.setAge(customerRequest.getAge());

        Customer createdCustomer = customerRepository.save(customer);

        CustomerCreateResponse customerCreateResponse = new CustomerCreateResponse();
        customerCreateResponse.setCustomerId(createdCustomer.getId());

        return customerCreateResponse;
    }

    private void validateGender(String gender) {
        Stream.of("MALE","FEMALE")
                .filter(s->s.equals(gender.toUpperCase()))
                .findFirst()
                .orElseThrow(()-> new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,"Gender is invalid"));
    }
}
