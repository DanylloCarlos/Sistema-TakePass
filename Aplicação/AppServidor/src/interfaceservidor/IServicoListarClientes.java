package interfaceservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface IServicoListarClientes extends Remote {

	public void listarClientes() throws RemoteException, SQLException, ClassNotFoundException;
	public String retornaMensagem(String msg) throws RemoteException;
	
}
