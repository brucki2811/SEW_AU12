package brucknerercegpolydor;

/**
 * @author Michael Bruckner
 * @version 2014.2.18
 */

	public class StartCipher {

		private GUI g;
		private ButtonListener bl;
		private MonoAlphabeticCipher mac;
		
		public StartCipher(){
			this.g = new GUI(this.mac, this.bl);
			this.bl = new ButtonListener();
		} 
		public static void main (String[]args){
			StartCipher stc = new StartCipher();
		}
	}
