package servicosrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaceservidor.IServicoCadastrarClientes;
import modelo.Clientes;

public class ServicoCadastrarClientes extends UnicastRemoteObject implements IServicoCadastrarClientes {

	protected ServicoCadastrarClientes() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Clientes novoCliente(String nome, String fone) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String retornaMensagem(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
