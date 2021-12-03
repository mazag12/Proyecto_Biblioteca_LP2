package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Autor;
import beans.Formato;
import interfaces.FormatoInterface;

import db.MysqlDBConexion8;

public class MySqlFormatoDAO implements FormatoInterface{

	
	@Override
	public List<Formato> getListFormato() {
		List<Formato> listFormato = new ArrayList<Formato>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select * From formato";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Formato fn = new Formato();
				fn.setCodformato(rs.getString("codformato"));
				fn.setNomformato(rs.getString("nomformato"));
				
				listFormato.add(fn);
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
		return listFormato;
	}

	@Override
	public int createFormato(Formato fn) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_INSERTAR_FORMATO(?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, fn.getNomformato());
			
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
	public Formato Formato(String cod) {
		Formato forma = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select codformato,nomformato From formato Where nomformato = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				forma = new Formato();
				forma.setCodformato(rs.getString("codformato"));
				forma.setNomformato(rs.getString("nomformato"));
			}else {
				forma = new Formato();
				forma.setCodformato("SNDATA");
				forma.setNomformato("SNDATA");
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
		return forma;
	}

	@Override
	public int editFomato(Formato fn) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_ACTUALIZAR_FORMATO(?,?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, fn.getCodformato());
			psm.setString(2, fn.getNomformato());
			
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
	public int removeFormato(String cod) {
		int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "DELETE FROM formato WHERE codformato=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, cod);
			
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
