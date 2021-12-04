package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlDBConexion8;
import beans.Idioma;
import interfaces.IdiomaInterface;

public class MySqlIdiomaDAO implements IdiomaInterface{

	@Override
	public List<Idioma> getListIdioma() {
List<Idioma> listidioma = new ArrayList<Idioma>();
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "select * from idioma";
			
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			
			while (rs.next()) {
				
				Idioma idio = new Idioma();
				
				idio.setCodIdioma(rs.getString("CODIDIOMA"));
				idio.setNomIdioma(rs.getString("NOMIDIOMA"));

				listidioma.add(idio);
				
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
		
		return listidioma;
	}

	@Override
	public int createIdioma(Idioma idio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Idioma Idioma(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editIdioma(Idioma tem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeIdioma(String idio) {
		// TODO Auto-generated method stub
		return 0;
	}

}
