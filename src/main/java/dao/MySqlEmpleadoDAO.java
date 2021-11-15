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
			
			String sql = "select per.CODPERSON,per.NOMBRES,per.APE_PATERNO,per.APE_MATERNO,per.TIPO_DOC,per.NUM_DOC,per.TELEFONO,per.CELULAR,per.CORREO,per.DIRECCION,per.SEXO, "
					+ "per.NACIONALIDAD,per.EST_CIVIL,em.CODIGOEMPLE,em.CODPERSON,em.CODCARGO "
					+ "from empleado as em "
					+ "inner join persona as per "
					+ "on em.CODPERSON = per.CODPERSON; ";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Empleado emp = new Empleado(
						rs.getString("CODPERSON"),
						rs.getString("NOMBRES"),
						rs.getString("APE_PATERNO"),
						rs.getString("APE_MATERNO"),
						rs.getString("TIPO_DOC"),
						rs.getString("NUM_DOC"),
						rs.getInt("TELEFONO"),
						rs.getInt("CELULAR"),
						rs.getString("CORREO"),
						rs.getString("DIRECCION"),
						rs.getString("SEXO"),
						rs.getString("NACIONALIDAD"),
						rs.getString("EST_CIVIL"),
						rs.getString("CODIGOEMPLE"),
						rs.getString("CODPERSON"),
						rs.getString("CODCARGO")
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
