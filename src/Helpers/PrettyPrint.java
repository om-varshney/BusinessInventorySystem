package Helpers;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class PrettyPrint {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    @Contract(pure = true)
    public static @NotNull String printErrorMessage(String str) {
        return ANSI_RED + ">>> " + str + " " + ANSI_RESET;
    }

    @Contract(pure = true)
    public static @NotNull String printSuccessMessage(String str) {
        return  ANSI_GREEN_BACKGROUND + ANSI_BLACK + " " + str + " " + ANSI_RESET;
    }

    @Contract(pure = true)
    public static @NotNull String printInfoMessage(String str) {
        return  ANSI_PURPLE_BACKGROUND + " " + str + " " + ANSI_RESET;
    }
}
