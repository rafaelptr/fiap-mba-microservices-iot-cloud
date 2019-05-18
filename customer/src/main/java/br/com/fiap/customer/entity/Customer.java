package br.com.fiap.customer.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String lastName;
    private String gender;
    private Integer age;
}
