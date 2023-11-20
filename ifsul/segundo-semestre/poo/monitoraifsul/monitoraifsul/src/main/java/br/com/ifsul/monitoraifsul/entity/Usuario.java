package br.com.ifsul.monitoraifsul.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// @Entity: marca que a classe é uma entidade persistente, mostra ao JPA (framework) que a classe deve ser tratada como uma tabela no bd.
@Entity
public class Usuario implements Serializable{
    // @Id: marca a variável como chave primária.
    // @GeneratedValue: gera valores automático para a variável.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    protected String nome;
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
