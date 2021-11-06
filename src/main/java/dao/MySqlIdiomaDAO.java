package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlDBConexion;
import beans.Idioma;
import interfaces.IdiomaInterfaceDAO;

public class MySqlIdiomaDAO implements IdiomaInterfaceDAO{

	@Override
	public List<Idioma> getListIdiomas() {
		
		List<Idioma> listidioma = new ArrayList<Idioma>();
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			
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

}
