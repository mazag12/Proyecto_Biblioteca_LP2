package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Departamento;

import db.MysqlDBConexion8;
import interfaces.DepartamentoInterface;


public class MySqlDepartamentoDAO  implements DepartamentoInterface {

	public List<Departamento> getListDepartamento() {
		List<Departamento> listDepartamento = new ArrayList<Departamento>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select dis.coddistrito, dis.nomdistrito, pro.codprovincia, pro.nomprovincia, de.coddepartamento, de.nomdepartamento "
					+ "from Departamento as de "
					+ "Inner Join Provincia as pro "
					+ "on de.coddepartamento = pro.coddepartamento "
					+ "Inner Join Distrito as dis "
					+ "on dis.codprovincia = pro.codprovincia;";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Departamento de = new Departamento(
						rs.getString("coddistrito"),
						rs.getString("nomdistrito"),
						rs.getString("codprovincia"),
						rs.getString("nomprovincia"),
						rs.getString("coddepartamento"),
						rs.getString("nomdepartamento")
						);
		        
				listDepartamento.add(de);

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
		return listDepartamento;
	}

	@Override
	public int createDepartamento(Departamento de) {
		 int value = 0;
			
			Connection cn =  null;
			PreparedStatement psm = null;
			
			try {
				
				cn = MysqlDBConexion8.getConexion();
				
				String sql = "call SP_BIBLIOTECA_INSERTAR_DEPARTAMENTO(?,?)";
				psm = cn.prepareStatement(sql);
			
			
				psm.setString(1, de.getNomdepartamento());
				psm.setString(2, de.getCodpais());

				
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
	public Departamento Departamento(String cod) {
		Departamento de = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select Nomdepartamento From departamento Where coddepartamento = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				de = new Departamento(
						rs.getString("coddistrito"),
						rs.getString("nomdistrito"),
						rs.getString("codprovincia"),
						rs.getString("nomprovincia"),
						rs.getString("coddepartamento"),
						rs.getString("nomdepartamento")
						);
			}else {
				 de = new Departamento(
						"SIN DATO",
						"SIN DATO",
						"SIN DATO",
						"SIN DATO",
						"SIN DATO",
						 "SIN DATO"
						);
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
		return de;
	}

	@Override
	public int editDepartamento(Departamento de) {
     int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_ACTUALIZAR_DEPARTAMENTO(?,?)";
			psm = cn.prepareStatement(sql);
		
			psm.setString(1, de.getCoddepartamento());
			psm.setString(2, de.getNomdepartamento());
			psm.setString(3, de.getCodpais());
			
					
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
	public int removeDepartamento(String cod) {
		   int salida = 0;
			
			Connection cn =  null;
			PreparedStatement psm = null;
			
			try {
				
				cn = MysqlDBConexion8.getConexion();
				
				String sql = "DELETE FROM departamento WHERE CODDEPARTAMENTO=?";
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

	@Override
	public List<Departamento> getDepartamento(String pais) {
		List<Departamento> listDepartamento = new ArrayList<Departamento>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select CODDEPARTAMENTO,NOMDEPARTAMENTO from departamento where CODPAIS = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, pais);
			
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Departamento de = new Departamento(
						"SIN DATO",
						"SIN DATO",
						"SIN DATO",
						"SIN DATO",
						rs.getString("CODDEPARTAMENTO"),
						rs.getString("NOMDEPARTAMENTO")
						);
		        
				listDepartamento.add(de);

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
		return listDepartamento;
	}
	
}
