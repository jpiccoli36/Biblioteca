package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

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
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EgresoExtraordinario extends JFrame {

	private JPanel contentPane;
	private JTextField tfmonto;
	private JTextField tfdescripcion;

	public EgresoExtraordinario() {

		setTitle("Biblioteca Alfonsina Storni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

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

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EgresoExtraordinario.this.dispose();
				MenuExtraordinario me = new MenuExtraordinario();
				me.setVisible(true);
			}
		});

		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
				EgresoExtraordinario.this.dispose();

			}
		});

		JLabel lblMonto = new JLabel("Monto");

		tfmonto = new JTextField();
		tfmonto.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion");

		tfdescripcion = new JTextField();
		tfdescripcion.setColumns(10);

		JLabel lblEgresoExtraordinario = new JLabel("EGRESO EXTRAORDINARIO");
		lblEgresoExtraordinario.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(191, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMonto, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(tfmonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDescripcion, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(tfdescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(126))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(351, Short.MAX_VALUE)
					.addComponent(btnMenuPrincipal, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(131)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(146, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(147, Short.MAX_VALUE)
					.addComponent(lblEgresoExtraordinario, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblEgresoExtraordinario, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(116)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblMonto))
						.addComponent(tfmonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDescripcion))
						.addComponent(tfdescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addGap(38)
					.addComponent(btnMenuPrincipal)
					.addGap(138))
		);
		panel.setLayout(gl_panel);
	}

	protected void egresoextraordinario() throws Exception {
		Entidades.Ingreso in = new Ingreso();
		ControladorBalance cb = new ControladorBalance();
		try {
			if(Float.parseFloat(this.tfmonto.getText())>=0)
			{
			in.setMonto(Float.parseFloat(this.tfmonto.getText()));
			if (!this.tfdescripcion.getText().isEmpty()) {
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

			} else {
				JOptionPane.showMessageDialog(null, "Falta descripción");
			}
			}
			else{ JOptionPane.showMessageDialog(null, "El monto debe ser positivo");}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Monto inválido");
		}

	}
}
