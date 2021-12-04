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
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_INSERTAR_IDIOMA(?)";
			psm = cn.prepareCall(sql);
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
	public Idioma getIdioma(String cod) {
		Idioma idio = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select CODIDIOMA,NOMIDIOMA From idioma Where NOMIDIOMA = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				idio = new Idioma();
				idio.setCodIdioma(rs.getString("CODIDIOMA"));
				idio.setNomIdioma(rs.getString("NOMIDIOMA"));
			}else {
				idio = new Idioma();
				idio.setCodIdioma("SNDATA");
				idio.setNomIdioma("SNDATA");
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
		return idio;
	}

	@Override
	public int editIdioma(Idioma idio) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_ACTUALIZAR_IDIOMA(?,?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, idio.getCodIdioma());
			psm.setString(2, idio.getNomIdioma());
			
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
	public int removeIdioma(String idio) {
		int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "DELETE FROM idioma WHERE CODIDIOMA=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, idio);
			
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
