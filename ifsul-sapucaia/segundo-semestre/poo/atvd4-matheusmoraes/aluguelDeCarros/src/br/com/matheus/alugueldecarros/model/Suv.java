package br.com.matheus.alugueldecarros.model;

public class Suv extends Carro{
    protected String cabine;
    protected String tracao;

    public Suv() {
        super();
        cabine = "";
        tracao = "";
    }

    public Suv(int ano, String cor, Double quilometragem, String combustivel, Double valor, Usuario proprietario,
            String cambio, int numeroDePortas, String cabine, String tracao) {
        super(ano, cor, quilometragem, combustivel, valor, proprietario, cambio, numeroDePortas);
        this.cabine = cabine;
        this.tracao = tracao;
    }

    public String getCabine() {
        return cabine;
    }

    public void setCabine(String cabine) {
        this.cabine = cabine;
    }

    public String getTracao() {
        return tracao;
    }

    public void setTracao(String tracao) {
        this.tracao = tracao;
    }

    
}
