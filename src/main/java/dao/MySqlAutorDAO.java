package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Autor;
import db.MysqlDBConexion;
import db.MysqlDBConexion8;
import interfaces.AutorInterface;

public class MySqlAutorDAO implements AutorInterface{

	@Override
	public List<Autor> getListAutor() {
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
				Autor au = new Autor(
				rs.getString("Codautor"),
				rs.getString("Nomautor"));
				
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

	@Override
	public int createAutor(Autor au) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_INSERTAR_AUTOR(?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, au.getNomautor());
			
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
	public Autor Autor(String nombre) {
		
		Autor au = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select Codautor,Nomautor From autor Where nomautor = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nombre);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				au = new Autor(
				rs.getString("Codautor"),
				rs.getString("Nomautor"));
			}else {
				au = new Autor("SNDATA","SNDATA");
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
		return au;
	}

	@Override
	public int editAutor(Autor au) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_ACTUALIZAR_AUTOR(?,?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, au.getCodautor());
			psm.setString(2, au.getNomautor());
			
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
	public int removeAutor(String cod) {
		int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "DELETE FROM autor WHERE codautor=?";
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
