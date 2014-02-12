package brucknerercegpolydor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	@SuppressWarnings("unused") 
	private Cipher c;
	@SuppressWarnings("unused")
	private ShiftCipher sc;
	@SuppressWarnings("unused")
	private MonoalphabeticCipher mac;
	@SuppressWarnings("unused")
	private SubstitutionsCipher sbc;
	@SuppressWarnings("unused")
	private KeywordCipher kc;
	
	
	private JFrame f;
	private JTextArea ta;
	private JButton jb1;
	private JButton jb2;
	private JLabel jl;
	
	private Container button;
	private Container text;
	
	public GUI(Cipher c,ShiftCipher sc,MonoalphabeticCipher mac,SubstitutionsCipher sbc,KeywordCipher kc){
		
		this.c = c;
		this.sc = sc;
		this.mac = mac;
		this.sbc = sbc;
		this.kc = kc;
		
		this.f = new JFrame("Verschlüsselung");
		this.ta = new JTextArea();
		this.jb1 = new JButton("Verschlüsseln");
		this.jb2 = new JButton("Entschlüsseln");
		this.jl = new JLabel();
		
		
		this.button = new Container();
		this.text = new Container();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setVisible(true);
	}
	public String getText() {
		return ta.getText();
	}
	public boolean getButtonB1(ActionEvent e){
        if(e.getSource() == this.jb1)return true;
        return false;
    }
	public boolean getButtonB2(ActionEvent e){
        if(e.getSource() == this.jb2)return true;
        return false;
    }
	public void main (String[]args){
		
	}
}
