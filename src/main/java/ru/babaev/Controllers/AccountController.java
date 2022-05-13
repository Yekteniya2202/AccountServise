package ru.babaev.Controllers;

import ru.babaev.Models.Account;
import ru.babaev.Service.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AccountController {
    private String phoneRegex = "89\\d{9}";
    private final DBConnection dbClient = DBConnection.getInstance();
    Connection connection = dbClient.connection;
    public AccountController() throws SQLException, ClassNotFoundException {
    }

    public List<Account> read(String number) throws SQLException {

        if (number == null || number.isEmpty()){
            throw new NoSuchElementException("Phone number is not presented");
        }

        if (number.matches(phoneRegex) == false){
            throw new NoSuchElementException("Phone number does not match regex " + phoneRegex);
        }
        Statement stmt = connection.createStatement();

        List<Account> accounts = new ArrayList<Account>();
        String query = "SELECT card, name, lastname, balance FROM \"Account\" WHERE phone like \'" + number + "\'";

        ResultSet rs = stmt.executeQuery(query);

        while(rs.next()) {
            Account account = new Account();
            account.card = rs.getString("card");
            account.name = rs.getString("name");
            account.lastName = rs.getString("lastname");
            account.balance = rs.getBigDecimal("balance");
            accounts.add(account);
        }

        if(accounts.isEmpty()){
            throw new NoSuchElementException("Query with phone " + number + " did not return any accounts");
        }
        return accounts;
    }

    public boolean update(){
        return false;
    }
}
