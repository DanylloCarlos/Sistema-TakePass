package modelo;

import java.io.Serializable;

public class Eventos implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idEvento;
	private String nomeEvento;
	private int Clientes_idCliente;
	private int Ingressos_idIngresso;
	
	public int getIdEvento() {
		return this.idEvento;
	}
	
	public String getNomeEvento() {
		return this.nomeEvento;
	}
	
	public int getClientes_idCliente() {
		return this.Clientes_idCliente;
	}
	
	public int getIngressos_idIngresso() {
		return this.Ingressos_idIngresso;
	}
}
