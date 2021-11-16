package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Tematica;
import db.MysqlDBConexion8;
import interfaces.TematicaInterface;

public class MySqlTematicaDAO implements TematicaInterface{

	@Override
	public List<Tematica> getListTematica() {
		List<Tematica> listTematica = new ArrayList<Tematica>();
		
		Connection con =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select CODTEMATICA, NOMTEMATICA from tematica;";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Tematica pa = new Tematica(
				rs.getString("CODTEMATICA"),
				rs.getString("NOMTEMATICA")
				);
				
				listTematica.add(pa);
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
		return listTematica;
	}

	@Override
	public int createTematica(Tematica tem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tematica Formato(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editTematica(Tematica tem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeTematica(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
