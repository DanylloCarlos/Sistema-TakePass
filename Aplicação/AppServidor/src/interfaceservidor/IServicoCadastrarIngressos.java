package interfaceservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import modelo.Ingressos;

public interface IServicoCadastrarIngressos extends Remote{

	public Ingressos novoIngresso(int qtdDisp, String descricao) throws RemoteException;
}
