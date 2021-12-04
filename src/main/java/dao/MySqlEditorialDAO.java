package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Editorial;
import db.MysqlDBConexion8;
import interfaces.EditorialInterface;

public class MySqlEditorialDAO implements EditorialInterface{

	@Override
	public List<Editorial> getListEditorial() {
		List<Editorial> listEditorial = new ArrayList<Editorial>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select CODEDITORIAL, NOMEDITORIAL from editorial;";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Editorial pa = new Editorial(
				rs.getString("CODEDITORIAL"),
				rs.getString("NOMEDITORIAL")
				);
				
				listEditorial.add(pa);
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
		return listEditorial;
	}

	@Override
	public int createEditorial(Editorial ed) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_INSERTAR_EDITORIAL(?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, ed.getNomEditorial());
			
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
	public Editorial Editorial(String cod) {
		Editorial ed = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select Codautor,Nomautor From autor Where nomautor = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				ed = new Editorial(
				rs.getString("Codautor"),
				rs.getString("Nomautor"));
			}else {
				ed = new Editorial("SNDATA","SNDATA");
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
		return ed;
	}

	@Override
	public int editEditorial(Editorial ed) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_ACTUALIZAR_EDITORIAL(?,?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, ed.getCodEditorial());
			psm.setString(2, ed.getNomEditorial());
			
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
	public int removeEditorial(String cod) {
		int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "DELETE FROM editorial WHERE CODEDITORIAL=?";
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
