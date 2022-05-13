package ru.babaev;

public class ConfigApp {
    private static final String loginBD = "postgres"; //System.getenv("loginBD");
    private static final String passwordBD = "admin"; //System.getenv("passwordBD");
    private static final String connectionStringBD = "jdbc:postgresql://localhost:5432/CMA_Accounts";//System.getenv("connectionStringBD");

    public static String getConnectionStringBD() {
        if (connectionStringBD != null)
            return connectionStringBD;
        else {
            throw new RuntimeException("Отсутствует connectionStringBD в переменной окружения");
        }
    }

    public static String getLoginBD(){
        if(loginBD != null){
            return loginBD;
        }
        else {
            throw new RuntimeException("Отсутствует loginBD в переменной окружения");
        }
    }

    public static String getPasswordBD() {
        if(passwordBD != null){
            return passwordBD;
        }
        else {
            throw new RuntimeException("Отсутствует passwordBD в переменной окружения");
        }
    }
}
