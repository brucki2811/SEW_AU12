package brucknerercegpolydor;

import java.util.Locale;

/**
 * 
 * @author Stefan Polydor
 * @version 2014.2.12
 */

public class MonoAlphabeticCipher implements Cipher {

	/**
	 * Ist das clearAlphabet
	 */
	private String clearAlphabet = "abcdefghijklmnopqrstuvwxyz����";

	/**
	 * Ist das secretAlphabet
	 */
	private String secretAlphabet;

	/**
	 * Erzeugt ein Objekt mit einem default secretAlphabet
	 */
	public MonoAlphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
	}

	/**
	 * Gibt das secretAlphabet zur�ck
	 * @return secretAlphabet
	 */
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}

	/**
	 * �ndert das secretAlphabet
	 * Diese Methode wurde geschrieben um in der Klasse SubstitutionCipher das secretAlphabet zu setzen
	 * und falls ein ung�ltiges Alphabet oder eine Exception geworfen wird wird das default secretAlphabet gesetzt
	 * @param secretAlphabet ist das zu setzende secretAlphabet (l�nge = 30 und kein doppelten Zeichen)
	 * @throws java.lang.IllegalArgumentException wenn diese ausgel�st wird
	 * @throws java.lang.NullPointerException wenn diese ausgel�st wird
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		try {
			if (secretAlphabet.length() == 30) {    // hier wird �berpr�ft ob das zu setzende secretAlphabet 30 Zeichen lang ist
				this.secretAlphabet = secretAlphabet;
			}
			if (! this.checkSecretAlphabet()) {	// hier wird �berpr�ft ob es keine doppelten Zeichen beinhaltet, falls doch wird ein default secretAlphabet gesetzt
				this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
			}
		} catch (IllegalArgumentException e) {
			this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
			throw new IllegalArgumentException();
		} catch (NullPointerException e) {
			this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
			throw new NullPointerException();
		}
	}
	
	/**
	 * Diese Methode verschl�sselt einen Text
	 * @param text ist der text der Verschl�sselt werden soll
	 * @return string gibt den verschl�sselten Text zur�ck
	 * @throws java.lang.IllegalArgumentException wenn diese ausgel�st wird
	 * @throws java.lang.NullPointerException wenn diese ausgel�st wird
	 * @see Cipher#encrypt(brucknerercegpolydor)
	 */
	public String encrypt(String text) {
		try {
			text = text.toLowerCase(Locale.GERMAN);	// wandelt den zu entschl�sselnden Text in Kleinbuchstaben um
		} catch (NullPointerException e) {
			throw new NullPointerException();
		}
		String textOriginal = text;	// Speichert den Text der entschl�sselt werden soll
		text = "";	// setzt den Text zu einem leerString
		boolean checkChange;	// kennzeichnet ob ein passendes Zeichen gefunden wurde oder nicht
		char cut = ' ';		// speichert das aktuell Ausgew�hlte Zeichen ab
		for (int x = 0; x < textOriginal.length(); x++) {	// Wiederholt den folgenden Vorgang bis jedes Zeichen Entschl�sselt wird
			checkChange = false;	// setzt die �nderung auf false
			cut = textOriginal.charAt(x);	// schneidet das aktuelle Zeichen aus und speichert dieses Ab
			for (int y = 0; y < this.secretAlphabet.length(); y++) {	// Wiederholt sich solange bis jedes Zeichen durchgegangen ist oder das passende Zeichen gefunden wurde
				if (cut == this.clearAlphabet.charAt(y)) {	// Wenn das ausgeschnittene Zeichen gleich einem Zeichen im clearAlphabet ist
					text = text + this.secretAlphabet.charAt(y);	// hier wird der auszugebende text um das Zeichen erweitert (Das entschl�sselte Zeichen wird verschl�sselt und dem Auszugebendem Text angeh�ngt
					checkChange = true;		// setzt checkChange = true und damit wird gekennzeichnet, dass f�r das aktuell Ausgew�hlte Zeichen ein entsprechendes im clearAlphabet vorhanden ist und dieses Zeichen verschl�sselt wurde
					break;	// bricht die Schleife ab da ein passendes Zeichen gefunden wurde
				}
			}
			if (! checkChange)	// wenn checkChange = false dann wird das aktuell Ausgew�hlte Zeichen dem auszugebendem Text angeh�ngt da es nicht im secretAlphabet vorhanden ist
				text = text + cut;
		}

		return text;
	}
	 
	/**
	 * Diese Methode entschl�sselt einen Text
	 * @param text ist der Text der Entsch�sselt werden soll
	 * @return string gibt den entschl�sselten Text zur�ck
	 * @throws java.lang.IllegalArgumentException wenn diese ausgel�st wird
	 * @throws java.lang.NullPointerException wenn diese ausgel�st wird
	 * @see Cipher#decrypt(brucknerercegpolydor)
	 */
	public String decrypt(String text) {
		try {
			text = text.toLowerCase(Locale.GERMAN);	// wandelt den zu entschl�sselnden Text in Kleinbuchstaben um
		} catch (NullPointerException e) {
			throw new NullPointerException();
		}
		String textOriginal = text;	// Speichert den Text der entschl�sselt werden soll
		text = "";	// setzt den Text zu einem leerString
		boolean checkChange;	// kennzeichnet ob ein passendes Zeichen gefunden wurde oder nicht
		char cut = ' ';	// speichert das aktuell Ausgew�hlte Zeichen ab
		for (int x = 0; x < textOriginal.length(); x++) { // Wiederholt den folgenden Vorgang bis jedes Zeichen Entschl�sselt wird
			checkChange = false;	// setzt die �nderung auf false
			cut = textOriginal.charAt(x);	// schneidet das aktuelle Zeichen aus und speichert dieses Ab
			for (int y = 0; y < this.clearAlphabet.length(); y++) {		// Wiederholt sich solange bis jedes Zeichen durchgegangen ist oder das passende Zeichen gefunden wurde
				if (cut == this.secretAlphabet.charAt(y)) {		// Wenn das ausgeschnittene Zeichen gleich einem Zeichen im secretAlphabet ist
					text = text + this.clearAlphabet.charAt(y);		// hier wird der auszugebende text um das Zeichen erweitert (Das verschl�sselte Zeichen wird entschl�sselt und dem Auszugebendem Text angeh�ngt
					checkChange = true;		// setzt checkChange = true und damit wird gekennzeichnet, dass f�r das aktuell Ausgew�hlte Zeichen ein entsprechendes im secretAlphabet vorhanden ist und dieses Zeichen entschl�sselt wurde
					break;	// bricht die Schleife ab da ein passendes Zeichen gefunden wurde
				}
			}
			if (! checkChange)	// wenn checkChange = false dann wird das aktuell Ausgew�hlte Zeichen dem auszugebendem Text angeh�ngt da es nicht im secretAlphabet vorhanden ist
				text = text + cut;
		}
		return text;
	}

	/**
	 * Diese Methode �berpr�ft ob in dem Angegebenem SecretAlphabet keine doppelten Buchstaben vorhanden sind
	 * @return true wenn keine doppelten Buchstaben vorhanden sind und falls, wenn 2 doppelte Vorkommen.
	 * @throws java.lang.NullPointerException wenn diese ausgel�st wird
	 */
	public boolean checkSecretAlphabet() {
		char[] secAlphabet = getSecretAlphabet().toCharArray();		// hier wird das secretAlphabet in ein char[] umgewandelt
		int reduce = 1;		// dient zur Variablen verringerung da nach jedem Durchgang das Zeichen mit dem h�chsten Int-Wert am Ende steht
		char temp = ' ';	// speichert eine der zu tauschenden chars
		int change;		// kennzeichnet ob ein Tausch stattgefuden hat
		for (int y = 0; y < getSecretAlphabet().length() - reduce; y++) {
			change = 0;		// change wird = 0 gesetzt
			for (int x = 0; x < getSecretAlphabet().length() - reduce; x++) {	// Wiederholt die folgende �berpr�fung solange, bis das gesamte secretAlphabet nach dem Int-Werten sortiert wurde oder es 2 gleiche Zeichen beinhaltet
				if (secAlphabet[x] > secAlphabet[x + 1]) {	// Wenn das aktuell Ausgew�hlte Zeichen gr��er als das n�chste ist wird es vertauscht
					temp = secAlphabet[x];	// hier wird das aktuell Ausgew�hlte Zeichen zwischengespeichert
					secAlphabet[x] = secAlphabet[x + 1];	// hier wird das das kleinere Zeichen an der Position des Gr��erem gespeichert
					secAlphabet[x + 1] = temp;	// hier wird das gr��ere Zeichen an der Position des Kleinerem gespeichert
					change++;	// change wird um 1 erh�ht um eine Vertauschung zu kennzeichen
				} else if (secAlphabet[x] == secAlphabet[x + 1]) {	// Wenn das aktuelle Zeichen gleich dem n�chsten wird false return, da 2 gleiche Zeichen vorhanden sind
					return false;
				}
			}
			if (change == 0) {	// Wenn change = 0 wird der Durchgang unterbrochen und es wird true returnt da es keine doppelten Zeichen gibt
				return true;
			}
			reduce++;	// wird erh�ht da nach jedem Durchgang das gr��te Zeichen am Ende steht
		}
		return true;
	}

}