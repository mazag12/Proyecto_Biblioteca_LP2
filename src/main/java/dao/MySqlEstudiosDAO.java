package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlDBConexion8;

import beans.Estudios;
import interfaces.EstudiosInterfaceDAO;


public class MySqlEstudiosDAO implements EstudiosInterfaceDAO {

	@Override
	public List<Estudios> getListEstudios() {
		List<Estudios> listEstudios = new ArrayList<Estudios>();
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "select * from estudios";
			
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			
			while (rs.next()) {
				
				Estudios estudios = new Estudios();
				
				estudios.setCodEstudiante(rs.getString("CODEST"));
				estudios.setNomEstudio(rs.getString("NOMESTUDIO"));
				estudios.setCarrera(rs.getString("CARRERA"));
				estudios.setTelefono(rs.getInt("TELEFONO"));
				estudios.setCelular(rs.getInt("CELULAR"));
				estudios.setDireccion(rs.getString("DIRECCION"));
				estudios.setCodPais(rs.getString("CODPAIS"));
				
				listEstudios.add(estudios);
				
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
		
		return listEstudios;
	}
	
	@Override
	public int createEstudios(Estudios estu) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "call SP_BIBLIOTECA_INSERTAR_ESTUDIOS(?,?,?,?,?,?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, estu.getNomEstudio());
			psm.setString(2, estu.getCarrera());
			psm.setInt(3, estu.getTelefono());
			psm.setInt(4, estu.getCelular());
			psm.setString(5, estu.getDireccion());
			psm.setString(6, estu.getCodPais());
						
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
	public Estudios getEstudios(String id) {
		Estudios estudios = null;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "SELECT * FROM estudios WHERE CODEST=?";
			
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			
			rs = psm.executeQuery();
			
			if(rs.next()) {
				
				estudios = new Estudios();
				estudios.setCodEstudiante(rs.getString("CODEST"));
				estudios.setNomEstudio(rs.getString("NOMESTUDIO"));
				estudios.setCarrera(rs.getString("CARRERA"));
				estudios.setTelefono(rs.getInt("TELEFONO"));
				estudios.setCelular(rs.getInt("CELULAR"));
				estudios.setDireccion(rs.getString("DIRECCION"));
				estudios.setCodPais(rs.getString("CODPAIS"));
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
		
		return estudios;
	}

	@Override
	public int editEstudios(Estudios estu) {
			int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "UPDATE estudios SET NOMESTUDIO=upper(?), CARRERA=upper(?), TELEFONO=?, CELULAR=?, DIRECCION=upper(?), CODPAIS=upper(?)    WHERE CODEST=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, estu.getNomEstudio());
			psm.setString(2, estu.getCarrera());
			psm.setInt(3, estu.getTelefono());
			psm.setInt(4, estu.getCelular());
			psm.setString(5, estu.getDireccion());
			psm.setString(6, estu.getCodPais());
			psm.setString(7, estu.getCodEstudiante());
			
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
	public int removeEstudios(String id) {
		int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "DELETE FROM estudios WHERE CODEST=?";
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
