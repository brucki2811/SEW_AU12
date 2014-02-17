package brucknerercegpolydor;

/**
 * 
 * @author Stefan Erceg
 * @version 2014.02.12
 */

public class KeywordCipher extends MonoAlphabeticCipher {
	
	/**
	 * im Konstruktor wird die Methode "setKeyword" ausgeführt
	 * @param mittels "keyword" wird ein Schlüsselwort bzw. ein Kennwort angegeben
	 */
	
	public KeywordCipher(String keyword) {
		setKeyword(keyword);
	}
	
	/**
	 * die Methode fügt das eingebene Schlüsselwort am Beginn des Alphabets hinzu, 
	 * danach folgen alle Buchstaben des Alphabets, die nicht im Schlüsselwort vorkommen
	 * @param mittels "keyword" wird ein Schlüsselwort bzw. ein Kennwort angegeben
	 */
	
	public void setKeyword(String keyword) {
		
		/* das verschlüsselte Alphabet wird in einem String abgespeichert */
		String encrypted;
		
		/* das eingegebene Schlüsselwort wird zu Beginn des Alphabets hinzugefügt */
		encrypted = keyword;
		
		/* - die for-Schleife geht jeden Buchstaben des Schlüsselworts durch
		 * - falls bestimmte Buchstaben im Schlüsselwort mehrfach vorkommen, wird eine IllegalArgumentException geworfen */
		for (int i=0; i < keyword.length()-1; i++) {
			if(keyword.indexOf(keyword.toCharArray()[i]) != keyword.lastIndexOf(keyword.toCharArray()[i])) {
				throw new IllegalArgumentException("Buchstaben dürfen im Wort jeweils nur einmal vorkommen");
			}
		}
		
		/* - die for-Schleife geht jeden Buchstaben des Alphabets durch
		 * - falls der Buchstabe nicht im Schlüsselwort vorgekommen ist, wird er am Ende des verschlüsselten Alphabets hinzugefügt */
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
 
