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
		
int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call sp_insert_prestamo(?,?,?,?,?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, pr.getFechaentrega());
			psm.setString(2, pr.getFechaprestamo());
			psm.setString(3, pr.getFechadevolucion());
			psm.setString(4, pr.getCodcliente());
			psm.setString(5, pr.getCodigoemple());
			
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
	public Prestamo getPrestamo(String cod) {
Prestamo p = null;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = MysqlDBConexion8.getConexion();
			
			String sql = "select * from prestamo where codprestamo = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cod);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				p = new Prestamo();
				p.setCodprestamo(rs.getString("CodPrestamo"));
				p.setFechaentrega(rs.getString("Fecha de entrega"));
				p.setFechaprestamo(rs.getString("Fecha del prestamo"));
				p.setFechadevolucion(rs.getString("Fecha de devolucion"));
				p.setCodcliente(rs.getString("Codigo Cliente"));
				p.setCodigoemple(rs.getString("Codigo Empleado"));
			}else {
				p = new Prestamo();
				p.setCodprestamo("No hay datos");
				p.setFechaentrega("No hay datos");
				p.setFechaprestamo("No hay datos");
				p.setFechadevolucion("No hay datos");
				p.setCodcliente("No hay datos");
				p.setCodigoemple("No hay datos");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null)rs.close();
				if(pstm != null)pstm.close();
				if(con!=null)con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	@Override
	public int editPrestamo(Prestamo pr) {
			int value = 0;
		
		Connection cn =  null;
		PreparedStatement psm = null;
		try {
			
			cn = MysqlDBConexion8.getConexion();
			
			String sql = "call sp_update_prestamo(?,?,?,?,?,?)";
			psm = cn.prepareCall(sql);
			psm.setString(1, pr.getCodprestamo());
			psm.setString(2, pr.getFechaentrega());
			psm.setString(3, pr.getFechaprestamo());
			psm.setString(4, pr.getFechadevolucion());
			psm.setString(5, pr.getCodcliente());
			psm.setString(6, pr.getCodigoemple());
			
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
	public int removePrestamo(String cod) {
		int salida=0;
		
		Connection con =  null;
		PreparedStatement pstm = null;
		
		try {
			con = MysqlDBConexion8.getConexion();
			
			String sql = "delete from prestamo where codprestamo=?";
			pstm = con.prepareStatement(sql);
				pstm.setString(1, cod);
				
				salida = pstm.executeUpdate();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(pstm != null)pstm.close();
				if(con != null)con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return salida;
	}
	

}
