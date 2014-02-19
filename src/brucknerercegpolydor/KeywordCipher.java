package brucknerercegpolydor;

import java.util.Locale;

/**
 * 
 * @author Stefan Erceg
 * @version 2014.02.12
 */

public class KeywordCipher extends MonoAlphabeticCipher {
	
	/**
	 * im Konstruktor wird die Methode "setKeyword" ausgef�hrt
	 * @param keyword ist das eingegebene Schl�sselwort bzw. Kennwort
	 */
	
	public KeywordCipher(String keyword) {
		setKeyword(keyword);
	}
	
	/**
	 * die Methode f�gt das eingebene Schl�sselwort am Beginn des Alphabets hinzu, 
	 * danach folgen alle Buchstaben des Alphabets, die nicht im Schl�sselwort vorkommen
	 * @param keyword ist das eingegebene Schl�sselwort bzw. Kennwort
	 */
	
	public void setKeyword(String keyword) {
		
		/* das verschl�sselte Alphabet wird in einem String abgespeichert */
		String encrypted;
		
		/* das eingegebene Schl�sselwort wird zu Beginn des Alphabets hinzugef�gt */
		encrypted = keyword.toLowerCase(Locale.GERMAN);
		
		/* - die for-Schleife geht jeden Buchstaben des Schl�sselworts durch
		 * - falls bestimmte Buchstaben im Schl�sselwort mehrfach vorkommen, wird eine IllegalArgumentException geworfen */
		for (int i=0; i < keyword.length()-1; i++) {
			if(keyword.indexOf(keyword.toCharArray()[i]) != keyword.lastIndexOf(keyword.toCharArray()[i])) {
				throw new IllegalArgumentException("Buchstaben d�rfen im Wort jeweils nur einmal vorkommen");
			}
		}
		/* falls im Schl�sselwort nicht nur Buchstaben, sondern auch andere Zeichen (z.B. Zahlen) vorkommen, wird eine IllegalArgumentException geworfen */
		for (int i=0; i < keyword.length(); i++) {
			if(!this.getSecretAlphabet().contains("" + keyword.charAt(i))) {
				throw new IllegalArgumentException("Im Schl�sselwort d�rfen nur Buchstaben vorkommen");
			}
		}
		
		/* - die for-Schleife geht jeden Buchstaben des Alphabets durch
		 * - falls der Buchstabe nicht im Schl�sselwort vorgekommen ist, wird er am Ende des verschl�sselten Alphabets hinzugef�gt */
		for(char c : this.getSecretAlphabet().toCharArray()) {
			if (encrypted.indexOf(c) == -1) {
				encrypted += "" + c;
			}
		}
		
		/* das neu generierte Alphabet wird gesetzt */
		this.setSecretAlphabet(encrypted);
	}
	
}
 
