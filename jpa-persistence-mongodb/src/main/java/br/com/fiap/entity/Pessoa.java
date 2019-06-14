package br.com.fiap.entity;

import java.util.List;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    private String id;
    private String nome;
    private List<Endereco> endereco;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, List<Endereco> endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
}