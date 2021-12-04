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
	
	@Override
	public int createPersona(Persona perso) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "call SP_BIBLIOTECA_INSERTAR_PERSONA(?,?,?,?,?,?,?,?,?,?,?,?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, perso.getNombre());
			psm.setString(2, perso.getApePaterno());
			psm.setString(3, perso.getApeMaterno());
			psm.setString(4, perso.getTipoDoc());
			psm.setString(5, perso.getNumDoc());
			psm.setInt(6, perso.getTelefono());
			psm.setInt(7, perso.getCelular());
			psm.setString(8, perso.getCorreo());
			psm.setString(9, perso.getDireccion());
			psm.setString(10, perso.getSexo());
			psm.setString(11, perso.getNacionalidad());
			psm.setString(12, perso.getEstadoCivil());

			
			value = psm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(psm != null) psm.close();
				if(cn != null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}

	@Override
	public Persona getPersona(String id) {
		Persona persona = null;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "SELECT * FROM persona WHERE CODPERSON=?";
			
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			
			rs = psm.executeQuery();
			
			if(rs.next()) {
				
				persona = new Persona();
				persona.setCodPersona(rs.getString("CODPERSON"));
				persona.setNombre(rs.getString("NOMBRES"));
				persona.setApePaterno(rs.getString("APE_PATERNO"));
				persona.setApeMaterno(rs.getString("APE_MATERNO"));
				persona.setTipoDoc(rs.getString("TIPO_DOC"));
				persona.setNumDoc(rs.getString("NUM_DOC"));
				persona.setTelefono(rs.getInt("TELEFONO"));
				persona.setCelular(rs.getInt("CELULAR"));
				persona.setCorreo(rs.getString("CORREO"));
				persona.setDireccion(rs.getString("DIRECCION"));
				persona.setSexo(rs.getString("SEXO"));
				persona.setNacionalidad(rs.getString("NACIONALIDAD"));
				persona.setEstadoCivil(rs.getString("EST_CIVIL"));
				
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
		
		return persona;
	}

	@Override
	public int editPersona(Persona perso) {
			int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "UPDATE persona SET NOMBRES=upper(?), APE_PATERNO=upper(?),APE_MATERNO=upper(?),TIPO_DOC=UPPER(?),"
					+ "NUM_DOC=?,TELEFONO=?,CELULAR=?,CORREO=?, DIRECCION=upper(?),SEXO=UPPER(?),NACIONALIDAD=UPPER(?),EST_CIVIL=?   WHERE CODPERSON=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, perso.getNombre());
			psm.setString(2, perso.getApePaterno());
			psm.setString(3, perso.getApeMaterno());
			psm.setString(4, perso.getTipoDoc());
			psm.setString(5, perso.getNumDoc());
			psm.setInt(6, perso.getTelefono());
			psm.setInt(7, perso.getCelular());
			psm.setString(8, perso.getCorreo());
			psm.setString(9, perso.getDireccion());
			psm.setString(10, perso.getSexo());
			psm.setString(11, perso.getNacionalidad());
			psm.setString(12, perso.getEstadoCivil());
			psm.setString(13, perso.getCodPersona());
					
			salida = psm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(psm != null) psm.close();
				if(cn != null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public int removePersona(String id) {
		int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "DELETE FROM persona WHERE CODPERSON=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			
			salida = psm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(psm != null) psm.close();
				if(cn != null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return salida; 
	}
	

}
