/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retro.loginmanager.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import retro.loginmanager.services.LoginService;

/**
 *
 * @author C50117A
 */
@RestController
@RequestMapping("/api/security")
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    public LoginController() {
        //No-op
    }
    
     @RequestMapping(value = "/authenticate", 
                    method=RequestMethod.POST, 
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus authenticate(@RequestBody JsonNode node) {
        String userName = null;
        String password = null;
        userName = getValue(node, "userName");
        password = getValue(node, "password");
        
        System.out.println(userName + "  " + password);
        
        if (userName != null && password != null) {
            if (loginService.authenticate(userName, password)) {
                return HttpStatus.OK;
            }
        }
        return HttpStatus.UNAUTHORIZED;
    }
    
    private String getValue(JsonNode node, String key) {
        if (node.has(key)) {
            return node.findValue(key).asText();
        }
        return null;
    }
}
