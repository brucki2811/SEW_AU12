package brucknerercegpolydor;

import java.util.Locale;

/**
 * 
 * @author Stefan Polydor
 * @version 2014.2.12
 */

public class SubstitutionCipher extends MonoAlphabeticCipher {
	
	/**
	 * 
	 * @param secretalphabet
	 */
	public SubstitutionCipher(String secretalphabet) {
		this.setSecretAlphabet(secretalphabet);
	}
	
	/**
	 * 
	 * @param secretAlphabet
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		try {
			if (secretAlphabet.length() == 30)
				this.setSecretAlphabet(secretAlphabet.toLowerCase(Locale.GERMAN));
			else throw new IllegalArgumentException(); //gehört noch durch eine passende ersetzt
		} catch (IllegalArgumentException e)	{
			
		} catch (NullPointerException e)	{
			
		}
	}
	
}
 
