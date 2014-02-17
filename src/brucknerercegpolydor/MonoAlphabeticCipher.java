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
	private String clearAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";

	/**
	 * Ist das secretAlphabet
	 */
	private String secretAlphabet;

	/**
	 * Erzeugt ein Objekt mit einem default secretAlphabet
	 */
	public MonoAlphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}

	/**
	 * Gibt das secretAlphabet zurück
	 * @return secretAlphabet
	 */
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}

	/**
	 * Ändert das secretAlphabet
	 * Diese Methode wurde geschrieben um in der Klasse SubstitutionCipher das secretAlphabet zu setzen
	 * @param secretAlphabet ist das zu setzende secretAlphabet
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		try {
			if (secretAlphabet.length() == 30) {    // hier wird überprüft ob das zu setzende secretAlphabet 30 Zeichen lang ist
				this.secretAlphabet = secretAlphabet;
			}
			if (! this.checkSecretAlphabet()) {	// hier wird überprüft ob es keine doppelten Zeichen beinhaltet, falls doch wird ein default secretAlphabet gesetzt
				this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
			}
		} catch (IllegalArgumentException e) {
			this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		} catch (NullPointerException e) {
			this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		}
	}
	
	/**
	 * Diese Methode verschlüsselt einen Text
	 * @param text ist der text der Verschlüsselt werden soll
	 * @return string gibt null zurück wenn der Parameter eine Exception auslöst, wenn keine Exception Ausgelöst wird wird der verschlüsselte Text ausgegeben
	 * @see Cipher#encrypt(brucknerercegpolydor)
	 */
	public String encrypt(String text) {
		try {
			text = text.toLowerCase(Locale.GERMAN);	// wandelt den zu entschlüsselnden Text in Kleinbuchstaben um
		} catch (IllegalArgumentException e)	{
			return null;
		} catch (NullPointerException e)	{
			return null;
		}
		String textOriginal = text;	// Speichert den Text der entschlüsselt werden soll
		text = "";	// setzt den Text zu einem leerString
		boolean checkChange;	// kennzeichnet ob ein passendes Zeichen gefunden wurde oder nicht
		char cut = ' ';		// speichert das aktuell Ausgewählte Zeichen ab
		for (int x = 0; x < textOriginal.length(); x++) {	// Wiederholt den folgenden Vorgang bis jedes Zeichen Entschlüsselt wird
			checkChange = false;	// setzt die Änderung auf false
			cut = textOriginal.charAt(x);	// schneidet das aktuelle Zeichen aus und speichert dieses Ab
			for (int y = 0; y < this.secretAlphabet.length(); y++) {	// Wiederholt sich solange bis jedes Zeichen durchgegangen ist oder das passende Zeichen gefunden wurde
				if (cut == this.clearAlphabet.charAt(y)) {	// Wenn das ausgeschnittene Zeichen gleich einem Zeichen im clearAlphabet ist
					text = text + this.secretAlphabet.charAt(y);	// hier wird der auszugebende text um das Zeichen erweitert (Das entschlüsselte Zeichen wird verschlüsselt und dem Auszugebendem Text angehängt
					checkChange = true;		// setzt checkChange = true und damit wird gekennzeichnet, dass für das aktuell Ausgewählte Zeichen ein entsprechendes im clearAlphabet vorhanden ist und dieses Zeichen verschlüsselt wurde
					break;	// bricht die Schleife ab da ein passendes Zeichen gefunden wurde
				}
			}
			if (! checkChange)	// wenn checkChange = false dann wird das aktuell Ausgewählte Zeichen dem auszugebendem Text angehängt da es nicht im secretAlphabet vorhanden ist
				text = text + cut;
		}

		return text;
	}
	 
	/**
	 * Diese Methode entschlüsselt einen Text
	 * @param text ist der Text der Entschüsselt werden soll
	 * @return string gibt den entschlüsselten Text zurück
	 * @see Cipher#decrypt(brucknerercegpolydor)
	 */
	public String decrypt(String text) {
		try {
			text = text.toLowerCase(Locale.GERMAN);	// wandelt den zu entschlüsselnden Text in Kleinbuchstaben um
		} catch (IllegalArgumentException e)	{
			return null;
		} catch (NullPointerException e)	{
			return null;
		}
		String textOriginal = text;	// Speichert den Text der entschlüsselt werden soll
		text = "";	// setzt den Text zu einem leerString
		boolean checkChange;	// kennzeichnet ob ein passendes Zeichen gefunden wurde oder nicht
		char cut = ' ';	// speichert das aktuell Ausgewählte Zeichen ab
		for (int x = 0; x < textOriginal.length(); x++) { // Wiederholt den folgenden Vorgang bis jedes Zeichen Entschlüsselt wird
			checkChange = false;	// setzt die Änderung auf false
			cut = textOriginal.charAt(x);	// schneidet das aktuelle Zeichen aus und speichert dieses Ab
			for (int y = 0; y < this.clearAlphabet.length(); y++) {		// Wiederholt sich solange bis jedes Zeichen durchgegangen ist oder das passende Zeichen gefunden wurde
				if (cut == this.secretAlphabet.charAt(y)) {		// Wenn das ausgeschnittene Zeichen gleich einem Zeichen im secretAlphabet ist
					text = text + this.clearAlphabet.charAt(y);		// hier wird der auszugebende text um das Zeichen erweitert (Das verschlüsselte Zeichen wird entschlüsselt und dem Auszugebendem Text angehängt
					checkChange = true;		// setzt checkChange = true und damit wird gekennzeichnet, dass für das aktuell Ausgewählte Zeichen ein entsprechendes im secretAlphabet vorhanden ist und dieses Zeichen entschlüsselt wurde
					break;	// bricht die Schleife ab da ein passendes Zeichen gefunden wurde
				}
			}
			if (! checkChange)	// wenn checkChange = false dann wird das aktuell Ausgewählte Zeichen dem auszugebendem Text angehängt da es nicht im secretAlphabet vorhanden ist
				text = text + cut;
		}

		return text;
	}

	/**
	 * Diese Methode überprüft ob in dem Angegebenem SecretAlphabet keine doppelten Buchstaben vorhanden sind
	 * @return true wenn keine doppelten Buchstaben vorhanden sind und falls, wenn 2 doppelte Vorkommen.
	 */
	public boolean checkSecretAlphabet() {
		try {
			if (this.getSecretAlphabet().length() < 1)	{	// Wenn die Länge des secretAlphabet = 0 wird false returnt
				return false;
			} else if (this.getSecretAlphabet().length() == 1) {	// Wenn die Länge des secretAlphabet = 1 wird true returnt
				return true;
			} else {
				char[] secAlphabet = getSecretAlphabet().toCharArray();		// hier wird das secretAlphabet in ein char[] umgewandelt
				int reduce = 1;		// dient zur Variablen verringerung da nach jedem Durchgang das Zeichen mit dem höchsten Int-Wert am Ende steht
				char temp = ' ';	// speichert eine der zu tauschenden chars
				int change;		// kennzeichnet ob ein Tausch stattgefuden hat
				for (int y = 0; y < getSecretAlphabet().length() - reduce; y++) {
					change = 0;		// change wird = 0 gesetzt
					for (int x = 0; x < getSecretAlphabet().length() - reduce; x++) {	// Wiederholt die folgende überprüfung solange, bis das gesamte secretAlphabet nach dem Int-Werten sortiert wurde oder es 2 gleiche Zeichen beinhaltet
						if (secAlphabet[x] > secAlphabet[x + 1]) {	// Wenn das aktuell Ausgewählte Zeichen größer als das nächste ist wird es vertauscht
							temp = secAlphabet[x];	// hier wird das aktuell Ausgewählte Zeichen zwischengespeichert
							secAlphabet[x] = secAlphabet[x + 1];	// hier wird das das kleinere Zeichen an der Position des Größerem gespeichert
							secAlphabet[x + 1] = temp;	// hier wird das größere Zeichen an der Position des Kleinerem gespeichert
							change++;	// change wird um 1 erhöht um eine Vertauschung zu kennzeichen
						} else if (secAlphabet[x] == secAlphabet[x + 1]) {	// Wenn das aktuelle Zeichen gleich dem nächsten wird false return, da 2 gleiche Zeichen vorhanden sind
							return false;
						}
					}
					if (change == 0) {	// Wenn change = 0 wird der Durchgang unterbrochen und es wird true returnt da es keine doppelten Zeichen gibt
						return true;
					}
					reduce++;	// wird erhöht da nach jedem Durchgang das größte Zeichen am Ende steht
				}
			}
		} catch (IllegalArgumentException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();

		System.out.println(a.encrypt("adls"));
		System.out.println(a.decrypt(a.encrypt("adls")));
		System.out.println();

		SubstitutionCipher b = new SubstitutionCipher("abc0efghijklmnopqr4tuvwxyzäöüß");

		System.out.println(b.encrypt("adfs?"));
		System.out.println(b.decrypt(b.encrypt("adfs?")));
	}
}