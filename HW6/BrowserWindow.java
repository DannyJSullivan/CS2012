import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
/**
 * Created by djsul on 12/6/2016.
 */
public class BrowserWindow {

    Scanner keyboard = new Scanner(System.in);
    SimpleMarkdownReader m = new SimpleMarkdownReader();
    ISearchEngine s;

    BrowserWindow(ISearchEngine s) {
        this.s = s;
    }

    // ***** THE SCREEN/USER INTERFACE *******************
    // You should NOT need to edit this method
    void screen() {
        System.out.println("-------------------------------------");
        System.out.println("Enter a number to select an option");
        System.out.println("1. Search for pages");
        System.out.println("2. Visit a page");
        System.out.println("3. Exit the system (and lose all index data)");
        String choice = keyboard.next();
        // eat up the rest of the line
        keyboard.nextLine();

        try {
            if (choice.equals("1")) {
                System.out.println("Enter your query:");
                String query = keyboard.nextLine();
                System.out.println("Search results: ");
                System.out.println(s.runQuery(query));
                screen();
            }
            else if (choice.equals("2")) {
                System.out.println("Which page (filename) do you want to visit?:");
                String filename = keyboard.next();
                System.out.println(s.visitPage(filename));
                screen();
            }
            else if (choice.equals("3"))
                System.out.println("Thanks for searching with us");
            else
                System.out.println("ERROR *** Unrecognized option " + choice + ". Try again");
        } catch (UnsupportedFileExn e) {
            System.out.println("ERROR *** Filetype not supported: " + e.filename);
            screen();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR *** No page found at address " + e);
            screen();
        }
    }
}