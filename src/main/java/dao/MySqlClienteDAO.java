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
			
			String sql = "INSERT INTO cliente VALUES(?, ?, ?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, cl.getCodcliente());
			psm.setString(2, cl.getCodfamilia());
			psm.setString(3, cl.getNumero());
			psm.setString(4, cl.getCodtrabajo());
			psm.setString(5, cl.getCodestudio());
			psm.setString(6, cl.getCodperson());
			
			
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
	public beans.Cliente Cliente(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editCliente(beans.Cliente cl) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCliente(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}


}
