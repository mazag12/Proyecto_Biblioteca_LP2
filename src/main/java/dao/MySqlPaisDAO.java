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
