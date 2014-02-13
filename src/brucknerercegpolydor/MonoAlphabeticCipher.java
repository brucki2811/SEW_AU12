package brucknerercegpolydor;

import java.util.Locale;

/**
 * 
 * @author 
 * @version 
 */

public class MonoAlphabeticCipher implements Cipher {
 
	private String secretAlphabet;
	 
	public MonoAlphabeticCipher() {
		
	}
	 
	public String getSecretAlphabet() {
		return secretAlphabet;
	}
	 
	/**
	 * @see brucknerercegpolydor.Cipher#encrypt(brucknerercegpolydor.lang.String)
	 */
	public String encrypt(String text) {
		text = text.toLowerCase(Locale.GERMAN);
		return text;
	}
	 
	/**
	 * @see brucknerercegpolydor.Cipher#decrypt(brucknerercegpolydor.lang.String)
	 */
	public String decrypt(String text) {
		return text;
	}
	public static void main(String[] args) {
		
	}
}
 
