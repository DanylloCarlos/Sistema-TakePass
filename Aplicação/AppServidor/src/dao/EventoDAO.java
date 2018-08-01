package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Clientes;
import modelo.Eventos;
import modelo.Ingressos;
import util.ConexaoBD;

public class EventoDAO {
	private Connection c;
	private PreparedStatement pstm;
	private ResultSet rs;
	private String sql;
	private ArrayList<Clientes> listaDeClientesPorEvento;
	
	public EventoDAO() {
		
		try {
			c = ConexaoBD.novaConexao();
		
		}catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public void cadastrarEvento(String nomeDoEvento, int qtdIngressos, int idCliente){
		
		sql = "Insert into Eventos(nomeEvento, qtdIngressos)"
				+ " values (?, ?)";
		
		try {
			
			pstm = c.prepareStatement(sql);
			pstm.setString(1, nomeDoEvento);
			pstm.setInt(2, qtdIngressos);
			
			pstm.executeUpdate();
			
			pstm.close();
			c.close();
			
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}
	}
	
	public void removerEvento(Eventos e){
		
		String sql = "Delete from Eventos e where e.IdEvento = ?";
		
		try {
			pstm = c.prepareStatement(sql);
			pstm.setInt(1, e.getIdEvento());
			
			pstm.execute();
			
			pstm.close();
			c.close();
			
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}
		
		
	}
	
	public Eventos buscarEvento(int idEvento){
		
		Eventos e = new Eventos();
		
		String sql = "Select * from Eventos e where e.idEvento =?";
		
		try {
			pstm = c.prepareStatement(sql);
			pstm.setInt(1, idEvento);
			rs = pstm.executeQuery();
			
			pstm.close();
			c.close();
			
			while(rs.next()) {
				e.setIdEvento(rs.getInt("idEvento"));
				e.setNomeEvento(rs.getString("nomeEvento"));
				e.setClientes_idCliente(rs.getInt("Clientes_idCliente"));
				e.setIngressos_idIngresso(rs.getInt("Ingressos_idIngresso"));
			}
			
			return e;
		
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Clientes> listarClientesPorEvento(int codigoDeAcesso) {
		listaDeClientesPorEvento = new ArrayList<>();
		
		sql = "Select nomeCliente, cpf from Clientes c, Eventos e "
				+ "Where c.Eventos_idEvento = e.idEvento and e.idEvento = ?";
		
			try {
				pstm = c.prepareStatement(sql);
				pstm.setInt(1, codigoDeAcesso);
				rs = pstm.executeQuery();
				
				while(rs.next()){

					Clientes cli = new Clientes();
					
					cli.setNomeCliente(rs.getString("nomeCliente"));
					cli.setCpf(rs.getString("cpf"));
					
					listaDeClientesPorEvento.add(cli);

					
				  	return listaDeClientesPorEvento;
				}
				
				pstm.close();
				c.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}	
}