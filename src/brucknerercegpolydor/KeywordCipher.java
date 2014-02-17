package brucknerercegpolydor;

/**
 * 
 * @author Stefan Erceg
 * @version 2014.02.12
 */

public class KeywordCipher extends MonoAlphabeticCipher {
	
	/**
	 * im Konstruktor wird die Methode "setKeyword" ausgef�hrt
	 * @param mittels "keyword" wird ein Schl�sselwort bzw. ein Kennwort angegeben
	 */
	
	public KeywordCipher(String keyword) {
		setKeyword(keyword);
	}
	
	/**
	 * die Methode f�gt das eingebene Schl�sselwort am Beginn des Alphabets hinzu, 
	 * danach folgen alle Buchstaben des Alphabets, die nicht im Schl�sselwort vorkommen
	 * @param mittels "keyword" wird ein Schl�sselwort bzw. ein Kennwort angegeben
	 */
	
	public void setKeyword(String keyword) {
		
		/* das verschl�sselte Alphabet wird in einem String abgespeichert */
		String encrypted;
		
		/* das eingegebene Schl�sselwort wird zu Beginn des Alphabets hinzugef�gt */
		encrypted = keyword;
		
		/* - die for-Schleife geht jeden Buchstaben des Schl�sselworts durch
		 * - falls bestimmte Buchstaben im Schl�sselwort mehrfach vorkommen, wird eine IllegalArgumentException geworfen */
		for (int i=0; i < keyword.length()-1; i++) {
			if(keyword.indexOf(keyword.toCharArray()[i]) != keyword.lastIndexOf(keyword.toCharArray()[i])) {
				throw new IllegalArgumentException("Buchstaben d�rfen im Wort jeweils nur einmal vorkommen");
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
	
	public static void main(String[] args) {
		
		KeywordCipher kc = new KeywordCipher("halo");
		System.out.println(kc.encrypt("haloWelt"));
		
	}
	 
}
 
