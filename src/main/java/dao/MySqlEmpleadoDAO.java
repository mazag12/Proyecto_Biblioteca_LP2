package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Empleado;
import db.MysqlDBConexion8;
import interfaces.EmpleadoInterface;

public class MySqlEmpleadoDAO implements EmpleadoInterface {

	@Override
	public List<Empleado> getListEmpleado() {
		List<Empleado> listEmpleado = new ArrayList<Empleado>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
		
			String sql = "select * from empleado";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Empleado j = new Empleado();
						j.setCodigoemple(rs.getString("CodigoEmple"));
						j.setCodperson(rs.getString("CodPerson"));
						j.setCodcargo(rs.getString("CodCargo"));
							
						listEmpleado.add(j);
				
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
		return listEmpleado;
	}

	@Override
	public int createEmpleado(Empleado di) {
		int value = 0;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			
			 con = MysqlDBConexion8.getConexion();
			 
			 String sql = "call sp_insert_empleado(?,?)";
			 pstm = con.prepareCall(sql);
			 pstm.setString(1, di.getCodperson());
			 pstm.setString(2, di.getCodcargo());
			
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
	public Empleado getEmpleado(String cod) {
		 Empleado j = null;
		 
		 Connection con =  null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				
				con = MysqlDBConexion8.getConexion();
				
				String sql = "select * from empleado where codigoemple=?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, cod);
				
				rs = pstm.executeQuery();
				if(rs.next()) {
					j = new Empleado();
					j.setCodigoemple(rs.getString("Codigoemple"));
					j.setCodperson(rs.getString("CodPerson"));
					j.setCodcargo(rs.getString("CodCargo"));
				}else {
					j = new Empleado();
					j.setCodigoemple("No hay datos");
					j.setCodperson("No hay datos");
					j.setCodcargo("No hay datos");
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
			return j;
	}

	@Override
	public int editEmpleado(Empleado di) {
			int value = 0;
			
	
			Connection con =  null;
			PreparedStatement pstm = null;
			try {
				
				con = MysqlDBConexion8.getConexion();
				
				String sql = "call sp_update_empleado(?,?,?)";
				pstm = con.prepareCall(sql);
				pstm.setString(1, di.getCodigoemple());
				pstm.setString(2, di.getCodperson());
				pstm.setString(3, di.getCodcargo());
				
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
	public int removeEmpleado(String cod) {
		int salida = 0;
		

		Connection con =  null;
		PreparedStatement pstm = null;
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "delete from empleado where codigoemple=?";
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
