package modelo;

import java.io.Serializable;

public class Eventos implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idEvento;
	private String nomeEvento;
	private int Clientes_idCliente;
	private int Ingressos_idIngresso;
	
	public void setIdEvento(int novoIdEvento) {
		this.idEvento = novoIdEvento;
	}
	
	public int getIdEvento() {
		return this.idEvento;
	}
	
	public void setNomeEvento(String nomeDoEvento) {
		this.nomeEvento = nomeDoEvento;
	}
	
	public String getNomeEvento() {
		return this.nomeEvento;
	}
	
	public void setClientes_idCliente(int fkIdCliente) {
		this.Clientes_idCliente = fkIdCliente;
		
	}
	
	public int getClientes_idCliente() {
		return this.Clientes_idCliente;
	}
	
	public void setIngressos_idIngresso(int fkIdIngresso) {
		this.Ingressos_idIngresso = fkIdIngresso;
		
	}
	
	public int getIngressos_idIngresso() {
		return this.Ingressos_idIngresso;
	}
}
