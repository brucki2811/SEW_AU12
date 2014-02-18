package brucknerercegpolydor;

/**
 * 
 * @author Stefan Erceg
 * @version 2014.02.12
 */

public class KeywordCipher extends MonoAlphabeticCipher {
	
	public KeywordCipher(String keyword) {
		setKeyword(keyword);
	}
	
	public void setKeyword(String keyword) {
		
		String encrypted;
		
		encrypted = keyword;
		
		/* for (int i=0; i<keyword.length()-1;i++) {
			
			if (keyword.toCharArray()[i] > keyword.toCharArray()[i+1]) {
				for (int j=0; j<keyword.length()-1;j++) {
					if(keyword.toCharArray()[j] == keyword.toCharArray()[j+1]) throw new IllegalArgumentException("Buchstaben dürfen nicht doppelt vorkommen");
				}
			}
		} */
		
		for(char c : this.getSecretAlphabet().toCharArray()) {
			if (encrypted.indexOf(c) == -1) {
				encrypted += "" + c;
			}
		}
		
		this.setSecretAlphabet(encrypted);
	}
	
	public static void main(String[] args) {
		
		KeywordCipher kc = new KeywordCipher("system");
		System.out.println(kc.encrypt("haloWelt"));
		
	}
	 
}
 
