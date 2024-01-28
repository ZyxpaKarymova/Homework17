package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(login("Administrator", "12345", "12345"));
            System.out.println(login("Administrator++", "12345", "12345"));

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean login(String login, String password, String confirmPassword) {

        if (!isAlphaNumeriicOrGround(login) || (login.length() > 20)) {
            throw new WrongLoginException("Wrong Login");
        }
        if (!isAlphaNumeriicOrGround(password) || password.length() > 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Wrong password");
        }
        return true;
    }

    private static boolean isAlphaNumeriicOrGround(String string) {
        String allowedSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY0123456789_";
        for (char c : string.toCharArray()) {
            if (!allowedSymbols.contains("" + c)) {
                return false;
            }
        }
        return true;
    }

  public static boolean isASCIIchar(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 12) || (c >= 48 && c <= 57) || c == 95;
    }
}