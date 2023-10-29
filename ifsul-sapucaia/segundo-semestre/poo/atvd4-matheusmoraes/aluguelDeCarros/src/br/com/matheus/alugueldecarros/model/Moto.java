package br.com.matheus.alugueldecarros.model;

public class Moto extends Veiculo{
    protected String partida;
    protected String acessorio;
    protected String freio;

    public Moto() {
        super();
        partida = "";
        acessorio = "";
        freio = "";
    }

    public Moto(int ano, String cor, Double quilometragem, String combustivel, Double valor, Usuario proprietario,
            String partida, String acessorio, String freio) {
        super(ano, cor, quilometragem, combustivel, valor, proprietario);
        this.partida = partida;
        this.acessorio = acessorio;
        this.freio = freio;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(String acessorio) {
        this.acessorio = acessorio;
    }

    public String getFreio() {
        return freio;
    }

    public void setFreio(String freio) {
        this.freio = freio;
    }

    
}
