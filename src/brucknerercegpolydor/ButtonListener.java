package brucknerercegpolydor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	private GUI g;
	
	public ButtonListener(GUI g){
		this.g = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//encrypt-Button
		try {
			if (this.g.getButtonB1(e)) {
				//holt sich aus der Methode getCipher das Verschlüsselungsverfahren, nachdem verschlüsselt werden soll
				MonoAlphabeticCipher mac = this.g.getCipher();
				//Setzt den verschlüsselten Text in das zweite Feld
				this.g.setText2(mac.encrypt(this.g.getText1()));
			}
			//decrypt-Button
			if (this.g.getButtonB2(e)) {
				//holt sich aus der Methode getCipher das Entschlüsselungsverfahren, nachdem entschlüsselt werden soll
				MonoAlphabeticCipher mac = this.g.getCipher();
				//Setzt den entschlüsselten Text in das zweite Feld
				this.g.setText2(mac.decrypt(this.g.getText1()));
			}
		} catch (NullPointerException e1) {

		}
	}
}
