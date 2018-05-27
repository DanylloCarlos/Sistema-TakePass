package interfaceservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServicoListarClientes extends Remote {

	public void listarClientes() throws RemoteException;
	public String retornaMensagem(String msg) throws RemoteException;
	
}
