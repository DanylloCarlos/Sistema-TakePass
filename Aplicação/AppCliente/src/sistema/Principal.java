package sistema;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import interfaceservidor.IServicoClientesPorEvento;
import modelo.Clientes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlservico = "";
		
		urlservico = "//localhost/listareventos";
		
		try {
			IServicoClientesPorEvento cpe = (IServicoClientesPorEvento)Naming.lookup(urlservico);
			String msg = cpe.retornaMensagem("Iniciando Servi�o");
			System.out.println(msg);
			ArrayList<Clientes> clientesPorEvento = cpe.clientesPorEvento(11, "Evento beneficente");
			for (Clientes cliente : clientesPorEvento) {
				System.out.println("Nome:" + cliente.getNomeCliente());
				System.out.println("CPF:" + cliente.getCpf());
				System.out.println("************************");
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
