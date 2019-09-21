package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JLocaleChooser;
import java.awt.Window.Type;
import java.awt.Rectangle;
import java.awt.Dimension;

public class MenuPrincipal extends JFrame {
	

	private JPanel contentPane;
		
	public MenuPrincipal() {
	
		
		
		setTitle("Biblioteca Alfonsina Storni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 544);
		contentPane = new JPanel();


		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setName("");
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnCuotaSocio = new JButton("Cuota Socio");
		btnCuotaSocio.addMouseListener(new MouseAdapter() {
		
		});
		btnCuotaSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.this.dispose();
				CuotaSocio cs= new CuotaSocio();
				cs.setVisible(true);
			}
			
		});
		
		JButton btnExtraordinario = new JButton("Extraordinario");
		btnExtraordinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuExtraordinario me = new MenuExtraordinario();
				me.setVisible(true);
				MenuPrincipal.this.dispose();
			}
		});
		btnExtraordinario.addMouseListener(new MouseAdapter() {
		
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuBalance b = new MenuBalance();
				b.setVisible(true);
				MenuPrincipal.this.dispose();
				
			}
		});
		btnBalance.addMouseListener(new MouseAdapter() {
			
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(126)
							.addComponent(btnCuotaSocio, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(126)
							.addComponent(btnExtraordinario, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(126)
							.addComponent(btnBalance, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(325)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(btnCuotaSocio, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(btnExtraordinario, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnBalance, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSalir)
					.addContainerGap(255, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
