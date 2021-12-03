package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Cargo;
import db.MysqlDBConexion8;
import interfaces.CargoInterface;

public class MySqlCargoDAO implements CargoInterface {

	@Override
public List<Cargo> getListCargo(){
		
		List<Cargo> listCargo = new ArrayList<Cargo>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * from Cargo";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Cargo c = new Cargo();
				c.setCodcargo(rs.getString("CodCargo"));
				c.setDescripcion(rs.getString("Descripcion"));
				
				listCargo.add(c);
				
			}
			
			System.out.println("Lista completada");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(rs != null)rs.close();
				if(pstm != null)pstm.close();
				if(con != null)con.close(); 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return listCargo;		
		
	}

	@Override
	public int createCargo(Cargo ca) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cargo gerCargo(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editCargo(Cargo ca) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCargo(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
