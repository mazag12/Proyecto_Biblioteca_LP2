package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlDBConexion;

import beans.Estudios;
import interfaces.EstudiosInterfaceDAO;


public class MySqlEstudiosDAO implements EstudiosInterfaceDAO {

	@Override
	public List<Estudios> getListEstudios() {
		List<Estudios> listEstudios = new ArrayList<Estudios>();
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
			String sql = "select * from estudios";
			
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			
			while (rs.next()) {
				
				Estudios estudios = new Estudios();
				
				estudios.setCodEstudiante(rs.getString("CODEST"));
				estudios.setNomEstudio(rs.getString("NOMESTUDIO"));
				estudios.setCarrera(rs.getString("CARRERA"));
				estudios.setTelefono(rs.getInt("TELEFONO"));
				estudios.setCelular(rs.getInt("CELULAR"));
				estudios.setDireccion(rs.getString("DIRECCION"));
				estudios.setCodPais(rs.getString("CODPAIS"));
				
				listEstudios.add(estudios);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(rs != null) rs.close();
				if(psm != null) psm.close();
				if(cn != null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listEstudios;
	}

}
