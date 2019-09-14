package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import Datos.CuotaSocio;
import Datos.IngresoEgreso;
import Entidades.CuotasSocios;
import Entidades.Ingreso;

public class ControladorBalance {

	ArrayList<CuotaSocio> cuota = new ArrayList<CuotaSocio>();


	void IngresoExtraordinario(float x, String tipo, String descripcion) {
		
		
		
	}
	void EgresoExtraordinario(float x, String descripcion)
	{
		
	}

	
	



public void CuotaSocio(CuotasSocios c) throws SQLException, Exception{
	
Datos.CuotaSocio cs = new CuotaSocio();
cs.CuotaSocio(c);



	}
public void Ingreso(Ingreso in) {
Datos.IngresoEgreso ie= new IngresoEgreso();
try {
	ie.IngresoEgreso(in);
} catch (SQLException e) {

	e.printStackTrace();
}
	
}

}


