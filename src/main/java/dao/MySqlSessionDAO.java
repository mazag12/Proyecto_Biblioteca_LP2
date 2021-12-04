package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.session;
import db.MysqlDBConexion8;
import interfaces.LogSessionInterfaceDAO;

public class MySqlSessionDAO implements LogSessionInterfaceDAO {

	@Override
	public int createSession(session se) {
	
		    int value = 0;
			int session = 0;
			
			Connection cn = null;
			PreparedStatement psm = null;
			
			try {
				
				
				cn = MysqlDBConexion8.getConexion();

				String sql = "INSERT INTO  logSession VALUES(null,?,?)";
						psm = cn.prepareStatement(sql);
						
						
						
						psm.setString(1, se.getDateSession());
						psm.setString(2, se.getTimeZoneSession());
					
						
						value = psm.executeUpdate();

						
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				finally {
					try {
						if(psm!= null) psm.close();
						if(cn !=null) cn.close();
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				return session;
			
			
	}

}
