package brucknerercegpolydor;

/**
 * 
 * @author Stefan Erceg
 * @version 2014.02.12
 */

public class ShiftCipher extends MonoAlphabeticCipher {
	
	public int value;
	public int shiftvalue;
	
	public int stelle;
	
	public char[] alphabet = "abcdefghijklmnopkqrstuvwxyzßöäü".toCharArray();
	
	public char[] encrypt = "                              ".toCharArray();
	
	public ShiftCipher(int value) {
		this.value = value;
		for(int i=0; i < encrypt.length; i++) {
			encrypt[i] = alphabet[i + this.value];
			if(this.stelle > 30) {
				this.value = this.value - 30;
			}
		}
	}
	
	public void setShiftAmount(int shiftvalue) {
		this.shiftvalue = shiftvalue;
		for(int i=0; i < encrypt.length; i++) {
			encrypt[i] = alphabet[i + this.value];
		}
	}
	
	public static void main(String[] args) {
		ShiftCipher sc = new ShiftCipher(2);
		System.out.println(sc.encrypt("Hallo"));
	}

}
