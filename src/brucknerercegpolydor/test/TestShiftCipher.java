package brucknerercegpolydor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import brucknerercegpolydor.ShiftCipher;
/**
 * 
 * @author Michael Bruckner
 * @version 2014.02.18
 */
public class TestShiftCipher {
	//Testen des Geheimalphabets
	@Test
	public void testSecretAlphabet() {
		ShiftCipher sc = new ShiftCipher(2);
		assertEquals("cdefghijklmnopqrstuvwxyz����ab",sc.getSecretAlphabet());
	}
	//In diesem Test wird die IllegalArgumentException geworfen, da die Verschiebung der Buchstaben gr��er 0 sein muss
	@Test (expected = IllegalArgumentException.class)
	public void testShiftValue(){
		ShiftCipher sc = new ShiftCipher(-1);
	}

}
