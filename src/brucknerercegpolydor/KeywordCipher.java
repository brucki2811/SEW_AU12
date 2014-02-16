package brucknerercegpolydor;

/**
 * 
 * @author Stefan Erceg
 * @version 2014.02.12
 */

public class KeywordCipher extends MonoAlphabeticCipher {
	
	public KeywordCipher(String keyword) {
		
		char[] tmp = new char[30];
		
		
		for (int i = 0; i < keyword.length(); i++) {
			tmp[i] = keyword.toCharArray()[i];
		}
		
		for (int i = 0; i < 30; i++) {
			if ((tmp[i] + "").equals("")) {
				tmp[i] = nextChar(tmp);
			}
		}
		
	}
	
	public char nextChar(char[] decrypt) {
		
		for (char c: this.getSecretAlphabet().toCharArray()) {
			if (new String(decrypt).indexOf(c) == -1) {
				return c;
			}
		}
		
		return ' ';
		
	}
	
	public void setKeyword(String keyword) {

	}
	
	public static void main(String[] args) {
		
		KeywordCipher kc = new KeywordCipher("hallo");
		System.out.println(kc.encrypt("HalloWelt"));
		
	}
	 
}
 
