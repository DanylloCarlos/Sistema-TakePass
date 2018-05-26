package interfaceservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import modelo.Eventos;
import modelo.Ingressos;

public interface IServicoIngressosPorEvento extends Remote {

	public ArrayList<Object> ingressosPorEvento(Eventos e, Ingressos i) throws RemoteException;
	public String retornaMensagem(String msg) throws RemoteException;
}
