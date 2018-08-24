/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retro.loginmanager.services;

import org.springframework.stereotype.Component;
import retro.loginmanager.models.LoginModel;

/**
 *
 * @author C50117A
 */
@Component
public class LoginService {
    
    public LoginService() {
    }
    
    public boolean authenticate(String userName, String password) {
        
        String value = LoginModel.getUsersCache().get(userName);
        
        if (value != null && value.equals(password)) {
            return true;
        }        
        return false;
    }    
}
