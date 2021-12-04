package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import beans.Provincia;
import db.MysqlDBConexion8;
import interfaces.ProvinciaInterface;


public class MySqlProvinciaDAO implements ProvinciaInterface {

	
	public List<Provincia> getListProvincia() {
		List<Provincia> listProvincia = new ArrayList<Provincia>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select dis.coddistrito, dis.nomdistrito, pro.codprovincia, pro.nomprovincia "
					+ "from Provincia as pro "
					+ "Inner Join Distrito as dis "
					+ "on dis.codprovincia = pro.codprovincia;";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Provincia pr = new Provincia(
						rs.getString("coddistrito"),
						rs.getString("nomdistrito"),
						rs.getString("codprovincia"),
						rs.getString("nomprovincia")
				);
		        
				listProvincia.add(pr);
				
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
		return listProvincia;
	}

	@Override
	public int createProvincia(Provincia pr) {
		  int value = 0;
			
			Connection cn =  null;
			PreparedStatement psm = null;
			
			try {
				
				cn = MysqlDBConexion8.getConexion();
				
				String sql = "call SP_BIBLIOTECA_INSERTAR_PROVINCIA(?,?)";
				psm = cn.prepareStatement(sql);
			
				psm.setString(1, pr.getCodprovincia());
				psm.setString(2, pr.getNomprovincia());
			

				
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
	public Provincia Provincia(String cod) {
      Provincia pro = null;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select Nomprovincia From provincia Where codprovincia = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				pro = new Provincia(cod, sql, cod, sql);
				pro.setCodprovincia(rs.getString("Codprovincia"));
				pro.setNomprovincia(rs.getString("Nomprovincia"));
			}else {
				pro = new Provincia(cod, sql, cod, sql);
				pro.setCodprovincia("sndata");
				pro.setNomprovincia("sndata");
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
		return pro;
	}

	@Override
	public int editProvincia(Provincia pr) {
      int salida = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "UPDATE provincia SET NOMprovincia upper(?),  WHERE CODprovincia=?";
			psm = cn.prepareStatement(sql);
		
			psm.setString(1, pr.getCodprovincia());
			psm.setString(2, pr.getNomprovincia());
		
			
					
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
	public int removeProvincia(String cod) {
		   int salida = 0;
			
			Connection cn =  null;
			PreparedStatement psm = null;
			
			try {
				
				cn = MysqlDBConexion8.getConexion();
				
				String sql = "DELETE FROM provincia WHERE CODPROVINCIA=?";
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
