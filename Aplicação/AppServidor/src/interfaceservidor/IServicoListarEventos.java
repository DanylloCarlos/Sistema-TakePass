package interfaceservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import modelo.Clientes;

public interface IServicoListarEventos extends Remote {

	public ArrayList<Clientes> retornaListaDeEventosDisponiveis(int codigoDoEvento, String descricaoEvento) throws RemoteException;
	public String retornaMensagem(String msg) throws RemoteException;
	
}
