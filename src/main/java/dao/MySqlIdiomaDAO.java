package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlDBConexion8;
import beans.Idioma;
import interfaces.IdiomaInterface;

public class MySqlIdiomaDAO implements IdiomaInterface{

	@Override
	public List<Idioma> getListIdioma() {
		List<Idioma> listidioma = new ArrayList<Idioma>();
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "select * from idioma";
			
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			
			while (rs.next()) {
				
				Idioma idio = new Idioma();
				
				idio.setCodIdioma(rs.getString("CODIDIOMA"));
				idio.setNomIdioma(rs.getString("NOMIDIOMA"));

				listidioma.add(idio);
				
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
		
		return listidioma;
	}

	@Override
	public int createIdioma(Idioma idio) {
		
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "call 	SP_BIBLIOTECA_INSERTAR_IDIOMA(?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, idio.getNomIdioma());

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
	public Idioma getIdioma(String id) {
		Idioma idioma = null;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "SELECT * FROM idioma WHERE CODIDIOMA=?";
			
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			
			rs = psm.executeQuery();
			
			if(rs.next()) {
				
				idioma = new Idioma();
				idioma.setCodIdioma(rs.getString("CODIDIOMA"));

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
		
		return idioma;
	}

	@Override
	public int editIdioma(Idioma idio) {

		int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "update idioma set NOMIDIOMA = ? where CODIDIOMA=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, idio.getNomIdioma());
			psm.setString(2, idio.getCodIdioma());

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
			
			String sql = "DELETE FROM idioma WHERE CODIDIOMA=?";
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
