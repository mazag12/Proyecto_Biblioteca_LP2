package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Detalle_prestamo;
import db.MysqlDBConexion8;

public class DetallePrestamoModel {
	
	public List<Detalle_prestamo> getListDetalle_prestamo(){
		
		List<Detalle_prestamo> listDetalle_prestamo = new ArrayList<Detalle_prestamo>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * fromo detalle_prestamo";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Detalle_prestamo det = new Detalle_prestamo();
				det.setCodprestamo(rs.getString("CodPrestamo"));
				det.setCodlibro(rs.getString("CodLibro"));
				det.setDescripcion(rs.getString("Descripcion"));
				det.setCantidad(rs.getString("Cantidad"));
				
				listDetalle_prestamo.add(det);
				
			}
			
			System.out.println("Lista completa");
			
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
		return listDetalle_prestamo;
	}

}
