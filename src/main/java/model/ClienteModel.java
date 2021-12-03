package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;
import db.MysqlDBConexion8;

public class ClienteModel {

public List<Cliente> getListCliente(){
	
	List<Cliente> listCliente = new ArrayList<Cliente>();
	
	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	try {
		
		con = MysqlDBConexion8.getConexion();
		
		String sql = "Select * from cliente";
		
		pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		while (rs.next()) {
			Cliente cl = new Cliente();
			cl.setCodcliente(rs.getString("CodCliente"));
			cl.setCodfamilia(rs.getString("CodFamilia"));
			cl.setNumero(rs.getString("Numero"));
			cl.setCodtrabajo(rs.getString("CodTrabajo"));
			cl.setCodestudio(rs.getString("CodEstudio"));
			cl.setCodperson(rs.getString("CodPerson"));
			
			listCliente.add(cl);
			
		}
		
		System.out.println("Lista completa");
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	finally {
		try {
			if(rs != null) rs.close();
			if(pstm != null) pstm.close();
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	return listCliente;
}
	
	
}
