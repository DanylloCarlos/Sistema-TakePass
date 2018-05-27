package sistema;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.IngressoDAO;
import modelo.Clientes;
import modelo.Ingressos;
import servicosrmi.ServicoListarClientes;

public class Principal {
	
	private static Scanner teclado;
	private static Scanner opContinuar;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, RemoteException {
		// TODO Auto-generated method stub
		
		int opcao = 0;
		teclado = new Scanner(System.in);
		do{
			System.out.println("Sistema TakePass ----- Compra e Venda de Ingressos");
			System.out.println();
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Incluir um Cliente");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Cadastrar de Ingressos");
			System.out.println("4 - Listar Ingressos");
			/*System.out.println("5 - Inicializar o Servidor");*/
			System.out.println("6 - Sair da Aplicação");
			System.out.println();
			System.out.printf("Digite aqui uma opção: ");
			opcao = teclado.nextInt();
			switch (opcao) {
			case 1:
				incluirCliente();
				break;
			case 2:
				listarClientes();
				break;
			case 3:
				cadastrarIngressos();
				break;
			case 4:
				listarIngressosPorEvento();
				break;
			/*case 5:
				iniciarServidor();
				break;*/
			case 6:
				System.out.println();
				System.out.println("Saindo....");
				System.out.println();
				System.out.println("Aplicação encerrada com Sucesso.");
				break;	
			default:
				break;
			}
			
			System.out.println("Deseja realizar outra execução? ");
			
		}while (opcao != 6);

	}

	private static void incluirCliente() throws ClassNotFoundException, SQLException{
		System.out.println();
		
		teclado = new Scanner(System.in);
		
		System.out.printf("Nome do Cliente: ");
		String nomeCliente = teclado.nextLine();
		
		System.out.printf("Cpf do cliente: ");
		String cpf = teclado.nextLine();
		
		Clientes clientes = new Clientes();
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.cadastrarCliente(nomeCliente, cpf);
		
		System.out.println();
		
		System.out.println("Dados salvos com sucesso");
		
		System.out.println();
	}
	
	private static void listarClientes() throws ClassNotFoundException, SQLException {
		System.out.println();
		
		ArrayList<Clientes> listaClientesSaida;
		ClienteDAO clienteDAO = new ClienteDAO();
		listaClientesSaida = clienteDAO.listarClientes();
		
		if(listaClientesSaida.isEmpty()) {
			System.out.println("Problemas ao recuperar dados do banco");
		}else {
			
			System.out.println("|/|/| Dados recuperados com sucesso! Carregando lista... /|/|/|/|/\n");

			for (Clientes clientes : listaClientesSaida) {
				System.out.println("Id do Cliente: " + clientes.getIdCliente());
				System.out.println("Nome: " + clientes.getNomeCliente());
				System.out.println("CPF: " + clientes.getCpf());
				System.out.println("******************************\n\n");
		
			}
		}
	}
	
	private static void cadastrarIngressos() throws ClassNotFoundException, SQLException {
		System.out.println();
		
		teclado = new Scanner(System.in);
		
		System.out.println("Quantidade de Ingressos: ");
		int quantidadeIngressos = teclado.nextInt();
		
		System.out.println("Descrição do Ingresso: ");
		String descricaoDosIngressos = teclado.next();
	
		Ingressos ingressos = new Ingressos();
		
		IngressoDAO ingressoDAO = new IngressoDAO();
		ingressoDAO.cadastrarIngresso(quantidadeIngressos, descricaoDosIngressos);
		
		System.out.println("Ingresso cadastrado com sucesso");
	}
	
	private static void listarIngressosPorEvento() throws ClassNotFoundException, SQLException {
		System.out.println();
		
		ArrayList<String> listaIngressosSaida;
		IngressoDAO ingressoDAO = new IngressoDAO();
		
		listaIngressosSaida = ingressoDAO.listarIngressosPorEvento();
		int contador=0;
		while (listaIngressosSaida.size() > contador) {
			
			//	System.out.println("Id do Ingresso: " + ingressos.getIdIngresso());
				System.out.println(listaIngressosSaida.get(contador));
				contador++;
				System.out.println("******************************");
				System.out.println();
		}
		
	}
}
