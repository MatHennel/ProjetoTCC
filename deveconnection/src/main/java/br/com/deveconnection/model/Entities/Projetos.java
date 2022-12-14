package br.com.deveconnection.model.Entities;


public class Projetos {

    private int id;
    private String nome;
    private String proposta;
    private Cliente cliente;
    private Dev dev;
    
    
    
    
    public Projetos(int id, String nome, String proposta, Cliente cliente) {
        this.id = id;
        this.nome = nome;
        this.proposta = proposta;
        this.cliente = cliente;
    }

    public void contratarDev(Dev dev){
        this.dev = dev;
    }




    public int getId() {
        return id;
    }




    public void setId(int id) {
        this.id = id;
    }




    public String getNome() {
        return nome;
    }




    public void setNome(String nome) {
        this.nome = nome;
    }




    public String getProposta() {
        return proposta;
    }




    public void setProposta(String proposta) {
        this.proposta = proposta;
    }




    public Cliente getCliente() {
        return cliente;
    }




    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    
}
