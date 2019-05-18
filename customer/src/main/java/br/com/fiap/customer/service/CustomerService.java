package br.com.fiap.customer.service;

import br.com.fiap.customer.json.request.CustomerRequest;
import br.com.fiap.customer.json.response.CustomerCreateResponse;
import br.com.fiap.customer.json.response.CustomerResponse;

public interface CustomerService{
    CustomerResponse findById(Integer id);
    CustomerCreateResponse create(CustomerRequest customerRequest);
}
