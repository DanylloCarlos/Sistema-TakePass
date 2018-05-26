package sistema;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import interfaceservidor.IServicoListarEventos;
import modelo.Clientes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlservico = "";
		
		urlservico = "//localhost/listareventos";
		
		try {
			IServicoListarEventos sla = (IServicoListarEventos)Naming.lookup(urlservico);
			String msg = sla.retornaMensagem("Iniciando Serviço");
			System.out.println(msg);
		//	ArrayList<Clientes> listaDeEventos = sla.retornaListaDeEventosDisponiveis(201823, "Show de Ivete Sangalo");
			for (Clientes cliente : listaDeEventos) {
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
