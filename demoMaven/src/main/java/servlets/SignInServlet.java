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
public class SignInServlet extends HttpServlet {
    private final AccountService m_accountService;
    public SignInServlet(AccountService accountService){
        m_accountService = accountService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        if (pass == null){
            pass = login;
        }
        UserProfile userProfile =  m_accountService.getUserByLogin(login);
        StringBuilder stringBuilder = new StringBuilder();

        if (userProfile != null && userProfile.getPass().equals(pass)){
            stringBuilder.append("Authorized: ");
            stringBuilder.append(userProfile.getLogin());
            response.getWriter().println(stringBuilder.toString());
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            stringBuilder.append("Unauthorized");
            response.getWriter().println(stringBuilder.toString());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
