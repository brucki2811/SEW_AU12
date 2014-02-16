package brucknerercegpolydor;

/**
 * 
 * @author Stipe Erceg
 * @version 2014.2.12
 */

public class KeywordCipher extends MonoAlphabeticCipher {
	
	public char[] keyword;
	
	public char[] alphabet = "abcdefghijklmnopkqrstuvwxyzßöäü".toCharArray();
	
	public char[] encrypt;
	
	public KeywordCipher(String keyword) {
		for(int i=0; i < keyword.length(); i++) {
			keyword[i] = keyword.toCharArray();
		}
		for(int i=0; i < encrypt.length; i++) {
			encrypt[i] = 
		}
	}
	 
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	 
}
 
