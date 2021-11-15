package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlDBConexion;
import beans.Persona;
import interfaces.PersonaInterfaceDAO;

public class MySqlPersonaDAO implements PersonaInterfaceDAO{

	@Override
	public List<Persona> getListPersona() {
		List<Persona> listPersona = new ArrayList<Persona>();
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "select * from persona";
			
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			
			while (rs.next()) {
				
				Persona perso = new Persona(
					rs.getString("CODPERSON"),
					rs.getString("NOMBRES"),
					rs.getString("APE_PATERNO"),
					rs.getString("APE_MATERNO"),
					rs.getString("TIPO_DOC"),
					rs.getString("NUM_DOC"),
					rs.getInt("TELEFONO"),
					rs.getInt("CELULAR"),
					rs.getString("CORREO"),
					rs.getString("DIRECCION"),
					rs.getString("SEXO"),
					rs.getString("NACIONALIDAD"),
					rs.getString("EST_CIVIL")								
						
				);
				
				listPersona.add(perso);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(rs != null) rs.close();
				if(psm != null) psm.close();
				if(cn != null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listPersona;
	}

}
