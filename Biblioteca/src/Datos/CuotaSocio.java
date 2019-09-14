package Datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Entidades.CuotasSocios;

public class CuotaSocio {

	public void CuotaSocio(CuotasSocios c) throws SQLException,Exception {
		
		java.sql.PreparedStatement stmt = null;

		ResultSet rs = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert  into ingresoegreso (Monto,Tipo,Fecha,Clase) values  (?,?,?,?)  ",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, c.getMonto());
			stmt.setString(2, "Cuota");
			stmt.setDate(3, (Date) c.getFecha());
			stmt.setString(4, "ingreso");

		
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				c.setId(rs.getInt(1));
			}			
			rs.close();
			stmt.close();

		} catch (SQLException s) {
			
			throw s;
		}
		catch(Exception s){
			
			throw s;
		}
		
	}




	
}

