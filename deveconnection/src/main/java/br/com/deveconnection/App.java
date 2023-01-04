package br.com.deveconnection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.deveconnection.model.DAO.ClienteDAO;
import br.com.deveconnection.model.DAO.Conexao;
import br.com.deveconnection.model.DAO.DevDAO;
import br.com.deveconnection.model.DAO.JDBCClienteDAO;
import br.com.deveconnection.model.DAO.JDBCDevDAO;
import br.com.deveconnection.model.Entities.Cliente;
import br.com.deveconnection.model.Entities.Dev;
import br.com.deveconnection.model.Repository.ClienteRepository;
import br.com.deveconnection.model.Repository.DevRepository;

public class App {
    public static void main(final String[] args) throws Exception {
        final int fim = 0;
        final Scanner scan = new Scanner(System.in);

        final Conexao conexao = Conexao.getInstance();

        conexao.getConnection();

        final ClienteDAO clienteDAO = new JDBCClienteDAO(conexao);
        final ClienteRepository clienteRepository = new ClienteRepository(clienteDAO);

        DevDAO devDao = new JDBCDevDAO(conexao);
        DevRepository devRepository = new DevRepository(devDao);

        int opcao;

        while (fim == 0) {
            System.out.println("Bem vindo ao DevEConnection");
            System.out.println("----------------------------");
            System.out.println("1> Cadastrar Cliente");
            System.out.println("2> Cadastro dev");
            System.out.println("3> Listar Devs");

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

                    final Cliente cliente = new Cliente(nome, telefone, email, senha, cidade, cnpj);

                    final Boolean cadastro = clienteRepository.cadastrarCliente(cliente);

                    if (cadastro) {
                        System.out.println("Cadastro realizado");
                    } else {
                        System.out.println("Erro no cadastro");
                    }

                    break;

                case 2:

                    Dev dev = new Dev("Lucas", "2222", "lucas@!", "41231", "cwb",
                            "back end, full stack, muitas palvras d exempl",
                            LocalDate.of(2002, 10, 05), "sadas");

                    if (devRepository.cadastrarDev(dev)) {
                        System.out.println("Cdastro realziado");
                    } else {
                        System.out.println("Erro cadastro");
                    }

                    break;

                case 3:
                    
                    List<Dev> listaDev = new ArrayList<>();
                    
                    listaDev = clienteRepository.visualizarDevsDisponiveisParaTrabalho();

                    if(listaDev == null){
                        System.out.println("Nao tem devs");
                    }else{
                        System.out.println(listaDev);
                    }

                    break;
            }
        }
    }
}
