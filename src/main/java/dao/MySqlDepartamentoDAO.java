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
	public int createDepartamento(beans.Departamento de) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public beans.Departamento Departamento(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editDepartamento(beans.Departamento de) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeDepartamento(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}
}
