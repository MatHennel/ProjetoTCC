package deveconnection.model.Entities;
import java.util.List;

public class Cliente extends Usuario {

    private int idCliente;
    
    private String cnpj;

    private List<Projetos> projeto;



    public Cliente(String nome, String telefone, String email, String senha, String cidade, int idCliente, String cnpj) {
        super(nome, telefone, email, senha, cidade);
        
        this.idCliente= idCliente;
        this.cnpj= cnpj;

    }

    public Cliente(String nome, String telefone, String email, String senha, String cidade, String cnpj) {
        super(nome, telefone, email, senha, cidade);
        
        this.idCliente= -1;
        this.cnpj= cnpj;

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

    public List<Projetos> getProjetos() {
        return projeto;
    }

    public void setProjetos(List<Projetos> projetos) {
        this.projeto = projetos;
    }


    public void editarPerfil() {
        
    }

    public void alternarStatus() {
        
    }

    public void visualizarDevsDisponiveisParaTrabalho() {
        
    }

    public void criarProjeto() {
        
    }

    public void interagirComChat() {
        
    }

    public void contratarDev() {
        
    }


    
    
}
