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
	private String sql, sql1;
	private ArrayList<String> listaDeClientesPorEvento, listaDeIngressosPorEvento;
	private int contReg = 0;
	
	public EventoDAO() throws ClassNotFoundException,SQLException{
		c = ConexaoBD.novaConexao();
	}
	
	public void cadastrarEvento(String nomeDoEvento, int qtdIngressos, int idCliente) throws SQLException{
		
		sql = "Insert into Eventos(nomeEvento, qtdIngressos, Clientes_idCliente)"
				+ " values (?, ?, ?)";
		
		pstm = c.prepareStatement(sql);
		pstm.setString(1, nomeDoEvento);
		pstm.setInt(2, qtdIngressos);
		pstm.setInt(3, idCliente);
		
		pstm.executeUpdate();
		
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
		
		pstm.close();
		c.close();
		
		while(rs.next()) {
			e.setIdEvento(rs.getInt("idEvento"));
			e.setNomeEvento(rs.getString("nomeEvento"));
			e.setClientes_idCliente(rs.getInt("Clientes_idCliente"));
			e.setIngressos_idIngresso(rs.getInt("Ingressos_idIngresso"));
		}
		return e;
	}
	
	public ArrayList<String> listarClientesPorEvento() throws SQLException{
		
		sql = "Select nomeCliente, nomeEvento from Clientes c, Eventos e where c.IdCliente = e.Clientes_idCliente";
		
		pstm = c.prepareStatement(sql);
		pstm.executeQuery();
		rs = pstm.getResultSet();
			
			listaDeClientesPorEvento = new ArrayList<>();
			
			try {
				pstm = c.prepareStatement(sql);
				rs = pstm.executeQuery();
				
				while(rs.next()){

					Clientes cli = new Clientes();
					Eventos evento = new Eventos();
					String info = new String();
					
					cli.setNomeCliente(rs.getString("nomeCliente"));
					
					evento.setNomeEvento(rs.getString("nomeEvento"));
					
					info = "Cliente: "+cli.getNomeCliente()+" || Evento: "+evento.getNomeEvento();
					
					listaDeClientesPorEvento.add(info);
					
					
				}
				
				pstm.close();
				c.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listaDeClientesPorEvento;
		}
	
	public ArrayList<String> listarIngressosPorEvento(){
		
		listaDeIngressosPorEvento = new ArrayList<>();
		sql = "Select nomeEvento, qtdDisp from Ingressos i, Eventos e where i.idIngresso = e.Ingressos_idIngresso";
		
		try {
			pstm = c.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){

				Ingressos ingresso = new Ingressos();
				Eventos evento = new Eventos();
				String info = new String();
				
				ingresso.setQuantidadeIngressos(rs.getInt("qtdDisp"));
				
				evento.setNomeEvento(rs.getString("nomeEvento"));
				
				info = "Evento: "+evento.getNomeEvento()+" || Qtd de Ingressos: "+ingresso.getQuantidadeIngressos();
				
				listaDeIngressosPorEvento.add(info);
				
			}
			
			pstm.close();
			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaDeIngressosPorEvento;
	}
}
