package com.devmaicon.backend.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import com.devmaicon.backend.Validation.constraints.ValidatorCep;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

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

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoas;

    public void setPermissaoPessoa(List<PermissaoPessoa> pp) {
        for (PermissaoPessoa p : pp) {
            p.setPessoa(this);
        }

        this.permissaoPessoas = pp;
    }
}
