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
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
	}
	 
	public String getSecretAlphabet() {
		return secretAlphabet;
	}
	
	/**
	 * @param text ist der text der Verschl�sselt werden soll
	 * @return string gibt null zur�ck wenn der Parameter eine Exception ausl�st, wenn keine Exception Ausgel�st wird wird der verschl�sselte Text ausgegeben
	 * @see Cipher#encrypt(brucknerercegpolydor)
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
	 * @param text ist der Text der Entsch�sselt werden soll
	 * @return string gibt den entschl�sselten Text zur�ck
	 * @see Cipher#decrypt(brucknerercegpolydor)
	 */
	public String decrypt(String text) {
		text = text.toLowerCase(Locale.GERMAN);
		return text;
	}

	/**
	 * Diese Methode �berpr�ft ob in dem Angegebenem SecretAlphabet keine doppelten Buchstaben vorhanden sind
	 * @param text ist das secretAlphabet
	 * @return true wenn keine doppelten Buchstaben vorhanden sind und falls, wenn 2 doppelte Vorkommen.
	 */
	public boolean checkSecretAlphabet(String text) {
		try {
			if (text.length() != 30)	{
				return false;
			} else {
				char[] secAlphabet = text.toCharArray();
				int reduce = 2;
				char temp = ' ';
				int change;
				for (int y = 0; y < text.length()-reduce; y++) {
					change = 0;
					for (int x = 0; x < text.length()-reduce; x++) {
						if (secAlphabet[x] > secAlphabet[x + 1]) {
							temp = secAlphabet[x];
							secAlphabet[x] = secAlphabet[x + 1];
							secAlphabet[x + 1] = temp;
							change++;
						} else if (secAlphabet[x] == secAlphabet[x + 1])
							return false;
					}
					if (change == 0) {
						return true;
					}
					reduce--;
				}
			}
		} catch (IllegalArgumentException e)	{
			return false;
		} catch (NullPointerException e)	{
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		if (a.checkSecretAlphabet("abcdefghijklmnopqrstuvwxyz����")) {
			System.out.println("Erfolg");
		} else {
			System.out.println("Fail");
		}
	}
}
