package servicormi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.EventoDAO;
import interfaceservidor.IServicoListarEventos;
import modelo.Clientes;

public class ServicoListarEventos extends UnicastRemoteObject implements IServicoListarEventos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServicoListarEventos() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String retornaMensagem(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		msg = "Olá " + msg + ", o servidor está funcionando";
		return  msg;
	}


	@Override
	public ArrayList<Clientes> retornaListaDeEventosDisponiveis(String nomeDoEvento) throws RemoteException {
		EventoDAO eventoDAO = null;
		try {
			eventoDAO = new EventoDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Clientes> listaDeClientes = new ArrayList<Clientes>();
		listaDeClientes = eventoDAO.listarClientesPorEvento(nomeDoEvento);
		
		return listaDeClientes;
	}

}
