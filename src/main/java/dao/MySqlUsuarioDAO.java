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
	public List<Usuario> getListUsuario() {
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "select usernombre, rol from usuario;";
			
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			
			while (rs.next()) {
				
				Usuario usuario = new Usuario(
						rs.getString("usernombre"), 
						rs.getString("rol"));
				
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
	public Usuario verifyAuthModel(String nombre, String password) {
		
		Usuario usuario = null;
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "select usernombre, rol from usuario where usernombre = ? and usercontra = ?;";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nombre);
			pstm.setString(2, password);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				// String nombre, String apellidos, String id, String rol, String email
				usuario = new Usuario(
						rs.getString("usernombre"), 
						rs.getString("rol"));
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
