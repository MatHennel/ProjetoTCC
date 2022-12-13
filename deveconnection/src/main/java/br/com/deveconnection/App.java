package br.com.deveconnection;

import java.time.LocalDate;
import java.util.Scanner;

import br.com.deveconnection.model.DAO.ClienteDAO;
import br.com.deveconnection.model.DAO.Conexao;
import br.com.deveconnection.model.DAO.MySQLClienteDAO;
import br.com.deveconnection.model.Entities.Cliente;
import br.com.deveconnection.model.Repository.ClienteRepository;

public class App {

    public static void testaCadastroDev(){
        String nome = "Zé";
        String email = "ze@teste.com";
        String telefone = "9995999";
        String senha = "123123";
        LocalDate data = LocalDate.of(2010, 1, 1);
        String cidade = "curitiba";
        String competencias = "Desenvolvedor java junior, a um ano";

        

        //dao.cadastrar(usuario);


    }





    public static void main(final String[] args) throws Exception {
        final int fim = 0;
        final Scanner scan = new Scanner(System.in);

        final Conexao conexao = Conexao.getInstance();

        conexao.getConnection();

        final ClienteDAO clienteDAO = new MySQLClienteDAO(conexao);
        final ClienteRepository clienteRepository = new ClienteRepository(clienteDAO);

        int opcao;

        while (fim == 0) {
            System.out.println("Bem vindo ao DevEConnection");
            System.out.println("----------------------------");
            System.out.println("1> Cadastrar Cliente");
            System.out.println("2> Cadastrar Dev");
            opcao = scan.nextInt();

            switch (opcao) {
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

                    Boolean cadastro = clienteRepository.cadastrarCliente(cliente);

                        if(cadastro){
                            System.out.println("Cadastro realizado");
                        }else{
                            System.out.println("Erro no cadastro");
                        }

                    break;

                case 2:

                        


    

                        break;

                
            }
        }
    }
}
