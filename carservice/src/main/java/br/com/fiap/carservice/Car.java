package br.com.fiap.carservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Car {
    //Possibilidade de utilizar como id
    //@Id
    //private UUID id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrementavel e chave primária
    private int id;
    private String color;
    private String model;
}
