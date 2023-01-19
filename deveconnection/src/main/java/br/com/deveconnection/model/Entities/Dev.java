package br.com.deveconnection.model.Entities;


import java.time.LocalDate;
import java.util.List;

public class Dev extends Usuario{

    private int idDev;
    private String competenciasDev;
    private LocalDate dataDeNascimento;
    private Boolean status;
    private String especialidades;

    public Dev(String nome, String telefone, String email, String senha, String cidade, String competenciasDev,
            LocalDate dataDeNascimento, String especialidades) {
        super(nome, telefone, email, senha, cidade);
        this.competenciasDev = competenciasDev;
        this.dataDeNascimento = dataDeNascimento;
        this.especialidades = especialidades;
        this.status = true;
    }



    public Dev(String nome, String telefone, String email, String senha, String cidade,int idDev ,
            String competenciasDev, LocalDate dataDeNascimento, String especialidades) {
        super(nome, telefone, email, senha, cidade);
        this.competenciasDev = competenciasDev;
        this.dataDeNascimento = dataDeNascimento;
        this.especialidades = especialidades;
        this.idDev = idDev;
        this.status = true;
    }

    public String getEspecialidades() {
        return especialidades;
    }



    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    

    public Boolean getStatus() {
        return status;
    }

    public int getIdDev() {
        return idDev;
    }


    public void setIdDev(int idDev) {
        this.idDev = idDev;
    }


    public String getCompetenciasDev() {
        return competenciasDev;
    }


    public void setCompetenciasDev(String competenciasDev) {
        this.competenciasDev = competenciasDev;
    }


    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }


    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    

    public List<Projeto> visualizarProjetos() {
        return null;
    }

    public void alternarStatusPerfil(Boolean status){
        this.status = status;
    }

    public List<Projeto>  buscarProjeto(int idProjeto, String nome){
        return null;
    }

    public void interagirChat() {
        
    }

    public void candidatarProjeto(Projeto projeto) {
    
    }

    public void denunciarProjeto(Projeto projeto) {
        
    }

    public void editarDev(Dev dev){

    }

    public List<Projeto> listarProjetosContratantes(){
        return null;
    }

    @Override
    public String toString() {
        String msg = "Id: " + idDev;
        msg += "\nNome: " + getNome();
        msg += "\nTelefone: " + getTelefone();
        msg += "\nEmail: " + getEmail();
        msg += "\nSenha: " + getSenha();
        msg += "\nCidade: " + getCidade();
        msg += "\nData de Nascimento: " + getDataDeNascimento();
        msg += "\nCompetencias Dev: " + getCompetenciasDev();
        msg += "\nStatus: " + getStatus() + "\n\n";








        return msg;
    }


}
