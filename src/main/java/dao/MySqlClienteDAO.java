package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;
import db.MysqlDBConexion8;
import interfaces.ClienteInterface;

public class MySqlClienteDAO implements ClienteInterface {

	@Override
	public List<beans.Cliente> getListCliente() {
		List<Cliente> listCliente = new ArrayList<Cliente>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select * From cliente";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Cliente clint = new Cliente();
				clint.setCodcliente(rs.getString("Codcliente"));
				clint.setCodfamilia(rs.getString("codfamilia"));
				clint.setNumero(rs.getString("numero"));
				clint.setCodtrabajo(rs.getString("codtrabajo"));
				clint.setCodestudio(rs.getString("codestudio"));
				clint.setCodperson(rs.getString("codperson"));
				
				listCliente.add(clint);
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
		return listCliente;
	}

	@Override
	public int createCliente(beans.Cliente cl) {
int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call sp_insert_client(?, ?, ?, ?, ?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, cl.getCodfamilia());
			psm.setString(2, cl.getNumero());
			psm.setString(3, cl.getCodtrabajo());
			psm.setString(4, cl.getCodestudio());
			psm.setString(5, cl.getCodperson());
			
			
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
	public Cliente Cliente(String cod) {
		
		Cliente cl = null;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		
		try {
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * from cliente where codcliente = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				cl = new Cliente();
				cl.setCodcliente(rs.getString("CodCliente"));
				cl.setCodfamilia(rs.getString("CodFamilia"));
				cl.setNumero(rs.getString("Número"));
				cl.setCodtrabajo(rs.getString("CodTrabajo"));
				cl.setCodestudio(rs.getString("CodEstudio"));
				cl.setCodperson(rs.getString("CodPersona"));	
			}else {
				cl = new Cliente();
				cl.setCodcliente("NO DATA");
				cl.setCodfamilia("NO DATA");
				cl.setNumero("NO DATA");
				cl.setCodtrabajo("NO DATA");
				cl.setCodestudio("NO DATA");
				cl.setCodperson("NO DATA");
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
		return cl;
		
	}

	@Override
	public int editCliente(beans.Cliente cl) {
		int value =0;
		
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "call sp_update_client(?,?,?,?,?,?)";
			pstm = con.prepareCall(sql);
			pstm.setString(1, cl.getCodcliente());
			pstm.setString(2, cl.getCodfamilia());
			pstm.setString(3, cl.getNumero());
			pstm.setString(4, cl.getCodtrabajo());
			pstm.setString(5, cl.getCodestudio());
			pstm.setString(6, cl.getCodperson());
			
			value = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				
				if(pstm != null)pstm.close();
				if(con != null)con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public int removeCliente(String cod) {
		int salida = 0;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "delete from cliente where codcliente=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(pstm != null)pstm.close();
				if(con != null)con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return salida;
		
	}
	


}
