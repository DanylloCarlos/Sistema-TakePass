package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Eventos;
import util.ConexaoBD;

public class EventoDAO {
	private Connection c;
	private PreparedStatement pstm;
	private ResultSet rs;
	private String sql;
	private String[] cliPorEv, ingPorEv;
	private int contReg = 0;
	
	public EventoDAO() throws ClassNotFoundException,SQLException{
		c = ConexaoBD.novaConexao();
	}
	
	public void cadastrarEvento(String nomeDoEvento, int idDoCliente, int idDoIngresso) throws SQLException{
		
		String sql = "Insert into Eventos(nomeEvento, Clientes_idCliente, Ingressos_idIngresso) values (?, ?, ?)";
		
		pstm = c.prepareStatement(sql);
		pstm.setString(1, nomeDoEvento);
		pstm.setInt(2, idDoCliente);
		pstm.setInt(3, idDoIngresso);
		
		pstm.execute();
		
		pstm.close();
		c.close();
	}
	
	public void removerEvento(Eventos e) throws SQLException {
		
		String sql = "Delete from Eventos e where e.IdEvento = ?";
		
		pstm = c.prepareStatement(sql);
		pstm.setInt(1, e.getIdEvento());
		
		pstm.execute();
		
		pstm.close();
		c.close();
		
		
	}
	
	public Eventos buscarEvento(int idEvento) throws SQLException {
		
		Eventos e = new Eventos();
		
		String sql = "Select * from Eventos e where e.idEvento =?";
		
		pstm = c.prepareStatement(sql);
		pstm.setInt(1, idEvento);
		rs = pstm.executeQuery();
		
		while(rs.next()) {
			e.setIdEvento(rs.getInt("idEvento"));
			e.setNomeEvento(rs.getString("nomeEvento"));
			e.setClientes_idCliente(rs.getInt("Clientes_idCliente"));
			e.setIngressos_idIngresso(rs.getInt("Ingressos_idIngresso"));
		}
		
		return e;
	}
	
	public String[] clientesPorEvento() throws SQLException{
		
		sql = "Select nomeCliente, nomeEvento from Clientes c, Eventos e where c.IdCliente = e.Clientes_idCliente";
		
		pstm = c.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		
		while(rs.next()) {
			cliPorEv[contReg] = rs.getString("nomeEvento");
			cliPorEv[contReg] = rs.getString("nomeCliente");
			
		}
		
		return cliPorEv;
	}
	
	public String[] ingressosPorEvento() throws SQLException{
		
		sql = "Select nomeEvento, qtdDisp from Clientes c, Evento e where c.IdIngresso = e.Ingressos_idIngresso";
		
		pstm = c.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		while(rs.next()) {
			ingPorEv[contReg] = rs.getString("nomeEvento");
			ingPorEv[contReg] = rs.getString("qtdDisp");
			
		}
		
		return ingPorEv;
	}
}
