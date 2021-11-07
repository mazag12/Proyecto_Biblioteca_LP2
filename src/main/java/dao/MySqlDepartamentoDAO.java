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
			
			String sql = "Select * From departamento";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Departamento de = new Departamento();
				de.setCoddepartamento(rs.getString("coddepartamento"));
		        de.setNomdepartamento(rs.getString("nomdepartamento"));
		        de.setCodpais(rs.getString("codpais"));
		        
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
