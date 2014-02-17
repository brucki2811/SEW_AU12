package brucknerercegpolydor;

/**
 * 
 * @author Stefan Erceg
 * @version 2014.02.12
 */

public class ShiftCipher extends MonoAlphabeticCipher {
	
	public ShiftCipher(int value) {
		setShiftAmount(value);
	}
	
	public void setShiftAmount(int shiftvalue) {
		String alphabet = this.getSecretAlphabet();
		String encrypted = "";
		if (shiftvalue < 0) throw new IllegalArgumentException("Der angegebene Wert muss größer 0 sein"); 
		for(int i=0; i < alphabet.length(); i++) {
			encrypted += alphabet.charAt((i + shiftvalue)%30);
		}
		this.setSecretAlphabet(encrypted);
	}
	
	public static void main(String[] args) {
		ShiftCipher sc = new ShiftCipher(2);
		System.out.println(sc.encrypt("Halloßüäö!9"));
	}

}