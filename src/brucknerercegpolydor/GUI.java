package brucknerercegpolydor;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GUI {
	@SuppressWarnings("unused")
	private ShiftCipher sc;
	@SuppressWarnings("unused")
	private MonoAlphabeticCipher mac;
	@SuppressWarnings("unused")
	private SubstitutionCipher sbc;
	private KeywordCipher kc;
	private GUI g;
	private ButtonListener bl;
	
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
	
	
	public GUI(){
		this.bl = new ButtonListener(this);
		
		this.f = new JFrame("Verschlüsselung/Entschlüsselung");
		this.ta1 = new JTextArea();
		this.ta2 = new JTextArea();
		this.tf1 = new JTextField();
		this.jb1 = new JButton("Verschlüsseln");
		this.jb2 = new JButton("Entschlüsseln");
		
		String ComboBoxList[] = {"Keyword Cipher","Shift Cipher","Substitution Cipher"};
		this.drop = new JComboBox<String>(ComboBoxList);
		
		
		this.l1 = new JLabel("Cipherauswahl:");
		this.l2 = new JLabel("Keyword setzen(zB. 'Abend')");
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
		
		this.jb1.addActionListener(bl);
		this.jb2.addActionListener(bl);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(700, 500);
        f.setVisible(true);
        
        //ComboBox added ItemListener
        drop.addItemListener(new ItemListener() {
        	/**
        	 * Soll bei der Auswahl des Ciphers, in der Dropbox, die richtige Hilfestellung im Label geben.
        	 */
        	@Override
			public void itemStateChanged(ItemEvent e) {
        	//switch-case stellt fest was ausgewählt wurde und setzt dann den Text in das JLabel.
        		//zB: KeywordCipher ---> Keyword setzen(zB. 'Abend')
				switch (drop.getSelectedItem().toString()){
				
				case "Keyword Cipher": 
					l2.setText("Keyword setzen(zB. 'Abend')");
					break;
				case "Shift Cipher":
					l2.setText("Verschieben der Zeichen(Shift Cipher):");
					break;
				case "Substitution Cipher":
					l2.setText("Geheimalphabet angeben (bitte 30 verschiedene Zeichen)");
				}
				
			}
		});
	}

	/**
	 * Die Methode getText1 holt sich aus dem Eingabe TextArea den Text.
	 * */
	public String getText1() {
		return ta1.getText();
	}
	
	/**
	 * Die Methode getText2 holt sich aus dem Ausgabe TextArea den Text.
	 * */
	public String getText2() {
		return ta2.getText();
	}
	/**
	 * Die Methode getText3 holt sich aus dem TextField für die Cipher Eingaben die Werte(Text oder Zahl).
	 * */
	
	public String getText3() {
		return tf1.getText();
	}
	/**
	 * Die Methode setText1 legt den Text, im TextArea Eingabe, fest.
	 * */
	public void setText1(String text1) {
		ta1.setText(text1);
	}
	/**
	 * Die Methode setText2 legt den Text, im TextArea Ausgabe, fest.
	 * */
	
	public void setText2(String text2) {
		ta2.setText(text2);
	}
	/**
	 * Die Methode setText3 legt den Text, im TextField für die Cipher Eingabe, fest.
	 * */
	public void setText3(String text3) {
		tf1.setText(text3);
	}
	
	/**
	 * ActionListener
	 * */
	public boolean getButtonB1(ActionEvent e){
        if(e.getSource() == this.jb1)return true;
        return false;
    }
	/**
	 * ActionListener
	 * */
	
	public boolean getButtonB2(ActionEvent e){
        if(e.getSource() == this.jb2)return true;
        return false;
    }
	
	/**
	 * Die Methode getSelectedIndex gibt zurück was ausgewählt wurde.
	 * */
	public int getSelectedIndex() {
		return this.drop.getSelectedIndex();
	}	
	
	/*Die Methode getCipher soll mittels switch-case feststellen, welcher Cipher in der Dropdown
	 * ausgewählt wurde. 
	 * */
	public MonoAlphabeticCipher getCipher() {
		try {
			switch (this.getSelectedIndex()) {
				case 0:
					this.kc = new KeywordCipher(this.getText3());
					return kc;
				case 1:
					this.sc = new ShiftCipher(Integer.parseInt(this.getText3()));
					return sc;
				case 2:
					this.sbc = new SubstitutionCipher(this.getText3());
					return sbc;

			}
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Ihre Eingabe ist fehlerhaft");
		}
		return null;
	}
}
