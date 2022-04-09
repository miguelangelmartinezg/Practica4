package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Formularios.frmLogin;

public class LoginController  implements ActionListener {
	
	private frmLogin frmLogin;
	
	public LoginController(frmLogin oFrmLogin){
		this.frmLogin = oFrmLogin;
		
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource().equals(frmLogin.getBtnEntrar())) {
			
		}
		
	}

}
