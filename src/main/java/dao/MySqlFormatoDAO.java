package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Formato;
import interfaces.FormatoInterface;

import db.MysqlDBConexion8;

public class MySqlFormatoDAO implements FormatoInterface{

	
	@Override
	public List<Formato> getListFormato() {
		List<Formato> listFormato = new ArrayList<Formato>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "Select * From formato";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Formato fn = new Formato();
				fn.setCodformato(rs.getString("codformato"));
				fn.setNomformato(rs.getString("nomformato"));
				
				listFormato.add(fn);
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
		return listFormato;
	}

	@Override
	public int createFormato(beans.Formato fn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public beans.Formato Formato(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editFomato(beans.Formato fn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeFormato(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
