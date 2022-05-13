package ru.babaev.Models.Response;


import com.google.gson.annotations.Expose;
import ru.babaev.Models.Account;

import java.io.IOException;
import java.util.List;

public class AccountResponse extends Response{
    @Expose
    private List<Account> accounts;

    public AccountResponse () {
    }
    public AccountResponse (List<Account> accounts, int statusCode, String description) throws IOException {
        super(statusCode, description);
        this.accounts = accounts;
    }


    public boolean isValid(){
        if (accounts != null || super.isValid()){
            return true;
        }
        return false;
    }
}