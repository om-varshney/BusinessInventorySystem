package Helpers.Menus;

import Helpers.PrettyPrint;
import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    private final ArrayList<String> options = new ArrayList<>();
    private String name = "Menu";
    public ArrayList<String> getOptions() {
        return options;
    }

    public void addOption(String option) {
        options.add(option);
    }

    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your Choice: ");
            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException im) {
                System.out.println(PrettyPrint.printErrorMessage("Enter valid Choice!"));
                // Consume invalid input from the scanner buffer
                sc.nextLine();
                continue;
            }
            if (choice > 0 && choice <= this.getOptions().size()) {
                return choice;
            } else {
                System.out.println(PrettyPrint.printErrorMessage("Enter valid Choice!"));
            }
        }
    }

    public String toString() {
        int count = 1;
        AsciiTable at = new AsciiTable();
        at.addRule();
        AT_Row menuTitle = at.addRow(null, this.name);
        menuTitle.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        for (String option: options) {
            at.addRow(count, option);
            at.addRule();
            count++;
        }
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        cwc.add(0, 15);
        return at.render();
    }

    public void setName(String name) {
        this.name = name;
    }
}
