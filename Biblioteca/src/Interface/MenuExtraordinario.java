package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class MenuExtraordinario extends JFrame {

	private JPanel contentPane;

	
	public MenuExtraordinario() {
		setTitle("Biblioteca Alfonsina Storni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnIngresoExtraordinario = new JButton("Ingreso Extraordinario");
		btnIngresoExtraordinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresoExtraordinario ie = new IngresoExtraordinario();
				ie.setVisible(true);
				MenuExtraordinario.this.dispose();
				
			}
		});
		
		JButton btnEgresoExtraordinario = new JButton("Egreso Extraordinario");
		btnEgresoExtraordinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EgresoExtraordinario ee = new EgresoExtraordinario();
				ee.setVisible(true);
				MenuExtraordinario.this.dispose();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuExtraordinario.this.dispose();
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
			}
		});
		
		addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(396, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addGap(15))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(173)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnEgresoExtraordinario)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnIngresoExtraordinario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(167))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(183)
					.addComponent(btnIngresoExtraordinario, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEgresoExtraordinario, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(btnCancelar)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}

}
