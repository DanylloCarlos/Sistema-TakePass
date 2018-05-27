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
	
	public EventoDAO() throws ClassNotFoundException,SQLException{
		c = ConexaoBD.novaConexao();
	}
	
	public void cadastrarEvento(String nomeDoEvento, int qtdIngressos, int idCliente) throws SQLException{
		
		sql = "Insert into Eventos(nomeEvento, qtdIngressos)"
				+ " values (?, ?)";
		
		pstm = c.prepareStatement(sql);
		pstm.setString(1, nomeDoEvento);
		pstm.setInt(2, qtdIngressos);
		
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
	
	public ArrayList<Clientes> listarClientesPorEvento(int codigoDeAcesso) throws SQLException{
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