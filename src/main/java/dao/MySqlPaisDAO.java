package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import beans.Pais;
import db.MysqlDBConexion8;
import interfaces.PaisInterface;

public class MySqlPaisDAO implements PaisInterface{

	
	public List<Pais> getListPais() {
		List<Pais> listPais = new ArrayList<Pais>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select dis.coddistrito, dis.nomdistrito, pro.codprovincia, pro.nomprovincia, de.coddepartamento, de.nomdepartamento, pa.codpais, pa.nompais "
					+ "from Pais as pa Inner Join Departamento as de "
					+ "On pa.codpais = de.codpais "
					+ "Inner Join Provincia as pro "
					+ "on de.coddepartamento = pro.coddepartamento "
					+ "Inner Join Distrito as dis\r\n"
					+ "on dis.codprovincia = pro.codprovincia;";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Pais pa = new Pais(
				rs.getString("coddistrito"),
				rs.getString("nomdistrito"),
				rs.getString("codprovincia"),
				rs.getString("nomprovincia"),
				rs.getString("coddepartamento"),
				rs.getString("nomdepartamento"),
				rs.getString("codpais"),
				rs.getString("nompais")
				);
				
				listPais.add(pa);
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
		return listPais;
	}

	@Override
	public int createPais(Pais pa) {
     int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call SP_BIBLIOTECA_INSERTAR_PAIS(?,?)";
			psm = cn.prepareStatement(sql);
		
			psm.setString(1, pa.getCodpais());
			psm.setString(2, pa.getNompais());
		

			
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
	public Pais Pais(String cod) {
	Pais pa = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select Nompais From pais Where codpais = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				pa = new Pais(cod, sql, cod, sql, cod, sql, cod, sql);
				pa.setCodpais(rs.getString("CodPais"));
				pa.setNompais(rs.getString("Nompais"));
			}else {
				pa = new Pais(cod, sql, cod, sql, cod, sql, cod, sql);
				pa.setCodpais("sndata");
				pa.setNompais("sndata");
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
		return pa;
	}

	@Override
	public int editPais(Pais pa) {
		int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "UPDATE PAIS SET NOMPAIS=upper(?),  WHERE CODPAIS=?";
			psm = cn.prepareStatement(sql);
		
			psm.setString(1, pa.getCodpais());
			psm.setString(2, pa.getNompais());
		
			
					
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
	public int removePais(String cod) {
	int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "DELETE FROM pais WHERE CODPAIS=?";
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
