package ru.babaev.Urls;


import ru.babaev.Controllers.AccountController;
import ru.babaev.Models.Response.AccountResponse;
import ru.babaev.Models.Response.Response;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getAccount")
public class AccountEndPoint extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=utf-8");
        try {
            AccountController accountController = new AccountController();
            var accounts = accountController.read(req.getParameter("number"));
            Response response = new AccountResponse(accounts, 200, "OK");
            resp.getWriter().write(response.serialize());
        }
        catch (Exception e){
            Response response = new AccountResponse(null, 403, e.getMessage());
            resp.getWriter().write(response.serialize());
        }
    }

}
