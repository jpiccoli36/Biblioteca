package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class BalanceTotal extends JFrame {

	private JPanel contentPane;
	private JDateChooser fechaInicio;
	private JTable table;
	private JDateChooser fechaFin;
	private JLabel lbtotal;

	public BalanceTotal() {
		setTitle("Biblioteca Alfonsina Storni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		fechaInicio = new JDateChooser();
		fechaInicio.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		fechaInicio.setBounds(213, 48, 87, 20);
		panel.add(fechaInicio);

		JLabel lblFechaInicioPeriodo = new JLabel("Fecha Inicio Periodo");
		lblFechaInicioPeriodo.setBounds(31, 54, 124, 14);
		panel.add(lblFechaInicioPeriodo);

		JLabel lblFechaFinPeriodo = new JLabel("Fecha Fin Periodo");
		lblFechaFinPeriodo.setBounds(31, 117, 124, 14);
		panel.add(lblFechaFinPeriodo);

		fechaFin = new JDateChooser();
		fechaFin.setBounds(213, 117, 87, 20);
		panel.add(fechaFin);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PasarDatos();
			}
		});
		btnAceptar.setBounds(48, 168, 89, 23);
		panel.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuBalance mb = new MenuBalance();
				mb.setVisible(true);
				BalanceTotal.this.dispose();
			}
		});
		btnCancelar.setBounds(198, 168, 89, 23);
		panel.add(btnCancelar);

		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
				BalanceTotal.this.dispose();
			}
		});
		btnMenuPrincipal.setBounds(180, 404, 135, 23);
		panel.add(btnMenuPrincipal);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 490, 176);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel Total = new JLabel("Total");
		Total.setBounds(20, 404, 46, 14);
		panel.add(Total);

		lbtotal = new JLabel("");
		lbtotal.setBounds(68, 404, 87, 14);
		panel.add(lbtotal);

		JButton btnExportarAPdf = new JButton("Exportar a PDF");
		btnExportarAPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportar();
			}
		});
		btnExportarAPdf.setBounds(343, 404, 135, 23);
		panel.add(btnExportarAPdf);
		
		JLabel lblBaa = new JLabel("Balance Total");
		lblBaa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaa.setBounds(0, 0, 218, 20);
		panel.add(lblBaa);
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
                        table.addCell("$ "+monto.get(row));
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

					dfm.addRow(new Object[] { (rs.getString("Fecha")), rs.getString("Tipo"),
							rs.getString("Descripcion"), rs.getString("Monto"), rs.getString("Clase") });
					if (rs.getString("clase").equals("ingreso")) {
						total = total + rs.getFloat("monto");
					} else {
						total = total - rs.getFloat("monto");
					}
					;

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			lbtotal.setText("$ " + Float.toString(total));

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



