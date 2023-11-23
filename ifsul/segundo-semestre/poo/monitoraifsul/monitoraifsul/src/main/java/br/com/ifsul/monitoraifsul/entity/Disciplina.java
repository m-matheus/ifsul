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
    private String area;
    
    
    @OneToMany(mappedBy = "disciplina")
    private List<Estudante> estudantesDisciplina;




    public Disciplina() {}

    public Disciplina(long id, String materia, String area) {
        this.id = id;
        this.materia = materia;
        this.area = area;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    
}
