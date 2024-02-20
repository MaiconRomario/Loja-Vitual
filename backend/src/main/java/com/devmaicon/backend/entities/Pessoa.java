package com.devmaicon.backend.entities;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import com.devmaicon.backend.Validation.constraints.ValidatorCep;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome Não pode ser Vazio")
    private String nome;

    @CPF(message = "CPF Não esta correto")
    @NotBlank(message = "CPF Não pode ser Vazio")
    private String cpf;

    @Email(message = "E-mail Não esta correto")
    @NotBlank(message = "E-mail Não pode ser Vazio")
    private String email;

    @NotBlank(message = "Senha Não pode ser Vazio")
    private String senha;

    private String endereco;

    @ValidatorCep
    private String cep;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "idCidade")
    private Cidade cidade;
}
