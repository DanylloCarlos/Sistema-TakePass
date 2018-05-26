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
	 * @param nome
	 * @param CPF
	 * @throws SQLException
	 */
	
	public void cadastrarCliente(String nome, String CPF) throws SQLException {
		
		String sql = "Insert int Cliente(nomeCliente, cpf) values ("+nome+", "+CPF+")";
		
		pstm = c.prepareStatement(sql);
		pstm.executeQuery();
		
		pstm.close();
		c.close();
		
	}
	

	/**
	 * @param cli
	 * @throws SQLException
	 */
	
	public void removerCliente(Clientes cli) throws SQLException{
	
		String sql = "Delete from Clientes where idCliente = ?";
		
		pstm = c.prepareStatement(sql);
		pstm.setInt(1, cli.getIdCliente());
		pstm.executeQuery();
		
		pstm.close();
		c.close();
		
	}
	
	/**
	 * @param CPF
	 * @return cli
	 * @throws SQLException
	 */
	
	public Clientes buscarCliente(String CPF) throws SQLException{
		Clientes cli = new Clientes();
		
		String sql = "Select * from Clientes where cpf= ?";
		
		pstm = c.prepareStatement(sql);
		pstm.setString(1, CPF);
		rs = pstm.getResultSet();
		
		while(rs.next()) {
			cli.setIdCliente(rs.getInt("idCliente"));
			cli.setNomeCliente(rs.getString("nomeCliente"));
			cli.setCpf(rs.getString("cpf"));
			
		}
		
		return cli;
	}
	
	
	
}
