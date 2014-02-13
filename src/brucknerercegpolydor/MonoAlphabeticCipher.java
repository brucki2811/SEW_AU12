package brucknerercegpolydor;

import java.util.Locale;

/**
 * 
 * @author Stefan Polydor
 * @version 2014.2.12
 */

public class MonoAlphabeticCipher implements Cipher {
 
	private String secretAlphabet;
	 
	public MonoAlphabeticCipher() {
		
	}
	 
	public String getSecretAlphabet() {
		return secretAlphabet;
	}
	
	/**
	 * @return gibt null zur�ck wenn der Parameter eine Exception ausl�st, wenn keine Exception Ausgel�st wird wird der verschl�sselte Text ausgegeben 
	 * @see brucknerercegpolydor.Cipher#encrypt(brucknerercegpolydor)
	 */
	public String encrypt(String text) {
		try {
			text = text.toLowerCase(Locale.GERMAN);
		} catch (IllegalArgumentException e)	{
			return null;
		} catch (NullPointerException e)	{
			return null;
		}
		return text;
	}
	 
	/**
	 * @see brucknerercegpolydor.Cipher#decrypt(brucknerercegpolydor)
	 */
	public String decrypt(String text) {
		text = text.toLowerCase(Locale.GERMAN);
		return text;
	}
	public static void main(String[] args) {
		
	}
}
 
