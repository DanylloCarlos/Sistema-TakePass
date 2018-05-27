package sistema;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaceservidor.IServicoListarClientesPorEvento;

public class Principal {

	public static void main(String[] args) {
		ArrayList<String> clientesPorEvento;
		String urlservico = "";
		
		urlservico = "//localhost/listarclientesporevento";
		
		try {
			IServicoListarClientesPorEvento slcpe = 
					(IServicoListarClientesPorEvento)Naming.lookup(urlservico);
			String msg = slcpe.retornaMensagem("Serviço iniciado!");
			
			clientesPorEvento = slcpe.listarClientesPorEvento();
			
			int contador=0;
			
			while(contador < clientesPorEvento.size()) {
				System.out.println(clientesPorEvento.get(contador));
				System.out.println("****************************************************");
				System.out.println();
			}
		
		} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
