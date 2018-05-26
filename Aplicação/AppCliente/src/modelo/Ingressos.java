package modelo;

import java.io.Serializable;

public class Ingressos implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idIngresso;
	private int codEvento;
	private String nomeEvento;
	private int Clientes_idCliente;
	
	public int getIdIngresso() {
		return this.idIngresso;
	}
	
	public int getCodEvento() {
		return this.codEvento;
	}
	
	public String getNomeEvento() {
		return this.nomeEvento;
	}
	
	public int getClientes_idCliente() {
		return this.Clientes_idCliente;
	}
}
