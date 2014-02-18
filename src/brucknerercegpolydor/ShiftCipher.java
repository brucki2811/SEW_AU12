package brucknerercegpolydor;



/**
 * 
 * @author Stefan Erceg
 * @version 2014.02.12
 */

public class ShiftCipher extends MonoAlphabeticCipher {
	
	/**
	 * im Konstruktor wird die Methode "setShiftAmount" ausgeführt
	 * @param value ist der Wert, um wie viele Stellen die Buchstaben verschoben werden sollen
	 */
	
	public ShiftCipher(int value) {
		setShiftAmount(value);
	}
	
	/**
	 * die Methode verschiebt die Buchstaben um den eingegebenen Wert
	 * @param shiftvalue ist der Wert, um wie viele Stellen die Buchstaben verschoben werden sollen
	 */
	
	public void setShiftAmount(int shiftvalue) {
		
		/* das Alphabet wird von der Methode "getSecretAlphabet" aus der MonoAlphabeticCipher-Klasse geholt */
		String alphabet = this.getSecretAlphabet();
		
		/* das verschlüsselte Alphabet wird in einem String abgespeichert */
		String encrypted = "";
		
		/* falls der eingegebene Wert kleiner 0 ist, wird eine IllegalArgumentException geworfen */
		if (shiftvalue < 0) throw new IllegalArgumentException("Der angegebene Wert muss größer 0 sein"); 
		
		/* - die for-Schleife geht jeden Buchstaben des Alphabets durch und verschiebt die Buchstaben um den eingegeben Wert 
		 * - ab dem 30. Zeichen (= ß) wird wieder beim 1. Zeichen (= a) angefangen */
		for(int i=0; i < alphabet.length(); i++) {
			encrypted += alphabet.charAt((i + shiftvalue)%30);
		}
		
		/* das neu generierte Alphabet wird gesetzt */
		this.setSecretAlphabet(encrypted);
	}
	
	public static void main(String[] args) {
		ShiftCipher sc = new ShiftCipher(2);
		System.out.println(sc.encrypt("Halloßüäö!9"));
	}


}