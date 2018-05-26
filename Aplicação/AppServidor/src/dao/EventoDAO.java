package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Clientes;
import util.ConexaoBD;

public class EventoDAO {
	private Connection c;
	private PreparedStatement pstm;
	private ResultSet rs;
	private String sql;
	private ArrayList<Clientes> clientes;
	
	public EventoDAO() throws ClassNotFoundException,SQLException{
		c = ConexaoBD.novaConexao();
	}
	
	public ArrayList clientesPorEvento () {
		sql = "Select  from Clientes where ";
		
		return null;
	}
}
