
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * To read and store the data from the cypphertext.txt file.
 *
 * This class reads the text file once the loadData method is called,and the two lines in the text file are stored
 * in the private instances line1 and line2.
 *
 * @author Kevin Silveser, Kevin Daly, Annas Khan
 */
public class FileReader {
    private final String INPUT_FILE;
    private String line1;
    private String line2;
    private boolean error;

    public FileReader() {
        this.INPUT_FILE = "cyphertext.txt";
        this.error = false;
        this.loadData();
    }

    /**
     * @return True if there is an error occurred.
     */
    public boolean getError() { return this.error; }

    /**
     * @return The first line of the text file
     */
    public String getLine1() { return this.line1; }

    /**
     * @return The second line of the text file
     */
    public String getLine2() { return this.line2; }

    /**
     * This function will read the data from the text file, and hold its value in line1 and line2.
     * Error while reading file are caught using IOException so that program doesn't crash.
     */
    public void loadData() {
        try {
            Scanner sc = new Scanner(new File(this.INPUT_FILE));
            sc.useDelimiter("[\r\n]+");
            this.line1 = sc.nextLine();
            this.line2 = sc.nextLine();
        } catch (IOException e) {
            this.error = true;
        }
    }
}