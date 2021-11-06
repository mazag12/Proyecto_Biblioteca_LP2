package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlDBConexion; 

import beans.Familia;
import interfaces.FamiliaInterfaceDAO;

public class MySqlFamiliaDAO implements FamiliaInterfaceDAO{

	@Override
	public List<Familia> getListFamilia() {
		List<Familia> listFamilia = new ArrayList<Familia>();
		
		Connection cn =  null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn =  MysqlDBConexion.getConexion();
			
			String sql = "select * from estudios";
			
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			
			while (rs.next()) {
				
				Familia fam = new Familia();
				
				fam.setCodFamilia(rs.getString("CODFAMILIA"));
				fam.setNombre(rs.getString("NOMBRE"));
				fam.setDireccion(rs.getString("DIRECCION"));
				fam.setTelefono(rs.getInt("TELEFONO"));
				
				listFamilia.add(fam);
				
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
		
		return listFamilia;
	}

}
