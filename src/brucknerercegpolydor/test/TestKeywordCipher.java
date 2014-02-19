package brucknerercegpolydor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import brucknerercegpolydor.KeywordCipher;

public class TestKeywordCipher {

	@Test
	public void testEncrypt() {
		KeywordCipher kc = new KeywordCipher("Abend");
		assertEquals("gakko",kc.encrypt("hallo"));
	}
	@Test
	public void testKonstruktor(){
		KeywordCipher kc = new KeywordCipher("Abend");
	}
	@Test (expected = IllegalArgumentException.class)
	public void testSelbeBuchstaben(){
		KeywordCipher kc = new KeywordCipher("hallo");
		assertEquals("",kc.encrypt("ich"));
	}
	

}
