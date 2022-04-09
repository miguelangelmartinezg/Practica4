package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Formularios.frmLogin;
import Formularios.frmRegistro;
import Modelo.Conexion;

//En mi clase Implemento ActionListener
public class RegistroController   implements ActionListener  {
	private frmLogin frmLogin;
	private frmRegistro ofrmRegistrar;
	private Conexion MiConexion;
	
	public RegistroController(frmLogin oFrmLogin){
		this.frmLogin = oFrmLogin;
		this.MiConexion = oFrmLogin.oCon;
	}
	/*
	public RegistroController(frmRegistro oFrmRegistro){
		this.ofrmRegistrar = oFrmRegistro;
		
		
	}
	*/
	

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource().equals(frmLogin.getBtnRegistrase())) {
			ofrmRegistrar = new frmRegistro(this.MiConexion);
			ofrmRegistrar.setVisible(true);
			frmLogin.setVisible(false);
			
		}
		
	}
}
