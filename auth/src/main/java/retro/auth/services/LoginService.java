package retro.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retro.auth.models.User;
import retro.auth.models.database.DatabaseManager;

@Component
public class LoginService {

    @Autowired
    private Utils utils;

    public LoginService() {
        //No-op
    }

    public boolean authenticate(User credentials) {
        String username = credentials.getUsername();
        String encodedPassword = utils.hashPassword(credentials.getPassword());

        String dbPassword = DatabaseManager.getInstance().getAllUsers().get(username);

        if (dbPassword != null && dbPassword.equals(encodedPassword)) {
            return true;
        }
        return false;
    }
}
