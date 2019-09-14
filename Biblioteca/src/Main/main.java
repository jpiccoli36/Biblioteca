package Main;

import java.awt.EventQueue;


import Datos.FactoryConexion;
import Interface.MenuPrincipal;

public class main {

	public static void main(String[] args) {
		
		
 EventQueue.invokeLater(new Runnable(){
		

	
		public void run() {
			
		try{
			MenuPrincipal mp = new MenuPrincipal();
		mp.setVisible(true);
			
		}
		
		catch (Exception e){
			e.printStackTrace();
			}
		}
		
		
	 });

}
	}