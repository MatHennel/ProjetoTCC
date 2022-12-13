package br.com.deveconnection.model.Entities;

import java.time.LocalDateTime;



public class Missao {

    private int idMissao;
    private Double valorProjeto;
    private Projetos projeto;
    private Cliente donoProjeto;
    private Dev devProjeto;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String codigoMissao;
    
    
    public Missao(int idMissao, Double valorProjeto, Projetos projeto, Cliente donoProjeto, Dev devProjeto,
            LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.idMissao = idMissao;
        this.valorProjeto = valorProjeto;
        this.projeto = projeto;
        this.donoProjeto = donoProjeto;
        this.devProjeto = devProjeto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
       
    }


    public int getIdMissao() {
        return idMissao;
    }


    public Double getValorProjeto() {
        return valorProjeto;
    }


    public void setValorProjeto(Double valorProjeto) {
        this.valorProjeto = valorProjeto;
    }


    public Projetos getProjeto() {
        return projeto;
    }


    public void setProjeto(Projetos projeto) {
        this.projeto = projeto;
    }


    public Cliente getDonoProjeto() {
        return donoProjeto;
    }


    public Dev getDevProjeto() {
        return devProjeto;
    }


    public void setDevProjeto(Dev devProjeto) {
        this.devProjeto = devProjeto;
    }


    public LocalDateTime getDataInicio() {
        return dataInicio;
    }


    public LocalDateTime getDataFim() {
        return dataFim;
    }


    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }


    public String getCodigoMissao() {
        return codigoMissao;
    }


    public void enviarCodigo(String codigoMissao) {
        this.codigoMissao = codigoMissao;
    }

    




    
    
}
