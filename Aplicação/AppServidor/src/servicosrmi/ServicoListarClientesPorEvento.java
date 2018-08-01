package servicosrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.EventoDAO;
import interfaceservidor.IServicoListarClientesPorEvento;
import modelo.Clientes;
import modelo.Eventos;

public class ServicoListarClientesPorEvento extends UnicastRemoteObject 
implements IServicoListarClientesPorEvento {

	private static final long serialVersionUID = 1L;

	public ServicoListarClientesPorEvento() throws RemoteException {
	
		super();
	}


	@Override
	public String retornaMensagem(String msg){
		// TODO Auto-generated method stub
		msg = "Ola " + msg + ", o servidor esta funcionando";
		return  msg;
	}


	@Override
	public ArrayList<Clientes> listarClientesPorEvento(int codigoDoEvento){
	
		System.out.println();
		
		ArrayList<Clientes> listaClientesPorEvento;
		
		try {
		EventoDAO eventoDAO = new EventoDAO();
		
		listaClientesPorEvento = eventoDAO.listarClientesPorEvento(codigoDoEvento);
		
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
	
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}	
}
