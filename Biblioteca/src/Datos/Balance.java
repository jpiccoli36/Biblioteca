package Datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance {

	public ResultSet BalanceSocio(java.sql.Date fini, java.sql.Date ffin) {
		ResultSet rs = null;
		java.sql.PreparedStatement stmt = null;		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("SELECT * FROM ingresoegreso where Tipo=? and Fecha between ? and ? ");
			stmt.setString(1, "Cuota");
			stmt.setDate(2, fini);

			stmt.setDate(3, ffin);

			rs = stmt.executeQuery();
			
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	


		return rs;

	}
	
	public ResultSet BalanceExtraordinario(java.sql.Date fini, java.sql.Date ffin) {
		ResultSet rs = null;
		java.sql.PreparedStatement stmt = null;		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("SELECT * FROM ingresoegreso where Tipo not like ?  and fecha between ? and ?");
			
			stmt.setString(1, "Cuota");
			
			stmt.setDate(2, fini);

			stmt.setDate(3, ffin);

			rs = stmt.executeQuery();
			
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	


		return rs;

	}
	public ResultSet BalanceTotal(java.sql.Date fini, java.sql.Date ffin) {
		ResultSet rs = null;
		java.sql.PreparedStatement stmt = null;		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("SELECT * FROM ingresoegreso where fecha between ? and ?");
						
			
			stmt.setDate(1, fini);

			stmt.setDate(2, ffin);

			rs = stmt.executeQuery();
			
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	


		return rs;

	}

}
