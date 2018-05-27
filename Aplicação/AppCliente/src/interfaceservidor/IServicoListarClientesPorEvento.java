package interfaceservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Clientes;

public interface IServicoListarClientesPorEvento extends Remote {

	public ArrayList<Clientes> listarClientesPorEvento() throws RemoteException, SQLException;
	public String retornaMensagem(String msg) throws RemoteException;
	
}
