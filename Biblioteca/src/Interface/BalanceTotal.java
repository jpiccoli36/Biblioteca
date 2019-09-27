package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import Datos.Balance;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BalanceTotal extends JFrame {

	private JPanel contentPane;
	private JDateChooser fechaInicio;
	private JTable table;
	private JDateChooser fechaFin;
	private JLabel lbtotal;

	public BalanceTotal() {
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
				BalanceTotal.this.dispose();
			}
		});

		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
				BalanceTotal.this.dispose();
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
		
		JLabel lblBaa = new JLabel("BALANCE TOTAL");
		lblBaa.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(16)
							.addComponent(Total, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lbtotal, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(btnMenuPrincipal, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnExportarAPdf, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechaFinPeriodo, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFechaInicioPeriodo, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(fechaInicio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(fechaFin, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(16)))
					.addContainerGap(103, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(184, Short.MAX_VALUE)
					.addComponent(lblBaa, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addGap(91))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBaa, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFechaInicioPeriodo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(fechaInicio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaFinPeriodo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(fechaFin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(Total, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbtotal, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMenuPrincipal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExportarAPdf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
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
if((fechaInicio.getDate())!=null )
{
	if((fechaFin.getDate())!=null )
	{
		int k =fechaInicio.getDate().compareTo(fechaFin.getDate());
	 if(k<=0)
	 {
	 
		Date date = fechaInicio.getDate();
		long d = date.getTime();
		java.sql.Date fechaini = new java.sql.Date(d);

		Date da = fechaFin.getDate();
		long d1 = da.getTime();
		java.sql.Date fechaFin = new java.sql.Date(d1);
		;

		Balance b = new Balance();
		rs = b.BalanceTotal(fechaini, fechaFin);

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
            Integer numRows = 120;
			
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
						JOptionPane.showMessageDialog(null, "Documento creado");
			}
					
					 catch (Exception e) {

						 JOptionPane.showMessageDialog(null, "No hay nada para exportar");
				}
		}
		}
	 else{
		 JOptionPane.showMessageDialog(null, "Fecha fin debe ser posterior a la fecha inicio");
	 }
	 }
	
else{
	 JOptionPane.showMessageDialog(null, "Seleccionar fecha fin período");}
	}

		else{
			 JOptionPane.showMessageDialog(null, "Seleccionar fecha inicio período");
			
		}
		

	}

	protected void PasarDatos() {
		ResultSet rs = null;
		if((fechaInicio.getDate())!=null )
		{
			if((fechaFin.getDate())!=null )
			{
				int k =fechaInicio.getDate().compareTo(fechaFin.getDate());
			 if(k<=0)
			 {

		Date date = fechaInicio.getDate();
		long d = date.getTime();
		java.sql.Date fechaini = new java.sql.Date(d);

		Date da = fechaFin.getDate();
		long d1 = da.getTime();
		java.sql.Date fechaFin = new java.sql.Date(d1);
		

		Balance b = new Balance();
		rs = b.BalanceTotal(fechaini, fechaFin);

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
			 else{
				 JOptionPane.showMessageDialog(null, "Fecha fin debe ser posterior a la fecha inicio");
			 }
			 }
			
		else{
			 JOptionPane.showMessageDialog(null, "Seleccionar fecha fin período");}
			}

				else{
					 JOptionPane.showMessageDialog(null, "Seleccionar fecha inicio período");
					
				}

}
	}



