package br.com.ifsul.monitoraifsul.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Professor")
public class Professor extends Usuario{
    private String formacao;

    
    public Professor() {
        super();
    }


    public Professor(long id, String nome, String email, String senha, String formacao) {
        super(id, nome, email, senha);
        this.formacao = formacao;
    }


    public String getFormacao() {
        return formacao;
    }


    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    
}
