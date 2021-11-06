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
			
			String sql = "Select * From pais";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Pais pa = new Pais();
				pa.setCodpais(rs.getString("codpais"));
		        pa.setNompais(rs.getString("nompais"));
				
				listPais.add(pa);
			}
			
			System.out.println("Lista completada ");
			
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
	public int createPais(beans.Pais pa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public beans.Pais Pais(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editPais(beans.Pais pa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removePais(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}
}
