package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConexaoBD;

public class IngressoDAO {
	
	private String sql;
	private PreparedStatement pstm;
	private Connection c;
	
	public IngressoDAO() throws SQLException, ClassNotFoundException{
		c = ConexaoBD.novaConexao();
	}
	
	public void cadastrarIngresso() {
		
	}
	
	public void RemoverIngresso() {
		
	}
	
	public void BuscarIngresso() {
		
	}
}
