package retro.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retro.auth.models.User;
import retro.auth.models.database.DatabaseManager;

import java.util.Map;

@Component
public class LoginService {

    @Autowired
    private Utils utils;
    @Autowired
    private DatabaseManager dbManager;

    public LoginService() {
        //No-op
    }

    public boolean authenticate(User credentials) {
        String username = credentials.getUsername();
        String encodedPassword = utils.hashPassword(credentials.getPassword());

        Map user = dbManager.getUser(username, encodedPassword);

        if (user.size() == 1) {
            return true;
        }
        return false;
    }
}
