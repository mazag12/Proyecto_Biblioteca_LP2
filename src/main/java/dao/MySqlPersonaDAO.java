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
				
				Persona perso = new Persona();
				
				perso.setCodPersona(rs.getString("CODPERSON"));
				perso.setNombre(rs.getString("NOMBRES"));
				perso.setApePaterno(rs.getString("APE_PATERNO"));
				perso.setApeMaterno(rs.getString("APE_MATERNO"));
				perso.setTipoDoc(rs.getString("TIPO_DOC"));
				perso.setNumDoc(rs.getString("NUM_DOC"));
				perso.setTelefono(rs.getInt("TELEFONO"));
				perso.setCelular(rs.getInt("CELULAR"));
				perso.setCorreo(rs.getString("CORREO"));
				perso.setDireccion(rs.getString("DIRECCION"));
				perso.setSexo(rs.getString("SEXO"));
				perso.setNacionalidad(rs.getString("NACIONALIDAD"));
				perso.setEstadoCivil(rs.getString("EST_CIVIL"));
				
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
