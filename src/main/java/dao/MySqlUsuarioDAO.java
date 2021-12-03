package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import db.MysqlDBConexion8;
import interfaces.UsuarioInterface;

public class MySqlUsuarioDAO implements UsuarioInterface{

	@Override
	public List<beans.Usuario> getListUsuario() {
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "select per.CODPERSON,per.NOMBRES,per.APE_PATERNO,per.APE_MATERNO,per.TIPO_DOC,per.NUM_DOC,per.TELEFONO,per.CELULAR,per.CORREO,per.DIRECCION,per.SEXO, "
					+ "per.NACIONALIDAD,per.EST_CIVIL,em.CODIGOEMPLE,em.CODPERSON,em.CODCARGO, us.usercodigo, us.usernombre "
					+ "from empleado as em "
					+ "inner join persona as per "
					+ "on em.CODPERSON = per.CODPERSON "
					+ "inner join usuario as us "
					+ "on us.codempleado = em.CODIGOEMPLE";
			
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			
			while (rs.next()) {
				
				Usuario usuario = new Usuario(
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
						rs.getString("CODCARGO"),
						rs.getInt("usercodigo"),
						rs.getString("usernombre")
				);
				
				listUsuario.add(usuario);
				
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
		
		return listUsuario;
	}

	@Override
	public int createAutor(beans.Usuario asu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public beans.Usuario Usuario(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editUsuario(beans.Usuario asu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeUsuario(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public beans.Usuario verifyAuthModel(String nombre, String password) {
		Usuario usuario = null;
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "select per.CODPERSON,per.NOMBRES,per.APE_PATERNO,per.APE_MATERNO,per.TIPO_DOC,per.NUM_DOC,per.TELEFONO,per.CELULAR,per.CORREO,per.DIRECCION,per.SEXO, "
					+ "per.NACIONALIDAD,per.EST_CIVIL,em.CODIGOEMPLE,em.CODPERSON,em.CODCARGO, us.usercodigo, us.usernombre "
					+ "from empleado as em "
					+ "inner join persona as per "
					+ "on em.CODPERSON = per.CODPERSON "
					+ "inner join usuario as us "
					+ "on us.codempleado = em.CODIGOEMPLE "
					+ "where us.usernombre = ? and us.usercontra=?; ";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nombre);
			pstm.setString(2, password);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				// String nombre, String apellidos, String id, String rol, String email
					usuario = new Usuario(
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
						rs.getString("CODCARGO"),
						rs.getInt("usercodigo"),
						rs.getString("usernombre")
				);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(rs!=null) rs.close(); 
				if(pstm!=null) pstm.close(); 
				if(cn!=null) cn.close(); 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return usuario;
	}

}
