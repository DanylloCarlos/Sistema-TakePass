package servicosrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public String retornaMensagem(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		msg = "Olá " + msg + ", o servidor está funcionando";
		return  msg;
	}


	@Override
	public ArrayList<Clientes> listarClientesPorEvento() throws RemoteException, SQLException {
	
		EventoDAO eventoDAO = null;
		ArrayList<Eventos> listaDeClientesPorEvento;
	
	
		try {
			eventoDAO = new EventoDAO();
			listaDeClientesPorEvento = eventoDAO.listarClientesPorEvento();
			
			if(listaDeClientesPorEvento.isEmpty()) {
				System.out.println("Dados não recuperados com sucesso");
			}else {
				int contador=0;
				while(!listaDeClientesPorEvento.isEmpty()) {
					listaDeClientesPorEvento.get(contador);
					contador++;
				}
				
			}
			
			return listaDeClientesPorEvento;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				return null;
	}
}	

