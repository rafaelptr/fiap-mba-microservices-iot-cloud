package br.com.fiap.customer.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private Integer id;
    private String name;
    private String lastName;
    private String gender;
    private Integer age;
}
