package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Trabajo;
import db.MysqlDBConexion8;

public class TrabajoModel {
	
	public List<Trabajo> getListTrabajo(){
		
		List<Trabajo> listTrabajo = new ArrayList<Trabajo>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * from trabajo";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Trabajo job = new Trabajo();
				job.setCodtrabajo(rs.getString("CodTrabajo"));
				job.setNombre(rs.getString("Nombre"));
				job.setOcupacion(rs.getString("Ocupacion"));
				job.setTelefono(rs.getString("Telefono"));
				
				listTrabajo.add(job);
				
			}
			
			System.out.println("Lista completada");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(rs != null)rs.close();
				if(pstm != null)pstm.close();
				if(con != null)con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listTrabajo;
	}

}
