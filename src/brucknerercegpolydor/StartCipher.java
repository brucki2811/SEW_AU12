package brucknerercegpolydor;

/**
 * @author Michael Bruckner
 * @version 2014.2.18
 */

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartCipher implements ActionListener, ListSelectionListener {
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
	private JTextField tf1;
	private JButton jb1;
	private JButton jb2;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JComboBox<String> drop;
	
	private Container button;
	private Container text;
	private Container dropdown;
	
	
	public StartCipher(){

		this.stc = stc;

		this.f = new JFrame("Verschlüsselung/Entschlüsselung");
		this.ta1 = new JTextArea();
		this.ta2 = new JTextArea();
		this.tf1 = new JTextField();
		this.jb1 = new JButton("Verschlüsseln");
		this.jb2 = new JButton("Entschlüsseln");
		String[] ciphers = {"Keyword Cipher","Shift Cipher","Substitution Cipher"};
		this.drop = new JComboBox<String>();
		this.l1 = new JLabel("Cipherauswahl:");
		this.l2 = new JLabel("Verschieben der Zeichen(Zahl):");
		this.l3 = new JLabel("Eingabe:");
		this.l4 = new JLabel("Ausgabe:");
		
		this.button = new Container();
		this.text = new Container();
		this.dropdown = new Container();

		this.f.setLayout(new BorderLayout());
		this.button.setLayout(new GridLayout(0,2));
		this.text.setLayout(new GridLayout(4,0));
		this.dropdown.setLayout(new GridLayout(2,2));
		
		this.button.add(this.jb1);
		this.button.add(this.jb2);
		
		this.dropdown.add(this.l1);
		this.dropdown.add(this.l2);
		this.dropdown.add(this.drop);
		this.dropdown.add(this.tf1);
		
		this.text.add(this.l3);
		this.text.add(this.ta1);
		this.text.add(this.l4);
		this.text.add(this.ta2);

		this.f.add(this.dropdown, BorderLayout.NORTH);
		this.f.add(this.button, BorderLayout.SOUTH);
		this.f.add(this.text, BorderLayout.CENTER);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setVisible(true);
        
	}

	public String getText1() {
		return ta1.getText();
	}
	
	
	public String getText2() {
		return ta2.getText();
	}
	
	
	public void setText1(String text) {
		ta1.setText(text);
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
	
	
	public void actionPerformed(ActionEvent e){
		if(this.stc.getButtonB1(e)){
			this.stc.setText1(stc.getText2());
		}
		if(this.stc.getButtonB2(e)){
			this.stc.setText2(stc.getText1());
		}
	}
		
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
	}
	
	
	public static void main (String[]args){
		StartCipher stc = new StartCipher();
		
	}
}
