import java.util.Scanner;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class handles user input, displays a heading/title for the program, lists all possible functions of the program
 * in menu, handles user input errors, and prompts the user with possible actions in case of file reading error.
 *
 * @author Kevin Silveser, Kevin Daly, Annas Khan
 */
public class Menu {
    private final Pattern PATTERN1;
    private final Pattern PATTERN2;
    private final Scanner kb;
    private boolean valid;
    private Option option;

    /**
     * The initial values for the class instance.
     * Patterns to validate user input with regexp, scanner to take user input and boolean to trigger a loop until the
     * user enters a valid input.
     */
    public Menu() {
        this.PATTERN1 = Pattern.compile("^[1-2]$");
        this.PATTERN2 = Pattern.compile("^[1-3]$");
        this.kb = new Scanner(System.in);
        this.valid = true;
    }

    /**
     * This function takes the validated user input and assign an enum to the respective input.
     * @param choice The validated user input.
     */
    public void setOption(int choice) {
        switch (choice) {
            case 1:
                this.option = Option.OPT1;
                break;
            case 2:
                this.option = Option.OPT2;
                break;
            default:
                this.option = Option.EXIT;
                break;
        }
    }

    /**
     * @return The current choice enum
     */
    public Option getOption() { return this.option; }

    /**
     * @param valid A boolean representing the user input validity
     */
    private void setValid(boolean valid) { this.valid = valid; }

    /**
     * @return A boolean representing the user input validity
     */
    private boolean getValid() { return this.valid; }

    /**
     * Takes in an int to determine which regexp pattern to use to validate user input.
     * @param choice The unvalidated user input as a String
     * @param pattern An int to determine which regexp pattern to use
     * @return Returns true if the user inputs a valid input and false if invalid.
     */
    public boolean checkChoice(String choice, int pattern) {
        if (pattern == 1)
            return this.PATTERN1.matcher(choice).find();
        else
            return this.PATTERN2.matcher(choice).find();
    }

    /**
     * Simple function to print the heading
     */
    public void printHeading() {
        System.out.println("====================================================================================================================================================");
        System.out.println("====================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t Decryption Program");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t       By Kevin Daly, Kevin Silvester And Annas Khan");
        System.out.println("====================================================================================================================================================");
        System.out.println("====================================================================================================================================================");
        System.out.println("_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+");
        System.out.println();
    }

    /**
     * Prints error message to let user know of invalid input
     */
    public void printError() { System.out.println("\nInvalid Input!"); }

    /**
     * This function will be called if an error occured while reading the text file.
     * It will prompt the user to either re-attempt reading the file or to exit the program.
     * @param fr The file reader instance from the Main
     * @return Returns true if user selects to exit the program, and false if the user opted to reread the file.
     */
    public boolean fileReaderError(FileReader fr) {
        if (fr.getError()) {
            System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("There was an error loading ciphertext file");
            System.out.println("1 - Try reading the file again");
            System.out.println("2 - Exit Program");
            do {
                if (!this.getValid()) this.printError();
                System.out.print("Enter choice(1-2): ");
                String choiceStr = this.kb.nextLine();
                this.setValid(this.checkChoice(choiceStr, 1));
                if (this.getValid()) {
                    if (Integer.parseInt(choiceStr) == 1) {
                        fr.loadData();
                        return false;
                    } else {
                        return true;
                    }
                };
            } while (!this.getValid());
        }
        return false;
    }

    /**
     * Prints the available functionality of the program.
     * The user input is read, validated and prompted to re-enter if the input is invalid.
     */
    public void optionMenu() {
        System.out.println("1 - Run solution to Task 1");
        System.out.println("2 - Run solution to Task 2");
        System.out.println("3 - Exit Program");

        do {
            if (!this.getValid()) this.printError();
            System.out.print("Enter choice(1-3): ");
            String choiceStr = this.kb.nextLine();
            this.setValid(this.checkChoice(choiceStr, 2));
            if (this.getValid()) this.setOption(Integer.parseInt(choiceStr));
        } while(!this.getValid());
    }
}
