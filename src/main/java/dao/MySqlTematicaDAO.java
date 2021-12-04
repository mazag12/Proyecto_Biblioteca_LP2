package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Tematica;
import db.MysqlDBConexion8;
import interfaces.TematicaInterface;

public class MySqlTematicaDAO implements TematicaInterface{

	@Override
	public List<Tematica> getListTematica() {
		List<Tematica> listTematica = new ArrayList<Tematica>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select CODTEMATICA, NOMTEMATICA from tematica;";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Tematica pa = new Tematica(
				rs.getString("CODTEMATICA"),
				rs.getString("NOMTEMATICA")
				);
				
				listTematica.add(pa);
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
		return listTematica;
	}

	@Override
	public int createTematica(Tematica tem) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_INSERTAR_TEMATICA(?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, tem.getNomTematica());
			
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
	public Tematica Tematica(String cod) {
		Tematica te = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select CODTEMATICA,NOMTEMATICA From tematica Where NOMTEMATICA = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				te = new Tematica(
				rs.getString("Codautor"),
				rs.getString("Nomautor"));
			}else {
				te = new Tematica("SNDATA","SNDATA");
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
		return te;
	}

	@Override
	public int editTematica(Tematica tem) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_ACTUALIZAR_TEMATICA(?,?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, tem.getCodTematica());
			psm.setString(2, tem.getNomTematica());
			
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
	public int removeTematica(String cod) {
		int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "DELETE FROM tematica WHERE CODTEMATICA=?";
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
