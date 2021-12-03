package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Carnet;
import db.MysqlDBConexion8;

public class CarnetModel {
	
	public List<Carnet> getListCarnet(){
		
		List<Carnet> listCarnet = new ArrayList<Carnet>();
		
		Connection con  = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * from carnet";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Carnet car = new Carnet();
				car.setNumero(rs.getString("Numero"));
				car.setFecha_emision(rs.getString("Fecha emision"));
				car.setFecha_caducidad(rs.getString("Fecha Caducidad"));
				car.setEstado(rs.getString("Estado"));
				car.setCodcategoria(rs.getString("CodCategoria"));
				
				listCarnet.add(car);
				
			}
			
			System.out.println("Lista completada");
			
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
		return listCarnet;
	}

}
