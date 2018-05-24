package modelo;

import java.io.Serializable;

public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int idCliente;
	String nome;
	String cpf;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, String cpf) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.cpf = cpf;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
