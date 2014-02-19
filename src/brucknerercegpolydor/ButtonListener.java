package brucknerercegpolydor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	private GUI g;
	
	public ButtonListener(GUI g){
		this.g = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		//encrypt-Button
		if(this.g.getButtonB1(e)){
			MonoAlphabeticCipher mac = this.g.getCipher();
			//Setzt den verschl�sselten Text in das zweite Feld
			this.g.setText2(mac.encrypt(this.g.getText1()));
		}
		//decrypt-Button
		if(this.g.getButtonB2(e)){
			MonoAlphabeticCipher mac = this.g.getCipher();
			//Setzt den entschl�sselten Text in das zweite Feld
			this.g.setText2(mac.decrypt(this.g.getText1()));
		}
	}
}