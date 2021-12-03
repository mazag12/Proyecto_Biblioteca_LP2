package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Prestamo;
import db.MysqlDBConexion8;
import interfaces.PrestamoInterface;

public class MySqlPrestamoDAO implements PrestamoInterface {

	@Override
public List<Prestamo> getListPrestamo(){
		
		List<Prestamo> listPrestamo = new ArrayList<Prestamo>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * from prestamo";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Prestamo p = new Prestamo();
				p.setCodprestamo(rs.getString("CodPrestamo"));
				p.setFechaentrega(rs.getString("Fecha Entrega"));
				p.setFechaprestamo(rs.getString("Fecha Prestamo")); 
				p.setFechadevolucion(rs.getString("Fecha Devolucion"));
				p.setCodcliente(rs.getString("CodCliente"));
				p.setCodigoemple(rs.getString("CodEmpleado"));
				
				listPrestamo.add(p);
				
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
		return listPrestamo;
	}

	@Override
	public int createPrestamo(Prestamo pr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Prestamo getPrestamo(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editPrestamo(Prestamo pr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removePrestamo(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
