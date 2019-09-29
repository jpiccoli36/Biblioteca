package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Datos.Balance;
import Entidades.CuotasSocios;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.DropMode;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BalanceCuotasSocio extends JFrame {

	private JPanel contentPane;
	private JDateChooser fechaInicio;
	private JTable table;
	private JDateChooser fechaFin;
	private JLabel lbtotal;

	public BalanceCuotasSocio() {
		
		setTitle("Biblioteca Alfonsina Storni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 544);;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		fechaInicio = new JDateChooser();
		fechaInicio.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JLabel lblFechaInicioPeriodo = new JLabel("Fecha inicio per\u00EDodo");

		JLabel lblFechaFinPeriodo = new JLabel("Fecha fin per\u00EDodo");

		fechaFin = new JDateChooser();

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PasarDatos();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuBalance mb = new MenuBalance();
				mb.setVisible(true);
				BalanceCuotasSocio.this.dispose();
			}
		});

		JButton btnMenuPrincipal = new JButton("Men\u00FA Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
				BalanceCuotasSocio.this.dispose();
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel Total = new JLabel("Total");

		lbtotal = new JLabel("");

		JButton btnExportarAPdf = new JButton("Exportar a PDF");
		btnExportarAPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportar();
			}
		});

		JLabel lblBalanceCuotasSocios = new JLabel("BALANCE CUOTAS SOCIOS");
		lblBalanceCuotasSocios.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalanceCuotasSocios.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(273, Short.MAX_VALUE)
					.addComponent(lblBalanceCuotasSocios, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addGap(241))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(Total, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbtotal, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnMenuPrincipal, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnExportarAPdf, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(108, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(254)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaFinPeriodo, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaInicioPeriodo, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(fechaInicio, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(fechaFin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(182))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(263, Short.MAX_VALUE)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(224))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(154, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
					.addGap(81))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblBalanceCuotasSocios, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(fechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaInicioPeriodo))
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaFinPeriodo)
						.addComponent(fechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMenuPrincipal)
								.addComponent(btnExportarAPdf)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lbtotal, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(Total))))
					.addGap(30))
		);
		
		addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});
		panel.setLayout(gl_panel);
	}

	protected void exportar() {

		ResultSet rs = null;
		if ((fechaInicio.getDate()) != null) {
			if ((fechaFin.getDate()) != null) {
				int k = fechaInicio.getDate().compareTo(fechaFin.getDate());
				if (k <= 0) {

					Date date = fechaInicio.getDate();
					long d = date.getTime();
					java.sql.Date fechaini = new java.sql.Date(d);

					Date da = fechaFin.getDate();
					long d1 = da.getTime();
					java.sql.Date fechaFin = new java.sql.Date(d1);
					;

					Balance b = new Balance();
					rs = b.BalanceSocio(fechaini, fechaFin);

					JFileChooser dlg = new JFileChooser();
					int option = dlg.showSaveDialog(this);
					if (option == JFileChooser.APPROVE_OPTION) {
						File f = dlg.getSelectedFile();

						try {
							String w = f.toString();

							FileOutputStream archivo = new FileOutputStream(w + ".pdf");
							Document doc = new Document();
							doc.setMargins(30, 30, 30, 30);
							PdfWriter.getInstance(doc, archivo);
							doc.open();
							ArrayList<String> l = new ArrayList<>();
							l.add("Fecha");
							l.add("Tipo");

							l.add("Monto");

							ArrayList<String> fecha = new ArrayList<>();
							ArrayList<String> tipo = new ArrayList<>();

							ArrayList<String> monto = new ArrayList<>();

							PdfPTable table = new PdfPTable(3);
							PdfPCell columnHeader;
							Integer numColumns = 3;
							

							for (int column = 0; column < numColumns; column++) {
								columnHeader = new PdfPCell(new Phrase(l.get(column)));
								columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
								table.addCell(columnHeader);
							}
							table.setHeaderRows(1);

							if (rs != null) {

								try {
									while (rs.next()) {

										fecha.add(rs.getString("Fecha"));
										tipo.add(rs.getString("Tipo"));

										monto.add(rs.getString("Monto"));

									}
								} catch (Exception e) {

								}

							}

							for (int row = 0; row < fecha.size(); row++) {

								table.addCell(fecha.get(row));
								table.addCell(tipo.get(row));

								table.addCell("$ "+monto.get(row));

							}

							String total = lbtotal.getText();
							String tot = "\n" + " " + "Total " + "               " + total;
							table.addCell(total);
							table.addCell(tot);
							doc.add(table);

							doc.add(new Paragraph(tot));
							doc.close();
							JOptionPane.showMessageDialog(null, "Documento creado");
						}

						catch (Exception e) {

							JOptionPane.showMessageDialog(null, "No hay nada para exportar");
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Fecha fin debe ser posterior a la fecha inicio");
				}
			}

			else {
				JOptionPane.showMessageDialog(null, "Seleccionar fecha fin período");
			}
		}

		else {
			JOptionPane.showMessageDialog(null, "Seleccionar fecha inicio período");

		}
	}

	protected void PasarDatos() {
		ResultSet rs = null;
		if ((fechaInicio.getDate()) != null) {
			if ((fechaFin.getDate()) != null) {
				int k = fechaInicio.getDate().compareTo(fechaFin.getDate());
				if (k <= 0) {

					Date date = fechaInicio.getDate();
					long d = date.getTime();
					java.sql.Date fechaini = new java.sql.Date(d);

					Date da = fechaFin.getDate();
					long d1 = da.getTime();
					java.sql.Date fechaFin = new java.sql.Date(d1);
					;

					Balance b = new Balance();
					rs = b.BalanceSocio(fechaini, fechaFin);

					float total = 0;
					DecimalFormat dec= new DecimalFormat("#.00");
					DefaultTableModel dfm = new DefaultTableModel();
					table = this.table;
					table.setModel(dfm);
					dfm.setColumnIdentifiers(new Object[] { "Fecha", "Monto" });

					if (rs != null) {

						try {
							while (rs.next()) {

								dfm.addRow(new Object[] { (rs.getString("fecha")), "$ "+rs.getString("monto") });
								total = total + rs.getFloat("monto");

							}
						} catch (SQLException e) {

							e.printStackTrace();
						}
							String t= dec.format(total);
							lbtotal.setText("$ " + t);


					}

				} else {
					JOptionPane.showMessageDialog(null, "Fecha fin debe ser posterior a la fecha inicio");
				}
			}

			else {
				JOptionPane.showMessageDialog(null, "Seleccionar fecha fin período");
			}
		}

		else {
			JOptionPane.showMessageDialog(null, "Seleccionar fecha inicio período");

		}
	}
}
