package br.com.matheus.alugueldecarros.model;

public class Veiculo {
    protected int ano;
    protected String cor;
    protected Double quilometragem;
    protected String combustivel;
    protected Double valor;
    protected Usuario proprietario;
    
    public Veiculo() {
        ano = 0;
        cor = "";
        quilometragem = 0.0;
        combustivel = "";
        valor = 0.0;
        }

    public Veiculo(int ano, String cor, Double quilometragem, String combustivel, Double valor, Usuario proprietario) {
        this.ano = ano;
        this.cor = cor;
        this.quilometragem = quilometragem;
        this.combustivel = combustivel;
        this.valor = valor;
        this.proprietario = proprietario;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Usuario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Usuario proprietario) {
        this.proprietario = proprietario;
    }

    
}

