import java.io.IOException;
import java.util.Scanner;

import model.DAO.ClienteDAO;
import model.DAO.Conexao;
import model.DAO.MySQLClienteDAO;
import model.Entities.Cliente;

public class App {
    public static void main(String[] args) throws IOException {
     int fim = 0;
     Scanner scan = new Scanner(System.in);
     Conexao c = new Conexao();
     ClienteDAO clienteDAO = new MySQLClienteDAO();
    
    
    int opcao;
    
    try {
    Class.forName("com.mysql.jdbc.Driver");
    c.conectaBd();
    
    System.out.println("OK");
    
            } catch (Exception e) {
    System.out.println("Driver do banco de dados localizado");
    }
    
    
 while(fim == 0){
    System.out.println("Bem vindo ao DevEConnection");
    System.out.println("----------------------------");
    System.out.println("1> Cadastrar Cliente");
    opcao = scan.nextInt();
    
    switch(opcao){
      case 1:
         String nome;
         String telefone;
         String email;
         String senha;
         String cidade;
         String cnpj;
    
         System.out.println("Nome");
         nome = scan.next();
    
         System.out.println("Telefone");
         telefone = scan.next();
    
         System.out.println("Email");
         email = scan.next();
    
         System.out.println("Senha");
         senha = scan.next();
    
         System.out.println("Cidade");
         cidade = scan.next();
    
         System.out.println("Cnpj");
         cnpj = scan.next();
    
         Cliente cliente = new Cliente(nome, telefone, email, senha, cidade, cnpj);
    
         Boolean cadastro = clienteDAO.cadastrarCliente(cliente);
    
         if(cadastro){
          System.out.println("Cadastro realizado");
         }else{
          System.out.println("Erro no cadastro");
         }
    
       break;
    }
   }
 }
    }
    
