package sk.tuke.magsa.framework;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilities {
    private Utilities() {
    }

    public static String readLine() {
        if (System.console() != null) {
            return System.console().readLine();
        } else {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                return reader.readLine();
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
    }
}
