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
			
			String sql = "Select * From provincia";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Provincia pr = new Provincia();
				pr.setCodprovincia(rs.getString("codprovincia"));
		        pr.setNomprovincia(rs.getString("nomprovincia"));
		        pr.setCoddepartamento(rs.getString("coddepartamento"));
		        
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Provincia Departamento(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editProvincia(Provincia pr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeProvincia(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
