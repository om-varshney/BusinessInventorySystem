package Helpers;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
    private final ArrayList<String> options = new ArrayList<>();

    public ArrayList<String> getOptions() {
        return options;
    }

    public void addOption(String option) {
        options.add(option);
    }

    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your Choice: ");
            int choice = sc.nextInt();
            if (choice > 0 && choice <= this.getOptions().size()) {
                return choice;
            } else {
                System.out.println("Enter valid Choice!");
            }
        }
    }

    public String toString() {
        int count = 1;
        AsciiTable at = new AsciiTable();
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
}
