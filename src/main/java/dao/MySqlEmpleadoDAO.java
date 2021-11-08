package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Empleado;
import db.MysqlDBConexion8;
import interfaces.EmpleadoInterface;

public class MySqlEmpleadoDAO implements EmpleadoInterface {

	@Override
	public List<Empleado> getListEmpleado() {
		List<Empleado> listEmpleado = new ArrayList<Empleado>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select codigoemple, codperson, codcargo From Empleado";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Empleado emp = new Empleado(
						rs.getString("codigoemple"),
						rs.getString("codperson"),
						rs.getString("codcargo")
						);
				
				listEmpleado.add(emp);
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
		return listEmpleado;
	}

	@Override
	public int createEmpleado(Empleado di) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Empleado getEmpleado(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editDepartamento(Empleado di) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeEmpleado(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
