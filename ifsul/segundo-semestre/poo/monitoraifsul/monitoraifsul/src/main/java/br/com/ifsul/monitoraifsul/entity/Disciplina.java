package br.com.ifsul.monitoraifsul.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String materia;
    
    @OneToMany(mappedBy = "disciplina")
    private List<Estudante> estudantesDisciplina;

    @OneToMany(mappedBy = "disciplina")
    private List<Agendamento> agendamentos;

    
    public Disciplina() {}

    public Disciplina(long id, String materia) {
        this.id = id;
        this.materia = materia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public List<Estudante> getEstudantesDisciplina() {
        return estudantesDisciplina;
    }

    public void setEstudantesDisciplina(List<Estudante> estudantesDisciplina) {
        this.estudantesDisciplina = estudantesDisciplina;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
