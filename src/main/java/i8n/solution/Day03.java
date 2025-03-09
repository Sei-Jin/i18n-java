package i8n.solution;

import i8n.util.InputHandler;

import java.util.regex.Pattern;

public class Day03 {
    
    private static final String FILENAME = "input/day03.txt";
    private static final Pattern NUMBER = Pattern.compile("(\\d)");
    
    public static void main(String[] args) {
        final var passwords = InputHandler.readAsLines(FILENAME);
        
        var totalValidPasswords = 0;
        
        for (final var password : passwords) {
            if (isValidPassword(password)) {
                totalValidPasswords++;
            }
        }
        
        System.out.println(totalValidPasswords);
    }
    
    private static boolean isValidPassword(String password) {
        if (password.length() < 4 || password.length() > 12) {
            return false;
        }
        
        if (!NUMBER.matcher(password).find()) {
            return false;
        }
        
        if (!containsUppercaseAlphabetic(password)) {
            return false;
        }
        
        if (!containsLowercaseAlphabetic(password)) {
            return false;
        }
        
        if (!containsOutsideAscii7Bit(password)) {
            return false;
        }
        
        return true;
    }
    
    private static boolean containsUppercaseAlphabetic(String password) {
        for (int i = 0; i < password.length(); i++) {
            final var character = password.charAt(i);
            if (Character.isAlphabetic(character) && Character.isUpperCase(character)) {
                return true;
            }
        }
        
        return false;
    }
    
    private static boolean containsLowercaseAlphabetic(String password) {
        for (int i = 0; i < password.length(); i++) {
            final var character = password.charAt(i);
            if (Character.isAlphabetic(character) && Character.isLowerCase(character)) {
                return true;
            }
        }
        
        return false;
    }
    
    private static boolean containsOutsideAscii7Bit(String password) {
        for (int i = 0; i < password.length(); i++) {
            final var character = password.charAt(i);
            if ((int) character >= 128) {
                return true;
            }
        }
        
        return false;
    }
}
