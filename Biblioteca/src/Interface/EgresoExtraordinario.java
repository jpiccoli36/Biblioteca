package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorBalance;
import Entidades.Ingreso;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EgresoExtraordinario extends JFrame {

	private JPanel contentPane;
	private JTextField tfmonto;
	private JTextField tfdescripcion;

	public EgresoExtraordinario() {
		
		setTitle("Biblioteca Alfonsina Storni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					egresoextraordinario();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(66, 166, 89, 23);
		panel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EgresoExtraordinario.this.dispose();
				MenuExtraordinario me = new MenuExtraordinario();
				me.setVisible(true);
			}
		});
		btnCancelar.setBounds(193, 166, 89, 23);
		panel.add(btnCancelar);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp= new MenuPrincipal();
				mp.setVisible(true);
				EgresoExtraordinario.this.dispose();
				
			}
		});
		btnMenuPrincipal.setBounds(282, 217, 132, 23);
		panel.add(btnMenuPrincipal);
		
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setBounds(32, 64, 46, 14);
		panel.add(lblMonto);
		
		tfmonto = new JTextField();
		tfmonto.setBounds(122, 61, 86, 20);
		panel.add(tfmonto);
		tfmonto.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(32, 109, 80, 14);
		panel.add(lblDescripcion);
		
		tfdescripcion = new JTextField();
		tfdescripcion.setBounds(122, 106, 86, 20);
		panel.add(tfdescripcion);
		tfdescripcion.setColumns(10);
		
		JLabel lblEgresoExtraordinario = new JLabel("Egreso Extraordinario");
		lblEgresoExtraordinario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEgresoExtraordinario.setBounds(10, 0, 286, 23);
		panel.add(lblEgresoExtraordinario);
	}

	protected void egresoextraordinario() throws Exception {
		Entidades.Ingreso in = new Ingreso();
		ControladorBalance cb = new ControladorBalance();
		try {
			in.setMonto(Float.parseFloat(this.tfmonto.getText()));
			in.setDescripcion(this.tfdescripcion.getText());
			in.setClase("egreso");
			in.setTipo("Egreso");
			long time = System.currentTimeMillis();
			java.sql.Date fecha = new java.sql.Date(time);

			in.setFecha(fecha);
		
				cb.Ingreso(in);
				JOptionPane.showMessageDialog(null, "Egreso cargado");
				EgresoExtraordinario.this.dispose();
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);					
				
			
			
		}
		catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Monto inválido");
		}

		
		
	}
}
