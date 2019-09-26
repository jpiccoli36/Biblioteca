package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorBalance;
import Entidades.CuotasSocios;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CuotaSocio extends JFrame {

	private JPanel contentPane;
	private JTextField tfmonto;


	public CuotaSocio() {
	this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
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

		JLabel lblMonto = new JLabel("Monto:");

		tfmonto = new JTextField();
		tfmonto.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InsertarCuota();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CuotaSocio.this.dispose();
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
			}
		});
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JLabel lblIngresoCuotas = new JLabel("INGRESO CUOTA SOCIO");
		lblIngresoCuotas.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngresoCuotas.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(lblIngresoCuotas, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(146))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(131)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMonto)
							.addGap(74)
							.addComponent(tfmonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(120))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblIngresoCuotas)
					.addGap(121)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMonto)
						.addComponent(tfmonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(76)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap(204, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}

	protected void InsertarCuota() {
		Entidades.CuotasSocios cs = new CuotasSocios();
		ControladorBalance cb = new ControladorBalance();
		try {
			if(Float.parseFloat(this.tfmonto.getText())>=0)
			{
			cs.setMonto(Float.parseFloat((this.tfmonto.getText())));
			long time = System.currentTimeMillis();
			java.sql.Date fecha = new java.sql.Date(time);

			cs.setFecha(fecha);
			
			try {
				cb.CuotaSocio(cs);
				JOptionPane.showMessageDialog(null, "Cuota cargada");
				CuotaSocio.this.dispose();
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);

			} catch (SQLException e) {

				e.printStackTrace();
			} catch (Exception e) {
				
				e.printStackTrace();
			} }
			else{
				JOptionPane.showMessageDialog(null, "El monto debe ser positivo");
			}
			}
			
		 catch (NumberFormatException e1) {
			
			JOptionPane.showMessageDialog(null, "Monto Invalido");
		}
			}
		
				

	}