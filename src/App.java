public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        FileReader fr = new FileReader();
        Decrypter task1 = new Decrypter(fr.getLine1(), 3);
        Decrypter task2 = new Decrypter(fr.getLine2(), "DONE");
        boolean quit = false;

        menu.printHeading();
        do {
            if (menu.fileReaderError(fr)) break;
            if (!fr.getError()) {
                menu.optionMenu();
                switch (menu.getOption()) {
                    case OPT1:
                        task1.decrypt();
                        System.out.println("\nMessage for Task 1:");
                        System.out.println(task1.getDecryptedTxt());
                        System.out.println();
                        break;
                    case OPT2:
                        task2.decrypt();
                        System.out.println("\nMessage for Task 2:");
                        System.out.println(task2.getDecryptedTxt());
                        System.out.println("Decryption key for Task 2: " + task2.getKey());
                        System.out.println();
                        break;
                    case EXIT:
                        quit = true;
                        break;
                }
            }
        } while (!quit);

        System.out.println();
        System.out.println("****************************************************************************************************************************************************");
        System.out.println("****************************************************************************************************************************************************");
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tThanks for Hacking with us!   o(*￣︶￣*)o");
        System.out.println();
        System.out.println("****************************************************************************************************************************************************");
        System.out.println("****************************************************************************************************************************************************");
    }
}

