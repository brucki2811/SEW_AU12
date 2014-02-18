package brucknerercegpolydor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import brucknerercegpolydor.MonoAlphabeticCipher;

/**
 * 
 * @author Stefan Erceg
 * @version 2014.02.18
 */

public class TestMonoAlphabeticCipher {

	/* testen, ob das Alphabet von der Reihenfolge und von der Länge her passt */
	
	@Test
	public void testKonstruktor() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", mac.getSecretAlphabet());
	}
	
	/* testen, ob das Geheimalphabet 30 Zeichen enthält */
	
	@Test
	public void testAnzahlZeichen() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("abcdefghijklmnopqrstuvwxyzäöüß");
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", mac.getSecretAlphabet());
	}
	
	/* testen, ob bei dem Geheimalphabet bei einer Eingabe von weniger als 30 Zeichen automatisch alle restlichen Zeichen hinzugefügt werden */ 
	
	@Test
	public void testAnzahlZeichen2() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("abc");
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", mac.getSecretAlphabet());
	}
	
	/* testen, ob mehrfach vorkommende Buchstaben entfernt werden */
	
	@Test
	public void testDoubleSign() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("abbdefghijklmnopqrstuvwxyzäöüß");
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", mac.getSecretAlphabet());
	}
	
	/* NullPointerException von der Methode "setSecretAlphabet" testen */
	
	@Test (expected = NullPointerException.class)
	public void testSetSecretAlphabet_NullPointerException() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet(null);
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", mac.getSecretAlphabet());
	}
	
	/* testen, ob die Methode "encrypt" alle eingegebenen Buchstaben in Kleinbuchstaben umkonvertiert */
	
	@Test
	public void testEncrypt_LowerCase() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("hallo", mac.encrypt("Hallo"));
	}
	
	/* testen, ob alle Zeichen, welche keine Buchstaben sind, beibehalten werden */
	
	@Test
	public void testEncryptZeichen() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("ab#", mac.encrypt("ab#"));
	}
	
	/* NullPointerException von der Methode "encrypt" testen */
	
	@Test (expected = NullPointerException.class)
	public void testEncrypt_NullPointerException() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", mac.encrypt(null));
	}
	
	/* testen, ob die Methode "decrypt" alle eingegebenen Buchstaben in Kleinbuchstaben umkonvertiert */
	
	@Test
	public void testDecrypt_LowerCase() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("hallo", mac.decrypt("Hallo"));
	}
	
	/* testen, ob alle Zeichen, welche keine Buchstaben sind, beibehalten werden */
	
	@Test
	public void testDecryptZeichen() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("ab?", mac.decrypt("ab?"));
	}
	
	/* NullPointerException von der Methode "decrypt" testen */
	
	@Test (expected = NullPointerException.class)
	public void testDecrypt_NullPointerException() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", mac.decrypt(null));
	}
	
	/* testen, ob gesamtes Alphabet in umgekehrter Reihenfolge gesetzt wird */
	
	@Test
	public void testReverseAlphabet() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("ßüöäzyxwvutsrqponmlkjihgfedcba");
		assertEquals("ßüöäzyxwvutsrqponmlkjihgfedcba", mac.getSecretAlphabet());
	}
	
}
