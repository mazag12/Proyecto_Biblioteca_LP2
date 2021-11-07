package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Distrito;
import db.MysqlDBConexion8;
import interfaces.DistritoInterface;

public class MySqlDistritoDAO implements DistritoInterface  {

	public List<Distrito> getListDistrito() {
		List<Distrito> listDistrito = new ArrayList<Distrito>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select * From distrito";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Distrito di = new Distrito();
				di.setCoddistrito(rs.getString("coddistrito"));
		        di.setNomdistrito(rs.getString("nomdistrito"));
		        di.setCodprovincia(rs.getString("codprovincia"));
		        
				listDistrito.add(di);
				
				
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
		return listDistrito;
	}

	@Override
	public int createDistrito(beans.Distrito di) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public beans.Distrito Distrito(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editDepartamento(beans.Distrito di) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeDistrito(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}
}
