/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retro.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import retro.models.RetrospectiveModel;
import retro.services.RetroService;

/**
 *
 * @author rvelevska
 */
@RestController
@RequestMapping("/api/v1")
public class RetroController {
    
    @Autowired
    private RetroService retroService;
    
    @RequestMapping(value = "/test", method=RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(value = "/retrospective", 
                    method=RequestMethod.POST, 
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus submit(@RequestBody RetrospectiveModel model) {
        try {
            retroService.processDataToXML(model);
        } catch (IOException e) {
            return HttpStatus.BAD_REQUEST;
        }

        System.out.println("Data processed");
        
        return HttpStatus.OK;
    }
}
