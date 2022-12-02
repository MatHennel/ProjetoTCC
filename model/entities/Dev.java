package model.Entities;


import java.time.LocalDate;

public class Dev extends Usuario{

    private int idDev;
    private String competenciasDev;
    private LocalDate dataDeNascimento;

    
    public Dev(String nome, String telefone, String email, String senha, String cidade, int idDev,
            String competenciasDev, LocalDate dataDeNascimento) {
        super(nome, telefone, email, senha, cidade);
        this.idDev = idDev;
        this.competenciasDev = competenciasDev;
        this.dataDeNascimento = dataDeNascimento;
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
    

    public void visualizarProjetos() {
        
    }

    public void interagirChat() {
        
    }

    public void candidatarProjeto(Projetos projeto) {
    
    }

    public void denunciarProjeto(Projetos projeto) {
        
    }


}
