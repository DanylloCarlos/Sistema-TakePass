package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Eventos;
import modelo.Ingressos;
import util.ConexaoBD;

public class IngressoDAO {
	
	private String sql;
	private PreparedStatement pstm;
	private ResultSet rs;
	private Connection c;
	private ArrayList<String> listaDeIngressosPorEvento;
	
	
	public IngressoDAO() throws SQLException, ClassNotFoundException{
		c = ConexaoBD.novaConexao();
	}
	
	public void cadastrarIngresso(int qtdDisp, String descricao) throws SQLException{
		
		String sql = "Insert into Ingressos (qtdDisp, descricao) values (?,?)";
		
		pstm = c.prepareStatement(sql);
		pstm.setInt(1, qtdDisp);
		pstm.setString(2, descricao);
		pstm.executeUpdate();
		
		pstm.close();
		c.close();
		
	}
	
	public void RemoverIngresso(Ingressos i) throws SQLException{
		
		String sql = "Delete from Ingressos i where i.idIngresso= ?";
		
		pstm= c.prepareStatement(sql);
		pstm.setInt(1, i.getIdIngresso());
		pstm.execute();
		
		pstm.close();
		c.close();
		
	}
	
	public void buscarIngresso(int idIngresso) throws SQLException{
		Ingressos i = new Ingressos();
		
		String sql = "Select * from Ingressos i where i.idIngresso= ?";
		
		pstm = c.prepareStatement(sql);
		pstm.setInt(1, idIngresso);
		pstm.execute();
		
		pstm.close();
		c.close();
		
	}
}
