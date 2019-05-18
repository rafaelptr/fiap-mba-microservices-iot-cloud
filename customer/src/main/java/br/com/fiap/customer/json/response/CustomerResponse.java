package br.com.fiap.customer.json.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private String name;
    private String lastName;
    private String gender;
    private Integer age;
}
