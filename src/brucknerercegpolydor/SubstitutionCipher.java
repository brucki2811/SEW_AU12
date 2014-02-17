package brucknerercegpolydor;

/**
 * 
 * @author Stefan Polydor
 * @version 2014.2.12
 */

public class SubstitutionCipher extends MonoAlphabeticCipher {


	/**
	 * Dieser Konstruktor erzeugt ein Objekt mit einem angegebenem secretalphabet
	 * @param secretalphabet muss 30 Zeichen lang sein und es daf kein Zeichen doppelt vorkommen, falls doch wird ein default secretAlphabet gesetzt
	 */
	public SubstitutionCipher(String secretalphabet) {
		super();
		super.setSecretAlphabet(secretalphabet);
	}
}
 
