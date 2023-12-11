package br.com.ifsul.monitoraifsul.entity;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("Professor")
public class Professor extends Usuario{
    private String formacao;


    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplinas;

  
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


    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
