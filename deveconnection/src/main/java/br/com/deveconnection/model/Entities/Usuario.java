package br.com.deveconnection.model.Entities;
public abstract class Usuario {

    private String nome;
    

    private String telefone;
    

    private String email;
    

    private String senha;
    

    private String cidade;

    

    public Usuario(String nome, String telefone, String email, String senha, String cidade) {

        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}