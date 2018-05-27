package sistema;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import interfaceservidor.IServicoClientesPorEvento;
import interfaceservidor.IServicoListarEventos;
import modelo.Clientes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlservico = "";
		
		urlservico = "//localhost/listareventos";
		
		try {
			IServicoListarEventos cpe = (IServicoListarEventos)Naming.lookup(urlservico);
			String msg = cpe.retornaMensagem("Iniciando Serviço");
			System.out.println(msg);
			ArrayList<Clientes> clientesPorEvento = cpe.retornaListaDeEventosDisponiveis("show de safadão");
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
