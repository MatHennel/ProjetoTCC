package deveconnection.model.Entities;


public class Adm extends Usuario {
    
    private int idAdm;

    
    public Adm(String nome, String telefone, String email, String senha, String cidade, int idAdm) {
        super(nome, telefone, email, senha, cidade);
        this.idAdm = idAdm;
    }

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    public void verProjetosDenunciados() {
        
    }

    public void inativarProjetos() {
        
    }

    public void inativarUsuarios() {
        
    }



}
