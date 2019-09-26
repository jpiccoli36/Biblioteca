package Interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Datos.Balance;


import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;




import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BalanceExtraordinario extends JFrame {

	private JPanel contentPane;
	private JDateChooser fechaInicio;
	private JTable table;
	private JDateChooser fechaFin;
	private JLabel lbtotal;

	public BalanceExtraordinario() {
		setTitle("Biblioteca Alfonsina Storni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		FlowLayout fl_contentPane = new FlowLayout();
		contentPane.setLayout(fl_contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		fechaInicio = new JDateChooser();
		fechaInicio.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JLabel lblFechaInicioPeriodo = new JLabel("Fecha Inicio Periodo");

		JLabel lblFechaFinPeriodo = new JLabel("Fecha Fin Periodo");

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
				BalanceExtraordinario.this.dispose();
			}
		});

		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
				BalanceExtraordinario.this.dispose();
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
		
		JLabel lblBalanceExtraordinario = new JLabel("BALANCE CUENTAS EXTRAORDINARIAS");
		lblBalanceExtraordinario.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(Total, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lbtotal, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(btnMenuPrincipal, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnExportarAPdf, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(135, Short.MAX_VALUE)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(121))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblFechaInicioPeriodo, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(fechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblFechaFinPeriodo, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(fechaFin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(93))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(113, Short.MAX_VALUE)
					.addComponent(lblBalanceExtraordinario, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBalanceExtraordinario, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaInicioPeriodo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(fechaInicio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaFinPeriodo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(fechaFin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(Total, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbtotal, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMenuPrincipal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExportarAPdf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
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

		Date date = fechaInicio.getDate();
		long d = date.getTime();
		java.sql.Date fechaini = new java.sql.Date(d);

		Date da = fechaFin.getDate();
		long d1 = da.getTime();
		java.sql.Date fechaFin = new java.sql.Date(d1);
		;

		Balance b = new Balance();
		rs = b.BalanceExtraordinario(fechaini, fechaFin);

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
				l.add("Descripcion");
				l.add("Monto");
				l.add("Clase");
				
				ArrayList<String>fecha = new ArrayList<>();
				ArrayList<String>tipo = new ArrayList<>();

				ArrayList<String>monto = new ArrayList<>();
				ArrayList<String>Descripcion = new ArrayList<>();

				ArrayList<String>IngresoEgreso = new ArrayList<>();

				
				
				
			PdfPTable table = new PdfPTable(5);
			PdfPCell columnHeader;
			Integer numColumns = 5;
            for (int column = 0; column < numColumns; column++) {
                columnHeader = new PdfPCell(new Phrase( l.get(column)));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);
			}
                table.setHeaderRows(1);
                
                if(rs != null) {

				try {
					while (rs.next()) {

						fecha.add(rs.getString("Fecha"));
						tipo.add(rs.getString("Tipo"));
						Descripcion.add(rs.getString("Descripcion"));
						monto.add(rs.getString("Monto"));
						IngresoEgreso.add(rs.getString("clase"));
					}
				}
				catch (Exception e) {
					
				}
				
				}
                      
                for (int row = 0; row < fecha.size(); row++) {
                    
                        table.addCell(fecha.get(row));
                        table.addCell(tipo.get(row));
                        table.addCell(Descripcion.get(row));
                        if(IngresoEgreso.get(row).equals("ingreso")){
                        table.addCell("$ "+monto.get(row));
                        }
                        else{
                        	table.addCell("$ "+"-"+monto.get(row));
                        }
                        table.addCell(IngresoEgreso.get(row));
                    
                    }    		
				
							
							

					
						String total = lbtotal.getText();
						String tot = "\n" + " " + "Total " + "               " + total;
						table.addCell(total);
						table.addCell(tot);
						doc.add(table);
						
						doc.add(new Paragraph(tot));
						doc.close();
						JOptionPane.showMessageDialog(null, "Documento Creado");
			}
					
					 catch (Exception e) {

						 JOptionPane.showMessageDialog(null, "No Hay nada para Exportar");
				}
			}

	}

	protected void PasarDatos() {
		ResultSet rs = null;

		Date date = fechaInicio.getDate();
		long d = date.getTime();
		java.sql.Date fechaini = new java.sql.Date(d);

		Date da = fechaFin.getDate();
		long d1 = da.getTime();
		java.sql.Date fechaFin = new java.sql.Date(d1);
		;

		Balance b = new Balance();
		rs = b.BalanceExtraordinario(fechaini, fechaFin);

		float total = 0;
		DefaultTableModel dfm = new DefaultTableModel();
		table = this.table;
		table.setModel(dfm);
		dfm.setColumnIdentifiers(new Object[] { "Fecha", "Tipo", "Descripcion", "Monto", "Ingreso/Egreso" });

		if (rs != null) {

			try {
				while (rs.next()) {
					if(rs.getString("clase").equals("ingreso"))
					{
					dfm.addRow(new Object[] { (rs.getString("Fecha")), rs.getString("Tipo"),
							rs.getString("Descripcion"), "$ "+rs.getString("Monto"), rs.getString("Clase") });
					if (rs.getString("clase").equals("ingreso")) {
						total = total + rs.getFloat("monto");
					} else {
						total = total - rs.getFloat("monto");
					}
					}
					else{
						{
							dfm.addRow(new Object[] { (rs.getString("Fecha")), rs.getString("Tipo"),
									rs.getString("Descripcion"), "$ "+"-"+rs.getString("Monto"), rs.getString("Clase") });
							if (rs.getString("clase").equals("ingreso")) {
								total = total + rs.getFloat("monto");
							} else {
								total = total - rs.getFloat("monto");
							}
							}
						
					}
					;

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			DecimalFormat dec= new DecimalFormat("#.00");
			String t= dec.format(total);
			lbtotal.setText("$ " + t);
			

		}

	}

}
