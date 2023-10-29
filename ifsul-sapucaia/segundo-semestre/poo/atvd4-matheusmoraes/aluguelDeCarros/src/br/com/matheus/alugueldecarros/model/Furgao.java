package br.com.matheus.alugueldecarros.model;

public class Furgao {
    protected Double capacidadeDeCarga;

    public Furgao() {
        super();
        capacidadeDeCarga = 0.0;
    }

    public Furgao(Double capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public Double getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    public void setCapacidadeDeCarga(Double capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    
}
