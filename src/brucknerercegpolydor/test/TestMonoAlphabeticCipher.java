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

	/* testen, ob das Alphabet von der Reihenfolge und von der L�nge her passt */
	
	@Test
	public void testKonstruktor() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.getSecretAlphabet());
	}
	
	/* testen, ob das Geheimalphabet 30 Zeichen enth�lt */
	
	@Test
	public void testAnzahlZeichen() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("abcdefghijklmnopqrstuvwxyz����");
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.getSecretAlphabet());
	}
	
	/* testen, ob bei dem Geheimalphabet bei einer Eingabe von weniger als 30 Zeichen automatisch alle restlichen Zeichen hinzugef�gt werden */ 
	
	@Test
	public void testAnzahlZeichen2() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("abc");
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.getSecretAlphabet());
	}
	
	/* testen, ob mehrfach vorkommende Buchstaben entfernt werden */
	
	@Test
	public void testDoubleSign() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("abbdefghijklmnopqrstuvwxyz����");
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.getSecretAlphabet());
	}
	
	/* NullPointerException von der Methode "setSecretAlphabet" testen */
	
	@Test (expected = NullPointerException.class)
	public void testSetSecretAlphabet_NullPointerException() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet(null);
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.getSecretAlphabet());
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
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.encrypt(null));
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
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.decrypt(null));
	}
	
	/* testen, ob gesamtes Alphabet in umgekehrter Reihenfolge gesetzt wird */
	
	@Test
	public void testReverseAlphabet() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("����zyxwvutsrqponmlkjihgfedcba");
		assertEquals("����zyxwvutsrqponmlkjihgfedcba", mac.getSecretAlphabet());
	}
	
}
