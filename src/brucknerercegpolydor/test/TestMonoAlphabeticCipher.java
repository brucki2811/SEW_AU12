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

	@Test
	public void testKonstruktor() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.getSecretAlphabet());
	}

	@Test
	public void testAnzahlZeichen() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("abcdefghijklmnopqrstuvwxyz����");
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.getSecretAlphabet());
	}
	
	@Test
	public void testAnzahlZeichen2() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("abc");
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.getSecretAlphabet());
	}
	
	@Test
	public void testDoubleSign() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("abbdefghijklmnopqrstuvwxyz����");
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.getSecretAlphabet());
	}
	
	@Test (expected = NullPointerException.class)
	public void testSetSecretAlphabet_NullPointerException() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet(null);
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.getSecretAlphabet());
	}
	
	@Test
	public void testEncrypt_LowerCase() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("hallo", mac.encrypt("Hallo"));
	}
	
	@Test
	public void testEncryptZeichen() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("ab#", mac.encrypt("ab#"));
	}
	
	@Test (expected = NullPointerException.class)
	public void testEncrypt_NullPointerException() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.encrypt(null));
	}
	
	@Test
	public void testDecrypt_LowerCase() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("hallo", mac.decrypt("Hallo"));
	}
	
	@Test
	public void testDecryptZeichen() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("ab?", mac.decrypt("ab?"));
	}
	
	@Test (expected = NullPointerException.class)
	public void testDecrypt_NullPointerException() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertEquals("abcdefghijklmnopqrstuvwxyz����", mac.decrypt(null));
	}
	
	@Test
	public void testReverseAlphabet() {
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		mac.setSecretAlphabet("����zyxwvutsrqponmlkjihgfedcba");
		assertEquals("����zyxwvutsrqponmlkjihgfedcba", mac.getSecretAlphabet());
	}
	
}
