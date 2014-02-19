package brucknerercegpolydor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import brucknerercegpolydor.KeywordCipher;

/**
 * 
 * @author Michael Bruckner
 * @version 2014.02.18
 */

public class TestKeywordCipher {
	//Testen des Verschlüsselns
	@Test
	public void testEncrypt() {
		KeywordCipher kc = new KeywordCipher("Abend");
		assertEquals("gakko",kc.encrypt("hallo"));
	}
	//Testen des Geheimalphabets
	@Test
	public void testSecretAlphabet(){
		KeywordCipher kc = new KeywordCipher("Abend");
		assertEquals("abendcfghijklmopqrstuvwxyzäöüß",kc.getSecretAlphabet());
	}
	//Testen, ob bei mehrfacher Vorkommnis von Buchstaben im Keyword eine IllegalArgumentException geworfen wird
	@Test (expected = IllegalArgumentException.class)
	public void testSelbeBuchstaben(){
		KeywordCipher kc = new KeywordCipher("hallo");
	}
	//Testet ob die IllegalArgumentException geworfen wird, falls eine Zahl im Keyword steht
	@Test (expected = IllegalArgumentException.class)
	public void testZahl(){
		KeywordCipher kc = new KeywordCipher("abc2");
		
	}
}
