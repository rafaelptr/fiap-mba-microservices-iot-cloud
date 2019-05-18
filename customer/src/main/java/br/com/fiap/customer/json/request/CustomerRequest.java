package br.com.fiap.customer.json.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    private String name;
    private String lastName;
    private String gender;
    private Integer age;

}
