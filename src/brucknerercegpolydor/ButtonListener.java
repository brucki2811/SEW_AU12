package brucknerercegpolydor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	private GUI g;
	private MonoAlphabeticCipher mac;
	
	public ButtonListener(){
		this.g = new GUI(this.mac,this);
		this.mac = new MonoAlphabeticCipher();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("TEST");
		if(this.g.getButtonB1(e)){
			this.g.getCipher();
			this.g.setText2(this.mac.decrypt(this.g.getText1()));
		}
		if(this.g.getButtonB2(e)){
			System.out.println("TEST");
			this.g.getCipher();
			System.out.println("TEST");
			this.g.setText2(this.mac.encrypt(this.g.getText1()));
		}
	}
}
