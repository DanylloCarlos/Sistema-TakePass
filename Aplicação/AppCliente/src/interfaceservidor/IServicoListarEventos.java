package interfaceservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import modelo.Eventos;

public interface IServicoListarEventos extends Remote{

	public Eventos listarEventos() throws RemoteException;
	public String retornaMensagem(String msg) throws RemoteException;
	
}
