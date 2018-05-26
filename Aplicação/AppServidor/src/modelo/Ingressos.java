package modelo;

import java.io.Serializable;

public class Ingressos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idIngresso;
	private int quantidadeIngressos;
	private String descricao;
	
	public int getIdIngresso() {
		return idIngresso;
	}
	
	public void setIdIngresso(int novoIdIngresso) {
		this.idIngresso = novoIdIngresso;
	}

	public int getQuantidadeIngressos() {
		return quantidadeIngressos;
	}

	public void setQuantidadeIngressos(int quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
