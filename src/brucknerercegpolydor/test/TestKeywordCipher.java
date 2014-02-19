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
	//Testen des Verschl�sselns
	@Test
	public void testEncrypt() {
		KeywordCipher kc = new KeywordCipher("Abend");
		assertEquals("gakko",kc.encrypt("hallo"));
	}
	//Testen des Geheimalphabets
	@Test
	public void testSecretAlphabet(){
		KeywordCipher kc = new KeywordCipher("Abend");
		assertEquals("abendcfghijklmopqrstuvwxyz����",kc.getSecretAlphabet());
	}
	//Testen, ob bei mehrfacher Vorkommnis von Buchstaben im Keyword eine IllegalArgumentException geworfen wird
	@Test (expected = IllegalArgumentException.class)
	public void testSelbeBuchstaben(){
		KeywordCipher kc = new KeywordCipher("hallo");
	}
	

}
