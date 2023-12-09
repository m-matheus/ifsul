package br.com.ifsul.monitoraifsul.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.DiscriminatorType;

// @Entity: marca que a classe é uma entidade persistente, mostra ao JPA (framework) que a classe deve ser tratada como uma tabela no bd.
@Entity
// Faz com que cada herança tenha a sua própria tabela.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class Usuario implements Serializable{
    // @Id: marca a variável como chave primária.
    // @GeneratedValue: gera valores automático para a variável.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected long id;
    protected String nome;
    @Column(unique = true)
    protected String email;
    protected String senha;
    
    // Construtor vazio
    public Usuario() {} 

    // Construtor com parâmetros
    public Usuario(long id, String nome, String email, String senha) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


    // Gets e Sets das variáveis:
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
