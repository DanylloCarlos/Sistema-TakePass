package sistema;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import interfaceservidor.IServicoListarClientesPorEvento;
import modelo.Clientes;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Clientes> clientesPorEvento;
		String urlservico = "";
		Scanner sc = new Scanner(System.in);
		int codigoDeAcesso;
		
		
		urlservico = "//localhost/listarclientesporevento";
		
		try {
			IServicoListarClientesPorEvento slcpe = 
					(IServicoListarClientesPorEvento)Naming.lookup(urlservico);
			slcpe.retornaMensagem("Servico iniciado!");
			
			System.out.printf("Por favor, digite um codigo de acesso: ");
			codigoDeAcesso = sc.nextInt();
			
			sc.close();
			
			clientesPorEvento = slcpe.listarClientesPorEvento(codigoDeAcesso);
			
			int contador=0;
			
			if(clientesPorEvento == null) {
			
				System.out.println("Falha no acesso aos dados ou lista vazia");
				
				System.out.println();
				
				return;
				
			}else {
			
			while(clientesPorEvento.size() > contador) {
				System.out.println();
				System.out.printf("Cliente: "+clientesPorEvento.get(contador).getNomeCliente()
						+" || CPF: "+clientesPorEvento.get(contador).getCpf());
						System.out.println();
				System.out.println("****************************************************");
				System.out.println();
				contador++;
			}
			}
			
			System.out.println("Fim da execucao.");
			
		} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
