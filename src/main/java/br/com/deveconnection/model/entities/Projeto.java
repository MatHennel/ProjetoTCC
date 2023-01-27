package br.com.deveconnection.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Projeto {

    private int idProjeto;
    private String nome;
    private String proposta;
    private Cliente donoProjeto;
    private Dev devProjeto;
    private String categorias;
    private LocalDateTime dataPostagem;
    private LocalDateTime dataPrevIni;
    private LocalDateTime dataPrevFim;
    private Double valor;
    private Boolean status;
    private List<Missao> missoes;

    

    public Projeto(String nome, String proposta, Cliente donoProjeto, String categorias, LocalDateTime dataPostagem,
            LocalDateTime dataPrevIni, LocalDateTime dataPrevFim, Double valor) {
        this.nome = nome;
        this.proposta = proposta;
        this.donoProjeto = donoProjeto;
        this.categorias = categorias;
        this.dataPostagem = dataPostagem;
        this.dataPrevIni = dataPrevIni;
        this.dataPrevFim = dataPrevFim;
        this.valor = valor;
        this.status = true;
    }

    public Projeto(int idProjeto, String nome, String proposta, Cliente donoProjeto, String categorias,
            LocalDateTime dataPostagem, LocalDateTime dataPrevIni, LocalDateTime dataPrevFim, Double valor) {
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.proposta = proposta;
        this.donoProjeto = donoProjeto;
        this.categorias = categorias;
        this.dataPostagem = dataPostagem;
        this.dataPrevIni = dataPrevIni;
        this.dataPrevFim = dataPrevFim;
        this.valor = valor;
        this.status = true;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataPrevFim() {
        return dataPrevFim;
    }

    public void setDataPrevFim(LocalDateTime dataPrevFim) {
        this.dataPrevFim = dataPrevFim;
    }
    
    
    public LocalDateTime getDataPrevIni() {
        return dataPrevIni;
    }

    public void setDataPrevIni(LocalDateTime dataPrevIni) {
        this.dataPrevIni = dataPrevIni;
    }
    
    
    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public LocalDateTime getDataPostagem() {
        return dataPostagem;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

   

    

    public void contratarDev(Dev dev){
        this.devProjeto = dev;
    }




    public int getIdProjeto() {
        return idProjeto;
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




    public Cliente getDonoProjeto() {
        return donoProjeto;
    }

    public Dev getDevProjeto() {
        return devProjeto;
    }

    public void vincularDev(Dev dev){

    }

    public void editarProjeto(Projeto projeto){

    }

    public void alternarStatusProjeto(Boolean status){
        
    }

}
