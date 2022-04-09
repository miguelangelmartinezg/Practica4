//Nombre:    Miguel Angel Martienez Gonzalez.
//Matricula: 2021-1698.


package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LoginController;
import Controller.RegistroController;
import Modelo.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class frmLogin extends JFrame implements ActionListener, FocusListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnEntrar;
	private JPasswordField txtPassword;
	private JButton btnRegistrase;
	public static  Conexion oCon;
	//INSTANCIO MI OBJETO DE LA CLASE CONEXION
	
	//DECLARO MI OBJETODE TIPO CONTROLLER
	LoginController oLoginController;
	RegistroController oRegistroController;
	private JLabel lblMensaje;
	private JLabel lblMensaje2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					oCon = new Conexion();
					//oCon.getConection();
					
					Conexion.getConection();
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		
		Inicializar();
		setLocationRelativeTo(null);
	}
	private void Inicializar() {
		//INSTACIO MI OBJETO DE LA CLASE LOGINCONTROLLER
				oLoginController = new LoginController(this);
				oRegistroController = new RegistroController(this);
				
				setTitle("Login");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 464, 700);
				contentPane = new JPanel();
				contentPane.setBackground(new Color(135, 206, 235));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(135, 206, 235));
				panel.setBounds(10, 10, 430, 643);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Usuario");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel.setBounds(169, 162, 84, 27);
				panel.add(lblNewLabel);
				
				txtUsuario = new JTextField();
				txtUsuario.addFocusListener(this);
				txtUsuario.setBounds(29, 193, 366, 29);
				panel.add(txtUsuario);
				txtUsuario.setColumns(10);
				
				JLabel lblPassword = new JLabel("Password");
				lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblPassword.setBounds(166, 246, 104, 27);
				panel.add(lblPassword);
				
				btnEntrar = new JButton("ENTRAR");
				btnEntrar.addActionListener(this);
				btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 20));
				//btnEntrar.addActionListener(oRegistroController);
				btnEntrar.setBounds(119, 362, 190, 54);
				panel.add(btnEntrar);
				
				txtPassword = new JPasswordField();
				txtPassword.setBounds(29, 283, 366, 27);
				panel.add(txtPassword);
				
				btnRegistrase = new JButton("Registrase");
				btnRegistrase.addActionListener(this);
				btnRegistrase.setForeground(new Color(0, 0, 255));
				btnRegistrase.setBackground(new Color(135, 206, 235));
				btnRegistrase.setFont(new Font("Maiandra GD", Font.BOLD | Font.ITALIC, 16));
				btnRegistrase.setBounds(119, 444, 190, 54);
				btnRegistrase.addActionListener(oRegistroController);
				btnRegistrase.setOpaque(false);
				btnRegistrase.setContentAreaFilled(false);
				btnRegistrase.setBorderPainted(false);
				panel.add(btnRegistrase);
				
				lblMensaje = new JLabel("New label");
				lblMensaje.setForeground(new Color(255, 0, 0));
				lblMensaje.setBounds(29, 225, 366, 11);
				lblMensaje.setVisible(false);
				panel.add(lblMensaje);
				
				lblMensaje2 = new JLabel("New label");
				lblMensaje2.setForeground(Color.RED);
				lblMensaje2.setBounds(29, 316, 359, 13);
				lblMensaje2.setVisible(false);
				panel.add(lblMensaje2);
	}
	public JLabel getLblMensaje2() {
		return lblMensaje2;
	}

	public void setLblMensaje2(JLabel lblMensaje2) {
		this.lblMensaje2 = lblMensaje2;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public void setLblMensaje(JLabel lblMensaje) {
		this.lblMensaje = lblMensaje;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public void setBtnEntrar(JButton btnEntrar) {
		this.btnEntrar = btnEntrar;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JButton getBtnRegistrase() {
		return btnRegistrase;
	}

	public void setBtnRegistrase(JButton btnRegistrase) {
		this.btnRegistrase = btnRegistrase;
	}

	private void ValidarUsuario(String cUsuario) {
		
		boolean datos = false;
		String cMiUsuario = "";
		if (!cUsuario.isEmpty()) {
			cMiUsuario = oCon.ConsultarUsuario("Select password from estudiantes where UserName = '" + cUsuario + "'");
			
			if (!cMiUsuario.isEmpty()) {
				
				lblMensaje.setVisible(false);
			}
			else
			{
				getLblMensaje().setText("Este Usuario no Existe, Favor Revisar.");
				lblMensaje.setVisible(true);
				
			}
		}
		
	}
	private void ValidarCredenciales(String cUsuario,String cPassword) {
		boolean datos = false;
		
		if ((!cUsuario.isEmpty()) && (!cPassword.isEmpty())) {
			datos = oCon.Consultar("Select password from estudiantes where UserName = '" + cUsuario + "' and password = '" + cPassword + "'" );
			if (datos) {
				frmEstudiantesRegistrados ofrmRegistrado = new frmEstudiantesRegistrados(oCon);
				ofrmRegistrado.setVisible(true);
				this.setVisible(false);
			}
			else {
				
				
				JOptionPane.showMessageDialog(null,"El Password es Incorrecto, Favor Revisar!!!");
				
			    
			}
		}else if (cUsuario.isEmpty()) {
			getLblMensaje().setText("Debe Introducir un Usuario, Si No tiene uno, Favor Registrarse.");
			lblMensaje.setVisible(true);
		}else if(cPassword.isEmpty()) {
			lblMensaje.setVisible(false);
			getLblMensaje2().setText("Debe Digitar su Password, Si no se ha Registrado, Favor Hacerlo.");
			lblMensaje2.setVisible(true);
		}else {
			lblMensaje2.setVisible(false);
		}
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		
		this.ValidarCredenciales(this.getTxtUsuario().getText(),getTxtPassword().getText());
		
	}
	protected void handle_btnEntrar_actionPerformed(ActionEvent e) {
	   
		
	}
	protected void handle_btnRegistrase_actionPerformed(ActionEvent e) {
		
	}
	public void focusGained(FocusEvent e) {
	}
	public void focusLost(FocusEvent e) {
		if (e.getSource() == txtUsuario) {
			handle_txtUsuario_focusLost(e);
		}
	}
	protected void handle_txtUsuario_focusLost(FocusEvent e) {
	
		this.ValidarUsuario(this.getTxtUsuario().getText());
	}
}
