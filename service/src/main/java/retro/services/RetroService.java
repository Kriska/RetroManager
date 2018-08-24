/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retro.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import retro.models.RetrospectiveJsonModel;

import retro.models.RetrospectiveModel;
import retro.models.RetrospectiveSummaryModel;

/**
 *
 * @author C50117A
 */
@Component
public class RetroService {

    private final File FILE_OUTPUT_STORAGE = new File("retrospective.json");
    private final File FILE_OUTPUT_SUMMARY = new File("retrospective-summary.json");
    
    private final RetrospectiveJsonModel cache = new RetrospectiveJsonModel();
    
    @Autowired
    private RetrospectiveProcessorService retrospectiveProcessorService;
    
    public RetroService() {
        //No-op
    }
    
    public void processDataToXML(RetrospectiveModel model) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Store in cache.
        cache.addJsonModel(model);
        //Store in JSON.
        objectMapper.writeValue(FILE_OUTPUT_STORAGE, cache);
        
        //Recalculate summary
        RetrospectiveSummaryModel summaryModel = 
                retrospectiveProcessorService.processRetrospective(cache);
        
        objectMapper.writeValue(FILE_OUTPUT_SUMMARY, summaryModel);
    }
    
    public void processDataToConfluence(RetrospectiveModel model) {
        
    }
}
