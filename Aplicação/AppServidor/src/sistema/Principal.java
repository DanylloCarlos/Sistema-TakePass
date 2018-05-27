package sistema;

import java.net.MalformedURLException;
import java.nio.channels.ClosedByInterruptException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.EventoDAO;
import dao.IngressoDAO;
import modelo.Clientes;
import modelo.Eventos;
import modelo.Ingressos;
import servicormi.ServicoListarEventos;

public class Principal {
	
	private static Scanner teclado;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		int opcao = 0;
		teclado = new Scanner(System.in);
		do{
			System.out.println("Sistema de Compra e Venda de Ingressos");
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Incluir um Cliente");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Cadastro de Ingressos: ");
			System.out.println("4 - Listar Ingressos: ");
			System.out.println("5 - Cadastro de Eventos: ");
			System.out.println("6 - Listar Eventos: ");
			System.out.println("7 - Inicializar o Servidor");
			System.out.println("8 - Sair da Aplicacao");
			System.out.println("Digite uma opção:");
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
				listarIngressos();
				break;
			case 5:
				cadastrarEventos();
				break;
			case 6:
				listarEventos();	
				break;
			case 7:
				iniciarServidor();
				break;
			case 8:
				System.out.println("Saindo....");
				break;	
			default:
				break;
			}
			
		}while (opcao != 7);

	}

	private static void listarEventos() throws ClassNotFoundException, SQLException {
		/// TODO Auto-generated method stub
		ArrayList<Eventos> listaEventosSaida;
		EventoDAO eventoDAO = new EventoDAO();
		
/*		listaEventosSaida = eventoDAO.buscarTodosOsEvento();*/
		
		listaEventosSaida = eventoDAO.buscarTodosOsEvento();
		
		for (Eventos evento : listaEventosSaida) {
			System.out.println("IdEvento: " + evento.getIdEvento());
			System.out.println("Nome do Evento: " + evento.getNomeEvento());
			System.out.println("IdCliente: " + evento.getClientes_idCliente());
			System.out.println("IdIngresso: " + evento.getIngressos_idIngresso());
			System.out.println("******************************");
		}
		
	}

	private static void incluirCliente() throws ClassNotFoundException, SQLException{
		
		teclado = new Scanner(System.in);
		
		System.out.println("Nome do Cliente: ");
		String nomeCliente = teclado.nextLine();
		
		System.out.println("Cpf do cliente: ");
		String cpf = teclado.nextLine();
		
		Clientes clientes = new Clientes();
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.cadastrarCliente(nomeCliente, cpf);
		System.out.println("Dados salvo com sucesso");
	}
	
	private static void listarClientes() throws ClassNotFoundException, SQLException {
		
		// TODO Auto-generated method stub
		ArrayList<Clientes> listaClientesSaida;
		ClienteDAO clienteDAO = new ClienteDAO();
		System.out.println("Cpf do cliente:");
		String cpf = teclado.nextLine();
		
		listaClientesSaida = clienteDAO.listarClientes();
		
		for (Clientes clientes : listaClientesSaida) {
			System.out.println("IdAluno: " + clientes.getIdCliente());
			System.out.println("Matricula: " + clientes.getNomeCliente());
			System.out.println("Nome: " + clientes.getCpf());
			System.out.println("******************************");
		}
		
	}
	
	private static void cadastrarIngressos() throws ClassNotFoundException, SQLException {
		teclado = new Scanner(System.in);
		
		System.out.println("Quantidade de Ingressos: ");
		int quantidadeIngressos = teclado.nextInt();
		
		System.out.println("Descrição do Ingresso: ");
		String descricaoDosIngressos = teclado.nextLine();
	
		Ingressos ingressos = new Ingressos();
		
		IngressoDAO ingressoDAO = new IngressoDAO();
		ingressoDAO.cadastrarIngresso(quantidadeIngressos, descricaoDosIngressos);
		
		System.out.println("Ingresso cadastrado com sucesso");
	}
	
	private static void listarIngressos() throws ClassNotFoundException, SQLException {
		ArrayList<Ingressos> listaIngressosSaida;
		IngressoDAO ingressoDAO = new IngressoDAO();
		
		listaIngressosSaida = ingressoDAO.listarIngressos();
		
		for (Ingressos ingressos : listaIngressosSaida) {
			System.out.println("IdIngresso: " + ingressos.getIdIngresso());
			System.out.println("Quantidade: " + ingressos.getQuantidadeIngressos());
			System.out.println("Descrição: " + ingressos.getDescricao());
			System.out.println("******************************");
		}
		
	}
	
	
	private static void cadastrarEventos() throws ClassNotFoundException, SQLException {
		teclado = new Scanner(System.in);
		
		System.out.println("Descrição do Evento: ");
		String nomeDoEvento = teclado.nextLine();
	
		System.out.println("Informe o id do cliente: ");
		int idCliente = teclado.nextInt();
		
		System.out.println("Informe o id do ingresso: ");
		int idIngresso = teclado.nextInt();
		
		EventoDAO eventoDAO = new EventoDAO();
		
		eventoDAO.cadastrarEvento(nomeDoEvento, idCliente, idIngresso);
		
		System.out.println("Evento cadastrado com sucesso");
	}
	

	private static void iniciarServidor() {
		try {
			LocateRegistry.createRegistry(1099);
			ServicoListarEventos sla = new ServicoListarEventos();
			Naming.rebind("//localhost/listareventos", sla);
			System.out.println("Inicializando o Servidor....");
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
