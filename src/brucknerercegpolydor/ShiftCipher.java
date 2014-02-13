package brucknerercegpolydor;

/**
 * 
 * @author Stipe Erceg
 * @version 2014.2.12
 */

public class ShiftCipher extends MonoAlphabeticCipher {
	
	public int value;
	public int shiftvalue;
	
	private char[] alphabet = "abcdefghijklmnopkqrstuvwxyzßöäü".toCharArray();
	
	public ShiftCipher(int value) {
		this.value = value;
	}
	 
	public void setShiftAmount(int shiftvalue) {
		this.shiftvalue = shiftvalue;
	}
	
	public static void main(String[] a) {
		
	}
}
 
