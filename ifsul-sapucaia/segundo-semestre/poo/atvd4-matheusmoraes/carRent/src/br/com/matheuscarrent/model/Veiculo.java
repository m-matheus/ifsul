package br.com.matheuscarrent.model;

public class Veiculo {
    protected long id;
    protected String placa;
    protected String modelo;
    protected String cor;
    protected int ano;
    private Double preco;
    private Usuario proprietario;
    private String status;
    
    
    public Veiculo() {
        super();
        id = 0;
        placa = "";
        modelo = "";
        cor = "";
        ano = 0;
        preco = 0.0;
        proprietario = new Usuario();
        status = "Disponivel";
    }


    public Veiculo(long id, String placa, String modelo, String cor, int ano, Double preco, Usuario proprietario, String status) {
        super();
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.proprietario = proprietario;
        this.status = status;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getPlaca() {
        return placa;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getCor() {
        return cor;
    }


    public void setCor(String cor) {
        this.cor = cor;
    }


    public int getAno() {
        return ano;
    }

    
    public void setAno(int ano) {
        this.ano = ano;
    }


    public Usuario getProprietario() {
        return proprietario;
    }


    public void setProprietario(Usuario proprietario) {
        this.proprietario = proprietario;
    }


    public Double getPreco() {
        return preco;
    }


    public void setPreco(Double preco) {
        this.preco = preco;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
    
}
