package org.example.tdd6;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int metCount = getMetCriteriaCount(password);

        if (metCount <= 1) {
            return PasswordStrength.WEAK;
        }
        if (metCount == 2) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCount(String password) {
        int metCount = 0;

        if (password.length() >= 8) {
            metCount++;
        }
        if (containsNumber(password)) {
            metCount++;
        }
        if (containsUppercase(password)) {
            metCount++;
        }
        return metCount;
    }

    private static boolean containsNumber(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
}


