package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Categoria_carnet;
import db.MysqlDBConexion8;

public class CategoriaCarnetModel {
	
	public List<Categoria_carnet> getListCategoria_carnet(){
		
		List<Categoria_carnet> listCategoria_carnet = new ArrayList<Categoria_carnet>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "selec * from Categoria_carnet";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Categoria_carnet cat = new Categoria_carnet();
				cat.setCodcategoria(rs.getString("CodCategoria"));
				cat.setDias(rs.getString("Dias"));
				cat.setCantidad(rs.getString("Cantidad"));
				cat.setDescripcion(rs.getString("Descripcion"));
				
				listCategoria_carnet.add(cat);
				
			}
			System.out.println("Lista completada");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(rs != null) rs.close();
				if(pstm != null) pstm.clearBatch();
				if(con != null) con.close();
				
			} catch (Exception e) {
			     e.printStackTrace();
			}
		}
		return listCategoria_carnet;
	}

}
