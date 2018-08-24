/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retro.loginmanager.models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author C50117A
 */
public class LoginModel {
    
    public static Map<String, String> usersCache;

    public LoginModel() {
        //No-op
    }
    
    private static void initializeCache() {
        usersCache = new HashMap<>();
    }
    
    private static void dumpCache() {
        usersCache.put("Stamat", "parola");
        usersCache.put("Admin", "1qaz");
        usersCache.put("Bai_Milen", "shefa");
        usersCache.put("Ivo_Topa", "topa");
        usersCache.put("Darko", "mente");
        usersCache.put("Just_Krisi", "krisi");
    }

    public static Map<String, String> getUsersCache() {
        if (usersCache == null) {
            initializeCache();
            dumpCache();
        }
        return usersCache;
    }
}
