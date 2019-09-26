package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MenuBalance extends JFrame {

	private JPanel contentPane;


	public MenuBalance() {
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
		
		JButton btnBalanceCuotasSocios = new JButton("Balance Cuotas Socios");
		btnBalanceCuotasSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BalanceCuotasSocio mps = new BalanceCuotasSocio();
				MenuBalance.this.dispose();
				mps.setVisible(true);
			}
		});
		
		JButton btnBalanceCuentasExtraordinarias = new JButton("Balance Cuentas Extraordinarias");
		btnBalanceCuentasExtraordinarias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BalanceExtraordinario be = new BalanceExtraordinario();
				MenuBalance.this.dispose();
				be.setVisible(true);
			}
		});
		
		JButton btnBalanceTotal = new JButton("Balance Total");
		btnBalanceTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BalanceTotal be = new BalanceTotal();
				MenuBalance.this.dispose();
				be.setVisible(true);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal();
				MenuBalance.this.dispose();
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
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(126)
					.addComponent(btnBalanceCuotasSocios, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(126)
					.addComponent(btnBalanceCuentasExtraordinarias, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(126)
					.addComponent(btnBalanceTotal, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(394)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(150)
					.addComponent(btnBalanceCuotasSocios, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(btnBalanceCuentasExtraordinarias, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnBalanceTotal, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(72)
					.addComponent(btnCancelar))
		);
		panel.setLayout(gl_panel);
	}

}
