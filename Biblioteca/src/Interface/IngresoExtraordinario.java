package Interface;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorBalance;
import Entidades.Ingreso;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class IngresoExtraordinario extends JFrame {

	private JPanel contentPane;
	public static JTextField tfMonto;
	private JTextField tfDescripcion;
	private JComboBox cbTipo;

	public IngresoExtraordinario() {
		setTitle("Biblioteca Alfonsina Storni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel lblMonto = new JLabel("Monto");

		tfMonto = new JTextField();
		tfMonto.setColumns(10);

		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] { "Feria", "Taller", "Otro" }));

		JLabel lblTipoDeIngreso = new JLabel("Tipo de Ingreso");

		JLabel lblDescripcion = new JLabel("Descripcion");

		tfDescripcion = new JTextField();
		tfDescripcion.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresoExtraordinario.this.dispose();
				MenuExtraordinario me = new MenuExtraordinario();
				me.setVisible(true);

			}
		});

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingreso();
			}
		});

		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresoExtraordinario.this.dispose();
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
			}
		});

		JLabel lblIngreso = new JLabel("Ingreso Extraordinario");
		lblIngreso.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addGap(40)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTipoDeIngreso, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lblMonto).addComponent(lblDescripcion)
						.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup().addGap(18).addComponent(btnCancelar,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup().addGap(27)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(tfDescripcion)
										.addComponent(cbTipo, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tfMonto))))
				.addContainerGap(196, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(304, Short.MAX_VALUE)
						.addComponent(btnMenuPrincipal).addGap(19))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addContainerGap().addComponent(lblIngreso)
						.addContainerGap(368, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addComponent(lblIngreso).addGap(29)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfMonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMonto))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(cbTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipoDeIngreso))
						.addGap(30)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblDescripcion)
								.addComponent(tfDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btnAceptar)
								.addComponent(btnCancelar))
						.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE).addComponent(btnMenuPrincipal)
						.addContainerGap()));
		panel.setLayout(gl_panel);
	}

	protected void ingreso() {
		Entidades.Ingreso in = new Ingreso();
		ControladorBalance cb = new ControladorBalance();
		
		try {
			if(Float.parseFloat(this.tfMonto.getText())>=0)
			{
			in.setMonto(Float.parseFloat(this.tfMonto.getText()));
			Object TipoEl = cbTipo.getSelectedItem();
			in.setTipo((String) TipoEl);
			if(!this.tfDescripcion.getText().isEmpty())
			{
			in.setDescripcion(this.tfDescripcion.getText());
			in.setClase("ingreso");
			long time = System.currentTimeMillis();
			java.sql.Date fecha = new java.sql.Date(time);

			in.setFecha(fecha);
		
			try {
				cb.Ingreso(in);
				JOptionPane.showMessageDialog(null, "Ingreso cargado");
				IngresoExtraordinario.this.dispose();
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);

			} catch (Exception e) {

			}
			}
		
		else{
			JOptionPane.showMessageDialog(null, "Falta descripción");
		}
			}
			else{
				JOptionPane.showMessageDialog(null, "El monto debe ser positivo");
				
			}
		} catch (NumberFormatException e1) {

			JOptionPane.showMessageDialog(null, "Monto inválido");
		}

	}
}
