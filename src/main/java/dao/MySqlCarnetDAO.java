package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Carnet;
import db.MysqlDBConexion8;
import interfaces.CarnetInterface;

public class MySqlCarnetDAO implements CarnetInterface {

	@Override
	public List<Carnet> getListCarnet(){
		
		List<Carnet> listCarnet = new ArrayList<Carnet>();
		
		Connection con  = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * from carnet";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Carnet car = new Carnet();
				car.setNumero(rs.getString("Numero"));
				car.setFecha_emision(rs.getString("Fecha emision"));
				car.setFecha_caducidad(rs.getString("Fecha Caducidad"));
				car.setEstado(rs.getString("Estado"));
				car.setCodcategoria(rs.getString("CodCategoria"));
				
				listCarnet.add(car);
				
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
		return listCarnet;
	
		
	}

	@Override
	public int createCarnet(Carnet car) {
		int value = 0;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql ="call sp_insert_carnet(?,?,?,?)";
			pstm = con.prepareCall(sql);
			pstm.setString(1, car.getFecha_emision());
			pstm.setString(2, car.getFecha_caducidad());
			pstm.setString(3, car.getEstado());
			pstm.setString(4, car.getCodcategoria());
			
			value = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public Carnet getCarnet(String cod) {
		Carnet ca = null;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * from carnet where numero=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				ca = new Carnet();
				ca.setCodcategoria(rs.getString("Número"));
				ca.setFecha_emision(rs.getString("Fecha emision"));
				ca.setFecha_caducidad(rs.getString("Fecha Caducidad"));
				ca.setEstado(rs.getString("Estado"));
				ca.setCodcategoria(rs.getString("Codigo Categoria"));	
			}else {
				ca = new Carnet();
				ca.setNumero("No hay datos");
				ca.setFecha_emision("No hay datos");
				ca.setFecha_caducidad("No hay datos");
				ca.setEstado("No hay datos");
				ca.setCodcategoria("No hay datos");	
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
		return ca;
		
	}

	@Override
	public int editCarnet(Carnet car) {
		int value = 0;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "call sp_update_carnet(?,?,?,?,?)";
			pstm = con.prepareCall(sql);
			pstm.setString(1, car.getNumero());
			pstm.setString(2, car.getFecha_emision());
			pstm.setString(3, car.getFecha_caducidad());
			pstm.setString(4, car.getEstado());
			pstm.setString(5, car.getCodcategoria());
			
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
	public int removeCarnet(String cod) {
		int salida = 0;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "delete from carnet where numero=?";
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
