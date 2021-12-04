package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Autor;
import beans.Cargo;
import db.MysqlDBConexion8;
import interfaces.CargoInterface;

public class MySqlCargoDAO implements CargoInterface {

	@Override
public List<Cargo> getListCargo(){
		
		List<Cargo> listCargo = new ArrayList<Cargo>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * from Cargo";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Cargo c = new Cargo();
				c.setCodcargo(rs.getString("CodCargo"));
				c.setDescripcion(rs.getString("Descripcion"));
				
				listCargo.add(c);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(rs != null)rs.close();
				if(pstm != null)pstm.close();
				if(con != null)con.close(); 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return listCargo;		
		
	}

	@Override
	public int createCargo(Cargo ca) {
			int value = 0;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "call usp_insert_cargo(?)";
			pstm = con.prepareCall(sql);
			pstm.setString(1, ca.getDescripcion());
			
			value = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(pstm != null) pstm.close();
				if(con != null) con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}

	@Override
	public Cargo gerCargo(String cod) {
		Cargo c = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select * From cargo Where codcargo = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				c = new Cargo();
				c.setCodcargo(rs.getString("CodCargo"));
				c.setDescripcion(rs.getString("Descripcion"));
			}else {
				c = new Cargo();
				c.setCodcargo("No hay datos");
				c.setDescripcion("No hay datos");
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
		return c;
	}

	@Override
	public int editCargo(Cargo ca) {
				int value = 0;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "call sp_update_cargo(?,?)";
			pstm = con.prepareCall(sql);
			pstm.setString(1, ca.getCodcargo());
			pstm.setString(2, ca.getDescripcion());
			
			value = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(pstm != null) pstm.close();
				if(con != null) con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}

	@Override
	public int removeCargo(String cod) {
			int salida = 0;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		
		try {
			con = MysqlDBConexion8.getConexion();
			
			String sql = "DELETE FROM cargo WHERE codcargo=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(pstm != null) pstm.close();
				if(con != null) con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return salida; 
	}

}
