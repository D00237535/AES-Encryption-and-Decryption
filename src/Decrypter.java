/**
 * This class decrypts the String argument passed in using and known key or by running the text through a for loop
 * until the key is found and the text is decrypted.
 *
 * @author Kevin Silveser, Kevin Daly, Annas Khan
 */
public class
Decrypter {
    private final String TXT;
    private final String HINT;
    private String decryptedTxt;
    private int key;

    /**
     * The initial values if a key is passed in
     * @param txt The encrypted text
     * @param key The key to decrypt the text
     */
    public Decrypter(String txt, int key) {
        this.TXT = txt;
        this.HINT = null;
        this.key = key;
    }

    /**
     * The initial values if key is unknown but a hint to decrypted text is given.
     * @param txt The decrypted text
     * @param hint The hint value which is a string which is within the decrypted text
     */
    public Decrypter(String txt, String hint) {
        this.TXT = txt;
        this.HINT = hint;
        this.key = 0;
    }

    /**
     * @return The encrypted text
     */
    public String getTXT() { return this.TXT; }

    /**
     * @return The decrypted text
     */
    public String getDecryptedTxt() { return this.decryptedTxt; }

    /**
     * @return The key used to decrypt the text
     */
    public int getKey() { return this.key; }

    /**
     * This function will return a StringBuilder once all the ASCII characters have been shifted by the amount
     * specified by the key.
     * A StringBuilder with the shifted character are returned.
     * @param txt The initial StringBuilder value passed that will be shifted by the key
     * @return The StringBuilder value once all the characters have been shifted
     */
    private StringBuilder cycle(StringBuilder txt) {
        for (int i = 0; i < this.TXT.length(); i++) {
            char letter = this.TXT.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                letter = (char) (letter - this.key);
                if (letter < 'A') letter = (char) (letter - 'A' + 'Z' + 1);
                txt.append(letter);
            }
            else if (letter >= 'a' && letter <= 'z') {
                letter = (char) (letter - this.key);
                if (letter < 'a') letter = (char) (letter - 'a' + 'z' + 1);
                txt.append(letter);
            }
            else txt.append(letter);
        }
        return txt;
    }

    /**
     * If a hint value is provided, this method will run the cycle multiple times until the StringBuilder returned
     * contains the hint value.
     * If no hint value is provided, the function fill run the cycle function once with the key value.
     */
    public void decrypt() {
        StringBuilder txt = new StringBuilder();

        if (this.HINT  != null) {
            for (this.key = 0; this.key <= 26; this.key++){
                this.decryptedTxt = this.cycle(txt).toString();
                if (this.decryptedTxt.contains(this.HINT)) break;
                else txt.setLength(0);
            }
        }
        else {
            this.decryptedTxt = this.cycle(txt).toString();
        }
    }
}
