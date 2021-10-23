package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlDBConexion8;
import entities.Autor;

public class AutorModel {

	/*@marco antonio*/
public List<Autor> getListProyecto() {
		
		List<Autor> listAutor = new ArrayList<Autor>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select * From autor";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Autor au = new Autor();
				au.setCodautor(rs.getString(0));
				au.setNomautor(rs.getString(1));
				
				listAutor.add(au);
			}
			
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
		return listAutor;
	}
}
