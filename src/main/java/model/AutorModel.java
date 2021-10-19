package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MySqlDBConexion8;
import entities.Proyecto;

public class AutorModel {

	/*@marco antonio*/
public List<Proyecto> getListProyecto() {
		
		List<Proyecto> listProyecto = new ArrayList<Proyecto>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MySqlDBConexion8.getConexion();
			
			String sql = "call sp_listar_proyecto()";
			pstm = con.prepareCall(sql);
			
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Proyecto pro = new Proyecto();
				pro.setId_Proyecto(rs.getInt("Id_Proyecto"));
				pro.setNom_Proyecto(rs.getString("Nom_Proyecto"));
				pro.setDescrip_Proyecto(rs.getNString("Descrip_Proyecto"));
				pro.setFec_ini_Proyecto(rs.getDate("Fec_ini_Proyecto"));
				pro.setFec_Culmi_Proyecto(rs.getDate("Fec_Culmi_Proyecto"));
				pro.setAsesor_Tecn_Proyecto(rs.getString("Asesor_Tecn_Proyecto"));
				pro.setPresu_Asignado(rs.getDouble("Presu_Asignado"));
				
				listProyecto.add(pro);
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
		return listProyecto;
	}
}
