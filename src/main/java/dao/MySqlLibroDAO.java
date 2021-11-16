package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Libro;
import db.MysqlDBConexion8;
import interfaces.LibroInterface;

public class MySqlLibroDAO implements LibroInterface{

	@Override
	public List<Libro> getListLibro() {
		List<Libro> listLibro = new ArrayList<Libro>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select codlibro,titulo,año,codidioma,codtematica,codeditorial,restrinccion,paginas,cantidad,fragmento,recomendados,codformato,codpais,estado,isbn "
					+ "From libro";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Libro libro = new Libro(
				rs.getString("codlibro"),
				rs.getString("titulo"),
				rs.getString("año"),
				rs.getString("codidioma"),
				rs.getString("codtematica"),
				rs.getString("codeditorial"),
				rs.getString("restrinccion"),
				rs.getInt("paginas"),
				rs.getInt("cantidad"),
				rs.getString("fragmento"),
				rs.getString("recomendados"),
				rs.getString("codformato"),
				rs.getString("codpais"),
				rs.getString("estado"),
				rs.getString("isbn")
				);
				
				listLibro.add(libro);
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
		return listLibro;
	}

	@Override
	public int createLibro(Libro pa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Libro getLibro(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editLibro(Libro pa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeLibro(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
