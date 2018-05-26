package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Clientes;
import modelo.Ingressos;
import util.ConexaoBD;

public class ClienteDAO {
	private Connection c;
	private PreparedStatement pstm;
	private ResultSet rs;
	private String sql;
	private ArrayList<Ingressos> ingressos;
	
	public ClienteDAO() throws ClassNotFoundException, SQLException {
		c = ConexaoBD.novaConexao();
	}
	
	/**
	 * Listar todos os clientes por evento
	 * @return ingressos
	 */
	public ArrayList listarClientes (Clientes cli) {
		sql = "Select "+cli.getNomeCliente()+" from Clientes where";
		
		return null;
	}
}
