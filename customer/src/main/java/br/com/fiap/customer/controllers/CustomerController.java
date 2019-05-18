package br.com.fiap.customer.controllers;

import br.com.fiap.customer.json.error.ErrorResponse;
import br.com.fiap.customer.json.request.CustomerRequest;
import br.com.fiap.customer.json.response.CustomerCreateResponse;
import br.com.fiap.customer.json.response.CustomerResponse;
import br.com.fiap.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@RestController
public class CustomerController  {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerResponse> findCustomerById(@PathVariable("id") Integer id ){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerCreateResponse> createCustomer(@RequestBody CustomerRequest customerRequest){
        return  ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customerRequest));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(HttpServerErrorException httpServerErrorException ){
        return ResponseEntity
                .status(httpServerErrorException.getStatusCode())
                .body(new ErrorResponse(httpServerErrorException.getStatusText()));
    }
}
