package brucknerercegpolydor;

/**
 * @author Michael Bruckner
 * @version 2014.2.17
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartCipher implements ActionListener {
	private StartCipher stc;
	@SuppressWarnings("unused") 
	private Cipher c;
	@SuppressWarnings("unused")
	private ShiftCipher sc;
	@SuppressWarnings("unused")
	private MonoAlphabeticCipher mac;
	@SuppressWarnings("unused")
	private SubstitutionCipher sbc;
	@SuppressWarnings("unused")
	private KeywordCipher kc;
	
	
	private JFrame f;
	private JTextArea ta1;
	private JTextArea ta2;
	private JButton jb1;
	private JButton jb2;
	private JLabel jl;
	
	private Container button;
	private Container text;
	


	public StartCipher(){

		this.stc = stc;

		this.f = new JFrame("Verschlüsselung/Entschlüsselung");
		this.ta1 = new JTextArea();
		this.ta2 = new JTextArea();
		this.jb1 = new JButton("Verschlüsseln");
		this.jb2 = new JButton("Entschlüsseln");

		this.jl = new JLabel();
		
		
		this.button = new Container();
		this.text = new Container();
		
		this.f.setLayout(new BorderLayout());
		this.button.setLayout(new GridLayout(0,2));
		this.text.setLayout(new GridLayout(0,3));
		
		this.button.add(this.jb1);
		this.button.add(this.jb2);
		
		this.text.add(this.ta1, BorderLayout.WEST);
		this.text.add(this.jl, BorderLayout.CENTER);
		this.text.add(this.ta2, BorderLayout.EAST);
		
		
		this.f.add(this.button, BorderLayout.SOUTH);
		this.f.add(this.text);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setVisible(true);
        
	}
	private Component drawLine(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getText1() {
		return ta1.getText();
	}
	public String getText2() {
		return ta2.getText();
	}
	public void setText1(String text1) {
		ta1.setText(text1);
	}
	public void setText2(String text2) {
		ta2.setText(text2);
	}
	public boolean getButtonB1(ActionEvent e){
        if(e.getSource() == this.jb1)return true;
        return false;
    }
	public boolean getButtonB2(ActionEvent e){
        if(e.getSource() == this.jb2)return true;
        return false;
    }
	public static void main (String[]args){
		StartCipher stc = new StartCipher();
	}
	public void actionPerformed(ActionEvent e){
		if(this.stc.getButtonB1(e)){
			this.stc.setText1(stc.getText2());
		}
		if(this.stc.getButtonB2(e)){
			this.stc.setText2(stc.getText1());
		}
	}
}
