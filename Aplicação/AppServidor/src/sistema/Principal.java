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
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Incluir um Cliente");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Cadastrar Evento");
			System.out.println("4 - Listar Ingressos por Evento");
			System.out.println("5 - Listar Clientes por Evento");
			System.out.println("6 - Inicializar o Servidor");
			System.out.println("7 - Sair da Aplicação");
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
				cadastrarEventos();
				
				break;
			
			case 4:
				listarIngressosPorEvento();
				
				break;
				
			case 5:
				listarClientesPorEvento();
				
				break;
				
			case 6:
				iniciarServidor();
				System.out.println("Servidor em execução.");
				break;
				
			case 7:
				System.out.println();
				System.out.println("Saindo....");
				System.out.println();
				System.out.println("Aplicação encerrada com Sucesso.");
				
				break;	
				
			default:
				break;
			}
			
		}while (opcao != 6 && opcao != 7);

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
		
		System.out.printf("código do Cliente: ");
		codigoCli = codCli.nextInt();
		
		EventoDAO eDAO = new EventoDAO();
		eDAO.cadastrarEvento(nomeEvento, qtdIngressos, codigoCli);
		
		System.out.println("Ingresso cadastrado com sucesso!!!");
		
		System.out.println();
	}
	
	private static void listarIngressosPorEvento() throws ClassNotFoundException, SQLException {
		System.out.println();
		
		ArrayList<String> listaIngressosPorEvento;
		EventoDAO eventoDAO = new EventoDAO();
		
		listaIngressosPorEvento = eventoDAO.listarIngressosPorEvento();
		int contador=0;
		while (listaIngressosPorEvento.size() > contador) {
			
				System.out.println(listaIngressosPorEvento.get(contador));
				contador++;
				System.out.println("******************************");
				System.out.println();
		}
		
	}
	
	private static ArrayList<Eventos> listarClientesPorEvento() throws SQLException, ClassNotFoundException {
	
		System.out.println();
		
		ArrayList<String> listaClientesPorEvento;
		EventoDAO eventoDAO = new EventoDAO();
		
		listaClientesPorEvento = eventoDAO.listarClientesPorEvento();
		int contador=0;
		while (listaClientesPorEvento.size() > contador) {
			
				System.out.println(listaClientesPorEvento.get(contador));
				contador++;
				System.out.println("******************************");
				System.out.println();
		}
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
