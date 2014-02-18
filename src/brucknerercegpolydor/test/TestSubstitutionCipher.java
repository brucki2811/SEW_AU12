package brucknerercegpolydor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import brucknerercegpolydor.SubstitutionCipher;

/**
 * 
 * @author Stefan Erceg
 * @version 2014.02.18
 */

public class TestSubstitutionCipher {

	/* testen, ob das selber erfundene Geheimalphabet tatsächlich gesetzt wird */
	
	@Test
	public void testSetSecretAlphabet() {
		SubstitutionCipher sc = new SubstitutionCipher("badcfehgjilknmporqtsvuxwzyöäßü");
		assertEquals("badcfehgjilknmporqtsvuxwzyöäßü", sc.getSecretAlphabet());
	}

}
