package Entidades;

import javax.print.attribute.standard.DateTimeAtCompleted;
	
	import java.io.Serializable;
import java.sql.Date;

import javax.swing.Spring;

	public class CuotasSocios  implements Serializable{
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		int id;
		float monto;

		java.util.Date fecha;
		
		public float getMonto() {
			return monto;
		}
		public void setMonto(float f) {
			this.monto = f;
		}
		public java.util.Date getFecha() {
			return fecha;
		}
		public void setFecha(java.util.Date fecha2) {
			this.fecha= fecha2;
			
		}
	
		public String getFechaIni() {
			return fechaIni;
		}
		public void setFechaIni(String string) {
			this.fechaIni = string;
		}
		public String getFechaFin() {
			return fechaFin;
		}
		public void setFechaFin(String string) {
			this.fechaFin = string;
		}
		String fechaIni;
		String fechaFin;
		

}
