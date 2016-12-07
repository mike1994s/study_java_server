package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by misha on 07.12.16.
 */
public class SignUpServlet  extends HttpServlet {
    private final AccountService m_accountService;
    public SignUpServlet(AccountService accountService){
        m_accountService = accountService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (password == null){
            password = login;
        }
        m_accountService.addNewUser(new UserProfile(login));

        response.setStatus(HttpServletResponse.SC_OK);
    }
}
