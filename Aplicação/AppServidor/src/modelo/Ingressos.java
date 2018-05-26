package modelo;

import java.io.Serializable;

public class Ingressos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idIngresso;
	private String nomeEvento;
	private int Clientes_idCliente;
	
	public void setIdIngresso(int novoIdIngresso) {
		this.idIngresso = novoIdIngresso;
	}
	
	public int getIdIngresso() {
		return this.idIngresso;
	}
	
	public String getNomeEvento() {
		return this.nomeEvento;
	}
	
	public int getClientes_idCliente() {
		return this.Clientes_idCliente;
	}
}
