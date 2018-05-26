package interfaceservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import modelo.Clientes;

public interface IServicoClientesPorEvento extends Remote {

	public ArrayList<Clientes> clientesPorEvento(int codigoDoEvento, String descricaoEvento) throws RemoteException;
	public String retornaMensagem(String msg) throws RemoteException;
	
}
