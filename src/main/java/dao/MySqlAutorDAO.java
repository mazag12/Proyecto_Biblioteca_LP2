package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Autor;
import db.MysqlDBConexion8;
import interfaces.AutorInterface;

public class MySqlAutorDAO implements AutorInterface{

	@Override
	public List<Autor> getListAutor() {
		List<Autor> listAutor = new ArrayList<Autor>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select * From autor";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Autor au = new Autor();
				au.setCodautor(rs.getString("Codautor"));
				au.setNomautor(rs.getString("Nomautor"));
				
				listAutor.add(au);
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
		return listAutor;
	}

	@Override
	public int createAutor(beans.Autor au) {
		int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "INSERT INTO autor VALUES(?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, au.getCodautor());
			psm.setString(2, au.getNomautor());
			
			value = psm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(psm != null) psm.close();
				if(cn != null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}

	@Override
	public beans.Autor Autor(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editAutor(beans.Autor au) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAutor(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
