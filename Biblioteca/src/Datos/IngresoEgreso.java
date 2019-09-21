package Datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class IngresoEgreso {

	public void IngresoEgreso(Entidades.Ingreso in) throws SQLException {

		java.sql.PreparedStatement stmt = null;

		ResultSet rs = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert  into ingresoegreso(Monto,Tipo,Fecha,Clase,Descripcion) values  (?,?,?,?,?)  ",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setFloat(1, in.getMonto());
			stmt.setString(2, in.getTipo());
			stmt.setDate(3, (Date) in.getFecha());
			stmt.setString(4, in.getClase());
			stmt.setString(5, in.getDescripcion());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				in.setId(rs.getInt(1));
			}
			rs.close();
			stmt.close();

		} catch (SQLException s) {

			throw s;
		} catch (Exception s) {

			throw s;
		}

	}

}
