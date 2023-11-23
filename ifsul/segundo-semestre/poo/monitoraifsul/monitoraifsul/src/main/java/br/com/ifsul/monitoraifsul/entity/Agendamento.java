package br.com.ifsul.monitoraifsul.entity;

import java.sql.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date data;
    private String hora;
    private String local;
    private int vagas;
    
    
    // Muitos para um: lado dominante, precisa usar o JoinColumn para especificar qual coluna que faz a ligação com o lado não dominante.
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Estudante estudanteMonitor;


    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Estudante estudanteNormal;




    public Agendamento() {}

    public Agendamento(long id, Date data, String hora, String local, int vagas) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.vagas = vagas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    
}
