package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Editorial;
import db.MysqlDBConexion8;
import interfaces.EditorialInterface;

public class MySqlEditorialDAO implements EditorialInterface{

	@Override
	public List<Editorial> getListEditorial() {
		List<Editorial> listEditorial = new ArrayList<Editorial>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select CODEDITORIAL, NOMEDITORIAL from editorial;";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Editorial pa = new Editorial(
				rs.getString("CODEDITORIAL"),
				rs.getString("NOMEDITORIAL")
				);
				
				listEditorial.add(pa);
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
		return listEditorial;
	}

	@Override
	public int createEditorial(Editorial tem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Editorial Editorial(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editEditorial(Editorial tem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeEditorial(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
