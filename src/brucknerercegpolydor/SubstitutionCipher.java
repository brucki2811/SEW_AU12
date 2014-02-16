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
		this.setSecretAlphabet(secretalphabet);
	}
	
	/**
	 * Diese Methode setzt ein secretAlphabet
	 * @param secretAlphabet muss 30 Zeichen lang sein und es darf kein Zeichen doppelt vorkommen, falls doch wird ein default secretAlphabet gesetzt
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		try {
			if (secretAlphabet.length() == 30)	{	// hier wird überprüft ob das zu setzende secretAlphabet 30 Zeichen lang ist
				super.setSecretAlphabet(secretAlphabet);
			}
			if (! super.checkSecretAlphabet()) {	// hier wird überprüft ob es keine doppelten Zeichen beinhaltet, falls doch wird ein default secretAlphabet gesetzt
				super.setSecretAlphabet("abcdefghijklmnopqrstuvwxyzäöüß");
			}
		} catch (IllegalArgumentException e) {
			super.setSecretAlphabet("abcdefghijklmnopqrstuvwxyzäöüß");
		} catch (NullPointerException e) {
			super.setSecretAlphabet("abcdefghijklmnopqrstuvwxyzäöüß");
		}
	}
	
}
 
