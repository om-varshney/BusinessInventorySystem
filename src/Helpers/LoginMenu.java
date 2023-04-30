package Helpers;

import com.mysql.cj.log.Log;

import java.util.ArrayList;

public class LoginMenu extends Menu {
    public LoginMenu() {
        System.out.println("Choose from the following options");
        addOption("Login");
        addOption("Signup");
    }
}
