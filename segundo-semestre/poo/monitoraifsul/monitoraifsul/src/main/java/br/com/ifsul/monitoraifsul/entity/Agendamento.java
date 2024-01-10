package br.com.ifsul.monitoraifsul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String diaSemana;
    private String turno;
    private int vagas;

    
    // Muitos para um: lado dominante, precisa usar o JoinColumn para especificar qual coluna que faz a ligação com o lado não dominante.
    @ManyToOne
    @JoinColumn(name="usuario_id", insertable=false, updatable=false)
    private Estudante estudanteMonitor;


    @ManyToOne
    @JoinColumn(name="usuario_id", insertable=false, updatable=false)
    private Estudante estudanteNormal;

    @ManyToOne
    @JoinColumn(name="disciplina_id")
    private Disciplina disciplina;

    public Agendamento() {}

    public Agendamento(long id, String diaSemana, String turno, int vagas, Estudante estudanteMonitor,
            Estudante estudanteNormal, Disciplina disciplina) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.turno = turno;
        this.vagas = vagas;
        this.estudanteMonitor = estudanteMonitor;
        this.estudanteNormal = estudanteNormal;
        this.disciplina = disciplina;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public Estudante getEstudanteMonitor() {
        return estudanteMonitor;
    }

    public void setEstudanteMonitor(Estudante estudanteMonitor) {
        this.estudanteMonitor = estudanteMonitor;
    }

    public Estudante getEstudanteNormal() {
        return estudanteNormal;
    }

    public void setEstudanteNormal(Estudante estudanteNormal) {
        this.estudanteNormal = estudanteNormal;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    

    
}
