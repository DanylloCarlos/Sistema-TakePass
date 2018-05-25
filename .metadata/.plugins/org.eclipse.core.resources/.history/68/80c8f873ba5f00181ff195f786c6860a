package sistema;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import interfaceservidor.IServicoListarEventos;
import modelo.Cliente;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlservico = "";
		
		urlservico = "//localhost/listareventos";
		
		try {
			IServicoListarEventos sla = (IServicoListarEventos)Naming.lookup(urlservico);
			String msg = sla.retornaMensagem("Iniciando Serviço");
			System.out.println(msg);
			ArrayList<Cliente> listaDeEventos = sla.retornaListaDeEventosDisponiveis(201823, "Show de Ivete Sangalo");
			for (Cliente cliente : listaDeEventos) {
				System.out.println("Nome:" + cliente.getNome());
				System.out.println("CPF:" + cliente.getCpf());
				System.out.println("************************");
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
