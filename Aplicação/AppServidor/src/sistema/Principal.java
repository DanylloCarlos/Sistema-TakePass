package sistema;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.EventoDAO;
import modelo.Clientes;
import modelo.Eventos;
import servicosrmi.ServicoListarClientesPorEvento;

public class Principal {
	
	private static Scanner teclado;
	private static Scanner opContinuar;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, RemoteException {
		
		int opcao=0;
		
		teclado = new Scanner(System.in);
		
		do{
			System.out.println("Sistema TakePass ----- Compra e Venda de Ingressos");
			System.out.println();
			System.out.println("Escolha uma opcao:");
			System.out.println("1 - Cadastrar um Cliente");
			System.out.println("2 - Cadastrar Evento");
			System.out.println("3 - Listar Clientes");
			System.out.println("4 - Listar Clientes por Evento");
			System.out.println("5 - Iniciar o Servidor");
			System.out.println("6 - Sair da Aplicacao");
			System.out.println();
			System.out.printf("Digite aqui uma opcao: ");
			
			opcao = teclado.nextInt();
			
			switch (opcao) {
			case 1:
				cadastrarCliente();
				
				break;
			
			case 2:
				cadastrarEventos();
				
				break;
			
			case 3:
				listarClientes();
				
				break;
				
			case 4:
				listarClientesPorEvento();
				
				break;
				
			case 5:
				iniciarServidor();
				System.out.println("Servidor em execucao.");
				break;
				
			case 6:
				System.out.println();
				System.out.println("Saindo....");
				System.out.println();
				System.out.println("Aplicacao encerrada com Sucesso.");
				
				break;	
				
			default:
				break;
			}
			
		}while (opcao != 5 && opcao != 6);

	}

	private static void cadastrarCliente() throws ClassNotFoundException, SQLException{
		System.out.println();
		
		Scanner nomCli = new Scanner(System.in);
		Scanner scCpf = new Scanner(System.in);
		Scanner idEvt = new Scanner(System.in);
		
		System.out.printf("Nome do Cliente: ");
		String nomeCliente = nomCli.nextLine();
		
		System.out.printf("Cpf do cliente: ");
		String cpf = scCpf.nextLine();
		
		System.out.printf("id do Evento: ");
		int idEvento = idEvt.nextInt();
		
		
		Clientes clientes = new Clientes();
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.cadastrarCliente(nomeCliente, cpf, idEvento);
		
		System.out.println();
		
		System.out.println("Cliente salvo com sucesso!");
		
		System.out.println();
	}
	
	private static void listarClientes() throws ClassNotFoundException, SQLException {
		System.out.println();
		
		ArrayList<Clientes> listaClientesSaida;
		ClienteDAO clienteDAO = new ClienteDAO();
		listaClientesSaida = clienteDAO.listarClientes();
		
		if(listaClientesSaida.isEmpty()) {
			System.out.println("Nenhum dado cadastrado no banco ou falha no acesso aos dados");
			System.out.println();
		}else {
			
			System.out.println("|/|/| Dados recuperados com sucesso! Carregando lista... /|/|/|/|/\n");
			System.out.println();
			for (Clientes clientes : listaClientesSaida) {
				System.out.println("Id do Cliente: " + clientes.getIdCliente());
				System.out.println("Nome: " + clientes.getNomeCliente());
				System.out.println("CPF: " + clientes.getCpf());
				System.out.println("******************************\n\n");
		
			}
		}
	}
	
	private static void cadastrarEventos() throws ClassNotFoundException, SQLException {
		String nomeEvento;
		int qtdIngressos;
		int codigoCli;
		
		System.out.println();
		
		Scanner evento = new Scanner(System.in);	
		Scanner qtd = new Scanner(System.in);
		Scanner codCli = new Scanner(System.in);
		
		System.out.printf("Nome do evento: ");
		nomeEvento = evento.nextLine();
		
		System.out.printf("Quantidade de Ingressos: ");
		qtdIngressos = qtd.nextInt();
		
		System.out.printf("codigo do Cliente: ");
		codigoCli = codCli.nextInt();
		
		EventoDAO eDAO = new EventoDAO();
		eDAO.cadastrarEvento(nomeEvento, qtdIngressos, codigoCli);
		
		System.out.println("Evento cadastrado com sucesso!!!");
		
		System.out.println();
	}
	
	private static ArrayList<Clientes> listarClientesPorEvento() throws SQLException, ClassNotFoundException {
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int codigoDeAcesso;
		
		System.out.printf("Por favor, digite o codigo de acesso do evento: ");
		codigoDeAcesso = sc.nextInt();
		
		
		ArrayList<Clientes> listaClientesPorEvento;
		EventoDAO eventoDAO = new EventoDAO();
		
		listaClientesPorEvento = eventoDAO.listarClientesPorEvento(codigoDeAcesso);
		int contador=0;
		
		if(listaClientesPorEvento == null || listaClientesPorEvento.isEmpty()) {
			System.out.println("Nenhum dado cadastrado no banco ou falha no acesso aos dados");
			System.out.println();
		
		}else {
			
			System.out.println("|/|/| Dados carregados com sucesso! Carregando lista... /|/|/|/|/\n");
			System.out.println();

			for (Clientes clientes : listaClientesPorEvento) {
				System.out.println("Id do Cliente: " + clientes.getIdCliente());
				System.out.println("Nome: " + clientes.getNomeCliente());
				System.out.println("CPF: " + clientes.getCpf());
				System.out.println("******************************\n\n");
		
			}
		}
		
		
		return listaClientesPorEvento;
	}
	
	private static void iniciarServidor() {
		try {
			LocateRegistry.createRegistry(1099);
			ServicoListarClientesPorEvento slcpe = new ServicoListarClientesPorEvento();
			Naming.rebind("//localhost/listarclientesporevento", slcpe);
			System.out.println("Inicializando o Servidor....");
		
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
