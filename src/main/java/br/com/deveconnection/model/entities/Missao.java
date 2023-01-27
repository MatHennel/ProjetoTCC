package br.com.deveconnection.model.entities;

import java.time.LocalDateTime;

public class Missao {
    private int idMissao;
    private Double valorProjeto;
    private Projeto projeto;
    private Cliente donoProjeto;
    private Dev devProjeto;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String codigoMissao;

    public int getIdMissao() {
        return idMissao;
    }

    public Double getValorProjeto() {
        return valorProjeto;
    }
    public void setValorProjeto(Double valorProjeto) {
        this.valorProjeto = valorProjeto;
    }
    public Projeto getProjeto() {
        return projeto;
    }
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    public Cliente getDonoProjeto() {
        return donoProjeto;
    }
    public void setDonoProjeto(Cliente donoProjeto) {
        this.donoProjeto = donoProjeto;
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
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
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

    public void finalizarMissao(){
        
    }

    public void enviarCodigo(String codigoMissao){
        
    }
    
    
}
