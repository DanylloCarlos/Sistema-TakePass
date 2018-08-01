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
	ArrayList<Clientes> listaDeClientes;
	
	public ClienteDAO() throws ClassNotFoundException, SQLException {
		
		c = ConexaoBD.novaConexao();
	}
	
	public void cadastrarCliente(String nome, String cpf, int idEvento){
		
		String sql = "Insert into Clientes (nomeCliente, cpf, Eventos_idEvento) values (?, ?, ?)";
		
		try {
			pstm = c.prepareStatement(sql);
			
			pstm.setString(1, nome);
			pstm.setString(2, cpf);
			pstm.setInt(3, idEvento);
			
			pstm.executeUpdate();
			
			pstm.close();
			c.close();
			
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}
			
	}
	
	public void removerCliente(Clientes cli) throws SQLException{
	
		String sql = "Delete from Clientes c where c.idCliente = ?";
		
		pstm = c.prepareStatement(sql);
		pstm.setInt(1, cli.getIdCliente());
		pstm.executeQuery();
		
		pstm.close();
		c.close();
		
	}
	
	public Clientes buscarCliente(String cpf) throws SQLException{
		Clientes cli = new Clientes();
		
		String sql = "Select * from Clientes c where c.cpf= ?";
		
		pstm = c.prepareStatement(sql);
		pstm.setString(1, cpf);
		rs = pstm.getResultSet();
		
		pstm.close();
		c.close();
		
		while(rs.next()) {
			cli.setIdCliente(rs.getInt("idCliente"));
			cli.setNomeCliente(rs.getString("nomeCliente"));
			cli.setCpf(rs.getString("cpf"));
			
		}
		
		return cli;
	}
	
	public ArrayList<Clientes> listarClientes(){
		listaDeClientes = new ArrayList<Clientes>();
		sql = "Select * from Clientes";
		
		try {
			pstm = c.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				Clientes clientes = new Clientes();
				clientes.setIdCliente(rs.getInt("idCliente"));
				clientes.setNomeCliente(rs.getString("nomeCliente"));
				clientes.setCpf(rs.getString("cpf"));
				listaDeClientes.add(clientes);
			}
			pstm.close();
			c.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return listaDeClientes;
		
	}
}
