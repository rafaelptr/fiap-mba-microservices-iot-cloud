package br.com.fiap.customer.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    private Integer id;
    private String name;
    private String lastName;
    private String gender;
    private Integer age;
}
