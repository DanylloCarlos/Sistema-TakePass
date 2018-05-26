package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Ingressos;
import util.ConexaoBD;

public class IngressoDAO {
	
	private String sql;
	private PreparedStatement pstm;
	private Connection c;
	
	
	public IngressoDAO() throws SQLException, ClassNotFoundException{
		c = ConexaoBD.novaConexao();
	}
	
	public void cadastrarIngresso(int qtdDisp, String descricao) throws SQLException{
		
		String sql = "Insert into Ingresso (qtdDisp, descricao) values (?,?)";
		
		pstm = c.prepareStatement(sql);
		pstm.setInt(1, qtdDisp);
		pstm.setString(2, descricao);
		pstm.execute();
		
	}
	
	public void RemoverIngresso(Ingressos i) throws SQLException{
		
		String sql = "Delete from Ingresso i where i.idIngresso= ?";
		
		pstm= c.prepareStatement(sql);
		pstm.setInt(1, i.getIdIngresso());
		pstm.execute();
		
	}
	
	public void BuscarIngresso(int idIngresso) throws SQLException{
		Ingressos i = new Ingressos();
		
		String sql = "Select * from Ingressos i where i.idIngresso= ?";
		
		pstm = c.prepareStatement(sql);
		pstm.setInt(1, idIngresso);
		pstm.execute();
		
	}
}
