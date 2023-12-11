package br.com.ifsul.monitoraifsul.entity;

import java.util.List;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("Estudante")
public class Estudante extends Usuario {
    private String matricula;
    private String curso;
    private int semestre;
    private boolean monitor;

    @OneToMany(mappedBy = "estudanteMonitor")
    private List<Agendamento> agendaMonitor;

    // @OneToMany indica um relacionamento um-para-muitos entre Estudante e Agendamento.
    // MappedBy = "estudanteNormal" especifica que o lado "muitos" (Agendamento) é responsável pelo mapeamento.
    // Fetch = FetchType.EAGER = estudante e agendamento carregando junto.
    @OneToMany(mappedBy = "estudanteNormal", fetch = FetchType.EAGER)
    private List<Agendamento> agendaNormal;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public boolean isMonitor() {
        return monitor;
    }

    public void setMonitor(boolean monitor) {
        this.monitor = monitor;
    }

    public List<Agendamento> getAgendaMonitor() {
        return agendaMonitor;
    }

    public void setAgendaMonitor(List<Agendamento> agendaMonitor) {
        this.agendaMonitor = agendaMonitor;
    }

    public List<Agendamento> getAgendaNormal() {
        return agendaNormal;
    }

    public void setAgendaNormal(List<Agendamento> agendaNormal) {
        this.agendaNormal = agendaNormal;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
