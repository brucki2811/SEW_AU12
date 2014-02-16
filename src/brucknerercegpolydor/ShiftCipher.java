package brucknerercegpolydor;

/**
 * 
 * @author
 * @version 
 */

public class ShiftCipher extends MonoAlphabeticCipher {
	
	public int value;
	public int shiftvalue;
	
	char[] alphabet = "abcdefghijklmnopkqrstuvwxyzßöäü".toCharArray();
	
	char[] encrypt;
	
	public ShiftCipher(int value) {
		this.value = value;
	}
	
	public void setShiftAmount(int shiftvalue) {
		this.shiftvalue = shiftvalue;
	}
	
	public static void main(String[] args) {
		ShiftCipher sc = new ShiftCipher(3);
		System.out.println(sc.encrypt("Hallo"));
	}

}