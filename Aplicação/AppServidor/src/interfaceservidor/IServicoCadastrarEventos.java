package interfaceservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import modelo.Eventos;

public interface IServicoCadastrarEventos extends Remote{

	public Eventos novoEvento(String nomeDoEvento, int idCliente, int idIngresso) throws RemoteException;
	public String retornaMensagem(String msg) throws RemoteException;

}
