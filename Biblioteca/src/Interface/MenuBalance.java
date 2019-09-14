package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuBalance extends JFrame {

	private JPanel contentPane;


	public MenuBalance() {
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
		
		JButton btnBalanceCuotasSocios = new JButton("Balance Cuotas Socios");
		btnBalanceCuotasSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BalanceCuotasSocio mps = new BalanceCuotasSocio();
				MenuBalance.this.dispose();
				mps.setVisible(true);
			}
		});
		btnBalanceCuotasSocios.setBounds(86, 60, 231, 23);
		panel.add(btnBalanceCuotasSocios);
		
		JButton btnBalanceCuentasExtraordinarias = new JButton("Balance Cuentas Extraordinarias");
		btnBalanceCuentasExtraordinarias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BalanceExtraordinario be = new BalanceExtraordinario();
				MenuBalance.this.dispose();
				be.setVisible(true);
			}
		});
		btnBalanceCuentasExtraordinarias.setBounds(86, 94, 231, 23);
		panel.add(btnBalanceCuentasExtraordinarias);
		
		JButton btnBalanceTotal = new JButton("Balance Total");
		btnBalanceTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BalanceTotal be = new BalanceTotal();
				MenuBalance.this.dispose();
				be.setVisible(true);
			}
		});
		btnBalanceTotal.setBounds(86, 128, 231, 23);
		panel.add(btnBalanceTotal);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal();
				MenuBalance.this.dispose();
				mp.setVisible(true);
			}
		});
		btnCancelar.setBounds(325, 203, 89, 23);
		panel.add(btnCancelar);
	}

}
