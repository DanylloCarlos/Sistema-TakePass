package sistema;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.IngressoDAO;
import modelo.Clientes;
import modelo.Ingressos;

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
			/*System.out.println("5 - Inicializar o Servidor");*/
			System.out.println("6 - Sair da Aplicacao");
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
			/*case 5:
				iniciarServidor();
				break;*/
			case 6:
				System.out.println("Saindo....");
				break;	
			default:
				break;
			}
			
		}while (opcao != 6);

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

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlservico = "";
		
		urlservico = "//localhost/listareventos";
		
		try {
			IServicoListarEventos sla = (IServicoListarEventos)Naming.lookup(urlservico);
			String msg = sla.retornaMensagem("Iniciando Servi�o");
			System.out.println(msg);
		//	ArrayList<Clientes> listaDeEventos = sla.retornaListaDeEventosDisponiveis(201823, "Show de Ivete Sangalo");
			for (Clientes cliente : listaDeEventos) {
				System.out.println("Nome:" + cliente.getNomeCliente());
				System.out.println("CPF:" + cliente.getCpf());
				System.out.println("************************");
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
*/
}
