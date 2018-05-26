package interfaceservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import modelo.Clientes;

public interface IServicoCadastrarClientes extends Remote{

	public Clientes novoCliente(String nome, String fone) throws RemoteException;

}
