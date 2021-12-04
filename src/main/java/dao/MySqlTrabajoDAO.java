package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Autor;
import beans.Trabajo;
import db.MysqlDBConexion8;
import interfaces.TrabajoInterface;

public class MySqlTrabajoDAO implements TrabajoInterface {

	@Override
public List<Trabajo> getListTrabajo(){
		
		List<Trabajo> listTrabajo = new ArrayList<Trabajo>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * from trabajo";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Trabajo job = new Trabajo();
				job.setCodtrabajo(rs.getString("CodTrabajo"));
				job.setNombre(rs.getString("Nombre"));
				job.setOcupacion(rs.getString("Ocupacion"));
				job.setTelefono(rs.getString("Telefono"));
				
				listTrabajo.add(job);
				
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
		return listTrabajo;
	}

	@Override
	public int createTrabajo(Trabajo tr) {
		int value = 0;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "call sp_insert_job(?,?,?,)";
			pstm = con.prepareCall(sql);
			pstm.setString(1, tr.getNombre());
			pstm.setString(2, tr.getOcupacion());
			pstm.setString(3, tr.getTelefono());
			
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
	public Trabajo getTrabajo(String cod) {
		Trabajo t = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select * from trabajo where nombre=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				t = new Trabajo();
				t.setCodtrabajo(rs.getString("CodTrabajo"));
				t.setNombre(rs.getString("Nombre"));
				t.setOcupacion(rs.getString("Ocupacion"));
				t.setTelefono(rs.getString("Telefono"));
			}else {
				t = new Trabajo();
				t.setCodtrabajo("CodTrabajo");
				t.setNombre("Nombre");
				t.setOcupacion("Ocupacion");
				t.setTelefono("Telefono");
				
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
		return t;
		
	}

	@Override
	public int editTrabajo(Trabajo tr) {
		int value = 0;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "call sp_update_trabajo(?,?,?,?)";
			pstm = con.prepareCall(sql);
			pstm.setString(1, tr.getCodtrabajo());
			pstm.setString(2, tr.getNombre());
			pstm.setString(3, tr.getOcupacion());
			pstm.setString(4, tr.getTelefono());
			
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
	public int removeTrabajo(String cod) {
		int salida = 0;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "delete from trabajo where codtrabajo=?";
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
