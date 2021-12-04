package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Distrito;

import db.MysqlDBConexion8;
import interfaces.DistritoInterface;

public class MySqlDistritoDAO implements DistritoInterface  {

	public List<Distrito> getListDistrito() {
		List<Distrito> listDistrito = new ArrayList<Distrito>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select * From distrito";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Distrito di = new Distrito(
					rs.getString("coddistrito"),
					rs.getString("nomdistrito")
				);
				
		        
				listDistrito.add(di);
				
				
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
		return listDistrito;
	}

	@Override
	public int createDistrito(Distrito di) {
     int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_INSERTAR_DISTRITO(?,?)";
			psm = cn.prepareStatement(sql);
		
			psm.setString(1, di.getCoddistrito());
			psm.setString(2, di.getNomdistrito());
		

			
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
	public Distrito Distrito(String cod) {
	Distrito di = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select nomdistrito From distrito Where coddistrito = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				di = new Distrito(cod, sql);
				di.setCoddistrito(rs.getString("Coddistrito"));
				di.setNomdistrito(rs.getString("Nomdistrito"));
			}else {
				di = new Distrito(cod, sql);
				di.setCoddistrito("SNDATA");
				di.setNomdistrito("SNDATA");
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
		return di;
	}

	@Override
	public int editDistrito(Distrito di) {
	int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "UPDATE DISTRITO SET NOMDISTRITO=upper(?),  WHERE CODDISTRITO=?";
			psm = cn.prepareStatement(sql);
		
			psm.setString(1, di.getCoddistrito());
			psm.setString(2, di.getNomdistrito());
		
			
					
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
	public int removeDistrito(String cod) {
    int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "DELETE FROM distrito WHERE CODDISTRITO=?";
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
