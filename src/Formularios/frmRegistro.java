//Nombre:    Miguel Angel Martienez Gonzalez.
//Matricula: 2021-1698.

//

package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;
import Modelo.Estudiante;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class frmRegistro extends JFrame implements ActionListener, FocusListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JLabel lblNombre_2;
	private JLabel lblNombre_3;
	private JTextField txtEmail;
	private JLabel lblNombre_4;
	private JTextField txtUsuario;
	private JLabel lblNombre_5;
	private JLabel lblNombre_6;
	private JButton btnRegistrase;
	private JButton btnSalir;
	private JLabel lblNombre_7;
	private JLabel lblNombreReq;
	private JLabel lblApellidoReq;
	private JLabel lblTelReq;
	private JLabel lblEmailRec;
	private JLabel lblUsuarioReq;
	private JLabel lblPasswordReq;
	private JLabel lblConfirmarPas;
	private JTextField txtTelefono;
	private Conexion MiConexion;
	private Estudiante miEstudiante;
	private JPasswordField txtPassword;
	private JPasswordField txtConfPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistro frame = new frmRegistro();
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
	public frmRegistro() {
		this.Inicializar();
		setLocationRelativeTo(null);
		
	}
	public frmRegistro(Conexion oCon) {
		this.MiConexion = oCon;
		this.Inicializar();
		setLocationRelativeTo(null);
	}
	public frmRegistro(Conexion oCon,Estudiante oEstudiante) {
		this.MiConexion = oCon;
		this.miEstudiante = oEstudiante;
		this.Inicializar();		
		this.CargarEstudiante();
		btnRegistrase.setText("Actualizar");
		setLocationRelativeTo(null);
		
		
		
		
	}
	private void Inicializar() {
		setTitle("Registrar");
		setBackground(new Color(135, 206, 235));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 538);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(23, 89, 84, 27);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(91, 90, 312, 29);
		panel.add(txtNombre);
		
		JLabel lblNombre_1 = new JLabel("Apellido");
		lblNombre_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_1.setBounds(412, 89, 84, 27);
		panel.add(lblNombre_1);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(483, 90, 326, 29);
		panel.add(txtApellido);
		
		lblNombre_2 = new JLabel("Telefono");
		lblNombre_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_2.setBounds(10, 144, 84, 27);
		panel.add(lblNombre_2);
		
		lblNombre_3 = new JLabel("Email");
		lblNombre_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_3.setBounds(284, 144, 84, 27);
		panel.add(lblNombre_3);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(355, 145, 454, 29);
		panel.add(txtEmail);
		
		lblNombre_4 = new JLabel("Usuario");
		lblNombre_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_4.setBounds(364, 196, 84, 27);
		panel.add(lblNombre_4);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(236, 218, 326, 29);
		panel.add(txtUsuario);
		
		lblNombre_5 = new JLabel("Password");
		lblNombre_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_5.setBounds(353, 255, 84, 27);
		panel.add(lblNombre_5);
		
		lblNombre_6 = new JLabel("Confirmar Password");
		lblNombre_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_6.setBounds(304, 315, 184, 27);
		panel.add(lblNombre_6);
		
		btnRegistrase = new JButton("Registrase");
		btnRegistrase.addActionListener(this);
		btnRegistrase.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrase.setBounds(147, 388, 190, 54);
		//btnRegistrase.addActionListener(oRegistroController,);
		panel.add(btnRegistrase);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalir.setBounds(478, 388, 190, 54);
		panel.add(btnSalir);
		
		lblNombre_7 = new JLabel("Registro de Clientes");
		lblNombre_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_7.setBounds(23, 10, 212, 27);
		panel.add(lblNombre_7);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(91, 144, 183, 25);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(236, 278, 326, 27);
		panel.add(txtPassword);
		
		txtConfPassword = new JPasswordField();
		txtConfPassword.addFocusListener(this);
		txtConfPassword.setBounds(236, 338, 326, 27);
		panel.add(txtConfPassword);
		
		lblNombreReq = new JLabel("");
		lblNombreReq.setForeground(Color.RED);
		lblNombreReq.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombreReq.setBounds(101, 121, 184, 13);
		//lblNombreReq.setVisible(false);
		panel.add(lblNombreReq);
		
		lblApellidoReq = new JLabel("");
		lblApellidoReq.setForeground(Color.RED);
		lblApellidoReq.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblApellidoReq.setBounds(483, 122, 184, 13);
		//lblApellidoReq.setVisible(false);
		panel.add(lblApellidoReq);
		
		lblTelReq = new JLabel("");
		lblTelReq.setForeground(Color.RED);
		lblTelReq.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTelReq.setBounds(91, 165, 184, 13);
		//lblTelReq.setVisible(false);
		panel.add(lblTelReq);
		
		lblEmailRec = new JLabel("");
		lblEmailRec.setForeground(Color.RED);
		lblEmailRec.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEmailRec.setBounds(355, 173, 184, 13);
		//lblEmailRec.setVisible(false);
		panel.add(lblEmailRec);
		
		lblUsuarioReq = new JLabel("");
		lblUsuarioReq.setForeground(Color.RED);
		lblUsuarioReq.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUsuarioReq.setBounds(563, 226, 184, 13);
		//lblUsuarioReq.setVisible(false);
		panel.add(lblUsuarioReq);
		
		lblPasswordReq = new JLabel("");
		lblPasswordReq.setForeground(Color.RED);
		lblPasswordReq.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPasswordReq.setBounds(563, 285, 184, 13);
		//lblPasswordReq.setVisible(false);
		panel.add(lblPasswordReq);
		
		lblConfirmarPas = new JLabel();
		lblConfirmarPas.setForeground(Color.RED);
		lblConfirmarPas.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblConfirmarPas.setBounds(236, 363, 356, 15);
		//lblConfirmarPas.setVisible(false);
		panel.add(lblConfirmarPas);
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}
	
	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}
	
	public JPasswordField getTxtConfPassword() {
		return txtConfPassword;
	}

	public void setTxtConfPassword(JPasswordField txtConfPassword) {
		this.txtConfPassword = txtConfPassword;
	}
	
	public JLabel getLblNombreReq() {
		return lblNombreReq;
	}

	public void setLblNombreReq(JLabel lblNombreReq) {
		this.lblNombreReq = lblNombreReq;
	}

	public JLabel getLblApellidoReq() {
		return lblApellidoReq;
	}

	public void setLblApellidoReq(JLabel lblApellidoReq) {
		this.lblApellidoReq = lblApellidoReq;
	}

	public JLabel getLblTelReq() {
		return lblTelReq;
	}

	public void setLblTelReq(JLabel lblTelReq) {
		this.lblTelReq = lblTelReq;
	}

	public JLabel getLblUsuarioReq() {
		return lblUsuarioReq;
	}

	public void setLblUsuarioReq(JLabel lblUsuarioReq) {
		this.lblUsuarioReq = lblUsuarioReq;
	}

	public JLabel getLblPasswordReq() {
		return lblPasswordReq;
	}

	public void setLblPasswordReq(JLabel lblPasswordReq) {
		this.lblPasswordReq = lblPasswordReq;
	}

	public JLabel getLblConfirmarPas() {
		return lblConfirmarPas;
	}

	public void setLblConfirmarPas(JLabel lblConfirmarPas) {
		this.lblConfirmarPas = lblConfirmarPas;
	}

	public JButton getBtnRegistrase() {
		return btnRegistrase;
	}

	public void setBtnRegistrase(JButton btnRegistrase) {
		this.btnRegistrase = btnRegistrase;
	}

	
	
	public JButton getBtnSalir() {
		return btnSalir;
	}
	private void Limpiar() {
		this.getTxtNombre().setText("");
		  this.getTxtApellido().setText("");
		  this.getTxtTelefono().setText("");
		  this.getTxtEmail().setText("");
		  this.getTxtUsuario().setText("");
		  this.getTxtPassword().setText("");
	}
	private boolean ValidaCampos() {
		boolean Validado = false;
		
		
	    if (this.getTxtNombre().getText().isEmpty()) {
	    	
			lblNombreReq.setText("Este Campo es Obligatorio.");
			lblNombreReq.setVisible(true);
			return Validado = false;
			
		} else {
			lblNombreReq.setVisible(false);
			Validado = true;
		}
       if (this.getTxtApellido().getText().isEmpty()) {
	    	
			lblApellidoReq.setText("Este Campo es Obligatorio.");
			lblApellidoReq.setVisible(true);
			return Validado = false;
		} else {
			lblApellidoReq.setVisible(false);
			Validado = true;
		}
       if (this.getTxtTelefono().getText().isEmpty()) {
	    	
			lblTelReq.setText("Este Campo es Obligatorio.");
			lblTelReq.setVisible(true);
			return Validado = false;
		} else {
			lblTelReq.setVisible(false);
			Validado = true;
		}
       if (this.getTxtEmail().getText().isEmpty()) {
	    	
			lblEmailRec.setText("Este Campo es Obligatorio.");
			lblEmailRec.setVisible(true);
			return Validado = false;
		} else if(!this.getTxtEmail().getText().contains("@") || !this.getTxtEmail().getText().contains(".")) {
			
			lblEmailRec.setText("Correo no Valido, Favor Revisar");
			lblEmailRec.setVisible(true);
			return Validado = false;
			
		}
       else {
			lblEmailRec.setVisible(false);
			Validado = true;
		}
       
       if (this.getTxtUsuario().getText().isEmpty()) {
	    	
			lblUsuarioReq.setText("Este Campo es Obligatorio.");
			lblUsuarioReq.setVisible(true);
			return Validado = false;
		} else {
			lblUsuarioReq.setVisible(false);
			Validado = true;
		}
       if (this.getTxtPassword().getText().isEmpty()) {
	    	
			lblPasswordReq.setText("Este Campo es Obligatorio.");
			lblPasswordReq.setVisible(true);
			return Validado = false;
		} else {
			lblPasswordReq.setVisible(false);
			Validado = true;
		}
		
		
		
		return Validado;
	}
	//VALIDAR PASSWORD
	public boolean ConfirmaPassword(String cPassword1, String cPassword2) {
		boolean Confirmado = false;
		if (!cPassword1.isEmpty() && !cPassword2.isEmpty()) {
			
			if (cPassword2.equals(cPassword1)) {
				lblConfirmarPas.setVisible(false);
				Confirmado = true;
			} else {
				//JOptionPane.showMessageDialog(null,"El Password No coincide, Favor Confirmar!!");
				
				//txtConfPassword.requestFocus();
				lblConfirmarPas.setText("El Password No coincide, Favor Confirmar!!");
				lblConfirmarPas.setVisible(true);
				
				Confirmado = false;
				

			}
			
		} 
		
		return Confirmado;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}
	//PARA ACTUALIZAR LOS ESTUDIANTES
	private int Actualizar(int nID,String cNombre,String cApellido,String cTelefono,String cEmail,String cUsuario,String cPassword) {
		int nResultado = 0;
		nResultado = MiConexion.SetInformacion("update `programacion1`.`estudiantes` set `nombre` = '" + cNombre + "',`apellido` = '" + cApellido +
				"',`telefono` = '" +cTelefono+"',`email` = '"+ cEmail + "', `UserName` = '" + cUsuario + "',`Password` = '" + cPassword + "' where IdEstudiante = " + nID );
		
		return nResultado;
	}
	//PARA REGISTRAR LOS ESTUDIANTES
	private int Registrar(String cNombre,String cApellido,String cTelefono,String cEmail,String cUsuario,String cPassword) {
		
		int nResultado = 0;
		if (this.ValidaCampos()) {
			 if (this.ConfirmaPassword(txtPassword.getText(),txtConfPassword.getText())) {
					
					nResultado = MiConexion.SetInformacion("Insert Into `programacion1`.`estudiantes`(`nombre`,`apellido`,`telefono`,`email`,`UserName`,`Password`)"
							+ " values ('" + cNombre + "','" + cApellido + "','" + cTelefono + "','" + cEmail + "','" + cUsuario + "','" + cPassword + "')");
				
			}
		}
		
		
		
		
		return nResultado;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrase) {
			handle_btnRegistrase_actionPerformed(e);
		}
		if (e.getSource() == btnSalir) {
			handle_btnSalir_actionPerformed(e);
		}
	}
	protected void handle_btnSalir_actionPerformed(ActionEvent e) {
		/*frmLogin oFrmLogin = new frmLogin();
		oFrmLogin.setVisible(true);
		this.setVisible(false);*/
		frmEstudiantesRegistrados oFrmRegistrados = new frmEstudiantesRegistrados(MiConexion);
		  oFrmRegistrados.setVisible(true);
		  this.setVisible(false);
	}
	protected void handle_btnRegistrase_actionPerformed(ActionEvent e) {
		
		String cModo = btnRegistrase.getText();
		switch (cModo) {
		case "Registrase":
			int nResultado =	this.Registrar(this.getTxtNombre().getText(), this.getTxtApellido().getText(),this.getTxtTelefono().getText(), this.getTxtEmail().getText(),
					this.getTxtUsuario().getText(), this.getTxtPassword().getText());
			
		  if(nResultado > 0) {
			  
			  JOptionPane.showMessageDialog(null,"Registro Exitoso!!!");
			  frmEstudiantesRegistrados oFrmRegistrados = new frmEstudiantesRegistrados(MiConexion);
			  oFrmRegistrados.setVisible(true);
			  this.setVisible(false);
			  this.Limpiar();
			  
		  }			
			break;
			
		case "Actualizar":
			int nActualizado = this.Actualizar(miEstudiante.getIdEstudiante(), this.getTxtNombre().getText(), this.getTxtApellido().getText(),this.getTxtTelefono().getText(), this.getTxtEmail().getText(),
					this.getTxtUsuario().getText(), this.getTxtPassword().getText());
			if(nActualizado > 0) {
				  
				  JOptionPane.showMessageDialog(null,"Estudiante Actualizado Correctamente!!!");
				  frmEstudiantesRegistrados oFrmRegistrados = new frmEstudiantesRegistrados(MiConexion);
				  oFrmRegistrados.setVisible(true);
				  this.setVisible(false);
				  this.Limpiar();
				  
			  }			
			
			break;
		
		}


		/*	
		if (btnRegistrase.getText() == "Registrase") {
			int nResultado =	this.Registrar(this.getTxtNombre().getText(), this.getTxtApellido().getText(),this.getTxtTelefono().getText(), this.getTxtEmail().getText(),
					this.getTxtUsuario().getText(), this.getTxtPassword().getText());
			
		  if(nResultado > 0) {
			  
			  JOptionPane.showMessageDialog(null,"Registro Exitoso!!!");
			  frmEstudiantesRegistrados oFrmRegistrados = new frmEstudiantesRegistrados(MiConexion);
			  oFrmRegistrados.setVisible(true);
			  this.setVisible(false);
			  this.Limpiar();
			  
		  }
		}
		*/
	  
	}
	protected void CargarEstudiante() {
		this.getTxtNombre().setText(miEstudiante.getNombre());
		this.getTxtApellido().setText(miEstudiante.getApellido());
		this.getTxtTelefono().setText(miEstudiante.getTelefono());
		this.getTxtEmail().setText(miEstudiante.getEmail());
		this.getTxtUsuario().setText(miEstudiante.getUserName());
		this.getTxtPassword().setText(miEstudiante.getPassword());
	}
	public void focusGained(FocusEvent e) {
	}
	public void focusLost(FocusEvent e) {
		if (e.getSource() == txtConfPassword) {
			handle_txtConfPassword_focusLost(e);
		}
	}
	protected void handle_txtConfPassword_focusLost(FocusEvent e) {
		this.ConfirmaPassword(txtPassword.getText(),txtConfPassword.getText());
	}
}
