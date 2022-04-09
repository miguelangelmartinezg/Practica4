package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.Conexion;
import Modelo.Estudiante;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class frmEstudiantesRegistrados extends JFrame implements ActionListener, WindowListener {

	private JPanel contentPane;
	DefaultTableModel model;
	private JButton btnCerrarSecion;
	private Conexion MiConexion;
	private JTable dtEstudiantes;
	private JButton btbNuevo;
	private JButton btnActualizar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEstudiantesRegistrados frame = new frmEstudiantesRegistrados();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public frmEstudiantesRegistrados() {
		addWindowListener(this);
		this.Inicializar();
		this.CargarDatos();
		setLocationRelativeTo(null);
	}
    public frmEstudiantesRegistrados(Conexion oCon) {
    	this.MiConexion = oCon;
    	this.Inicializar();
    	this.CargarDatos();
    	setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			handle_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnActualizar) {
			handle_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btbNuevo) {
			handle_btbNuevo_actionPerformed(e);
		}
		if (e.getSource() == btnCerrarSecion) {
			handle_btnCerrarSecion_actionPerformed(e);
		}
	}
	protected void handle_btnCerrarSecion_actionPerformed(ActionEvent e) {
		frmLogin oFrm = new frmLogin();
		oFrm.setVisible(true);
		this.setVisible(false);
	}
	
	public void CargarDatos() {
		
		DefaultTableModel dtDatos = MiConexion.ConsultarTodo();
		
		dtEstudiantes.setModel(dtDatos);
		
		
	}
	public void CargarDatos2() {
		
		DefaultTableModel modelo = new DefaultTableModel();
		String [] cDatos = MiConexion.ConsultarTodo2();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Telefono");
		modelo.addColumn("Email");
		modelo.addColumn("Usuario");
		dtEstudiantes.setModel(modelo);
		
		modelo.addRow(cDatos);
		
	}
	
	private void Inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		model = new DefaultTableModel();
		Object[] columna =	{"ID","NOMBRE","APELLIDO","TELEFONO","CORREO ELECTRONICO","USUARIO"};	
		Object[] fila = new Object[0];
		model.setColumnIdentifiers(columna);
		
		btbNuevo = new JButton("Nuevo");
		btbNuevo.addActionListener(this);
		btbNuevo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btbNuevo.setBounds(202, 406, 127, 51);
		panel.add(btbNuevo);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnActualizar.setBounds(339, 406, 127, 51);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminar.setBounds(480, 406, 127, 51);
		panel.add(btnEliminar);
		
		btnCerrarSecion = new JButton("Cerrar secion");
		btnCerrarSecion.addActionListener(this);
		btnCerrarSecion.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCerrarSecion.setBounds(617, 406, 183, 51);
		panel.add(btnCerrarSecion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 34, 891, 333);
		panel.add(scrollPane);
		
		dtEstudiantes = new JTable();
		dtEstudiantes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(dtEstudiantes);
		
		//
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			handle_this_windowOpened(e);
		}
	}
	public void BuscarEstudiante() {
		int nFila = dtEstudiantes.getSelectedRow();
		int nID = Integer.parseInt(this.dtEstudiantes.getValueAt(nFila, 0).toString());
		Estudiante oEstudiante = MiConexion.InformacionEstudiante(nID);
		frmRegistro oFrm = new frmRegistro(MiConexion,oEstudiante);
		oFrm.setVisible(true);
		this.setVisible(false);


		
	}
	private int EliminarRegistro(int nID) {
		int nResultado = 0;
		String [] misBotones = {"Si","No"};
		
		int nRespuesta = JOptionPane.showOptionDialog(this,"Seguro que desea eliminar Registro??",
				"Confirmar Eliminaci�n.",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,misBotones,misBotones[1]);
		if (nRespuesta == 0) {
			nResultado = MiConexion.SetInformacion("delete from  estudiantes where idEstudiante = " + nID);
			
			if (nResultado > 0) {
				JOptionPane.showMessageDialog(null,"Registro Eliminado Correctamente.");
				this.CargarDatos();
			}
		}
		
		
		return nResultado;
	}

	protected void handle_this_windowOpened(WindowEvent e) {
		//this.CargarDatos();
	}
	protected void handle_btbNuevo_actionPerformed(ActionEvent e) {
		frmRegistro oFrmRegistro = new frmRegistro(MiConexion);
		oFrmRegistro.setVisible(true);
		this.setVisible(false);
	}
	protected void handle_btnActualizar_actionPerformed(ActionEvent e) {
		this.BuscarEstudiante();
	}
	protected void handle_btnEliminar_actionPerformed(ActionEvent e) {
		int nFila = dtEstudiantes.getSelectedRow();
		int nID = Integer.parseInt(this.dtEstudiantes.getValueAt(nFila, 0).toString());
		if (nID > 0) {
			this.EliminarRegistro(nID);
			//dtEstudiantes.remove(nFila);
		}
		
	}
}
