package br.com.matheus.alugueldecarros.model;

public class Carro extends Veiculo{
    protected String cambio;
    protected int numeroDePortas;
    
    public Carro() {
        super();
        cambio = "";
        numeroDePortas = 0;
    }

    public Carro(int ano, String cor, Double quilometragem, String combustivel, Double valor, Usuario proprietario,
            String cambio, int numeroDePortas) {
        super(ano, cor, quilometragem, combustivel, valor, proprietario);
        this.cambio = cambio;
        this.numeroDePortas = numeroDePortas;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getNumeroDePortas() {
        return numeroDePortas;
    }

    public void setNumeroDePortas(int numeroDePortas) {
        this.numeroDePortas = numeroDePortas;
    }

    
}
