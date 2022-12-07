package br.com.deveconnection.model.Entities;
import java.util.List;

public class Cliente extends Usuario {

    private int idCliente;
    
    private String cnpj;

    private List<Projeto> projeto;

    private Boolean status;

    public Cliente(String nome, String telefone, String email, String senha, String cidade, int idCliente, String cnpj) {
        super(nome, telefone, email, senha, cidade);
        this.status = true;
        this.idCliente= idCliente;
        this.cnpj= cnpj;

    }

    public Cliente(String nome, String telefone, String email, String senha, String cidade, String cnpj) {
        super(nome, telefone, email, senha, cidade);
        this.status = true;
        this.idCliente= -1;
        this.cnpj= cnpj;

    }

    public Boolean getStatus() {
        return status;
    }

    public int getIdCliente() {
        return idCliente;
    }




    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Projeto> getProjetos() {
        return projeto;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projeto = projetos;
    }


    public void editarPerfil() {
        
    }

    public void alternarStatus() {
        
    }

    public List<Dev> buscarDev(int idDev,String nome){
        return null;
    }

    public void visualizarDevsDisponiveisParaTrabalho() {
        
    }

    public void interagirComChat() {
        
    }

    public List<Projeto> listarMeusProjetosCadastrados(){
        return null;
    }

    public void aprovarMissao(Missao missao){

    }


    
    
}
