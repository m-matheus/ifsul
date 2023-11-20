package br.com.ifsul.monitoraifsul.entity;

import jakarta.persistence.Entity;

@Entity
public class Estudante extends Usuario{
    private String matricula;
    private String curso;
    private int semestre;
    private boolean monitor;
    
    
    public Estudante() {
        super();
    }


    public Estudante(long id, String nome, String email, String senha, String matricula, String curso, int semestre,
            boolean monitor) {
        super(id, nome, email, senha);
        this.matricula = matricula;
        this.curso = curso;
        this.semestre = semestre;
        this.monitor = monitor;
    }


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

    
}
