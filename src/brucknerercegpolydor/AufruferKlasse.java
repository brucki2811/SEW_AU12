package brucknerercegpolydor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AufruferKlasse implements ActionListener{

	private GUI g;
	private Cipher c;
	@SuppressWarnings("unused")
	private ShiftCipher sc;
	@SuppressWarnings("unused")
	private MonoAlphabeticCipher mac;
	@SuppressWarnings("unused")
	private SubstitutionCipher sbc;
	@SuppressWarnings("unused")
	private KeywordCipher kc;
	
	
	
	public AufruferKlasse(){
		// this.g = new GUI();
	}
	public static void main (String[]args){
		AufruferKlasse ak =  new AufruferKlasse();
	}
	public void actionPerformed(ActionEvent e){
		if(this.g.getButtonB1(e)){
			this.g.setText1(g.getText2());
		}
		if(this.g.getButtonB2(e)){
			this.g.setText2(g.getText1());
		}
	}
	
}
