package retro.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import retro.auth.models.User;
import retro.auth.services.LoginService;

@RestController
@RequestMapping("/api/security")
public class LoginController {

    @Autowired
    LoginService loginService;

    public LoginController() {
        //No-op
    }

    @RequestMapping(value = "/authenticate",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity authenticate(@RequestBody User credentials) {
        try {
            if (credentials.getUsername() != null && credentials.getPassword() != null) {
                if (loginService.authenticate(credentials)) {
                    return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"Login successful\"}");
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\":\"Login failed\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Bad Request\"}");
        }
    }
}
