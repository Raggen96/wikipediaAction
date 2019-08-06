package com.googlehome.wikipediaAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ActionController{

    @Autowired
    private WikipediaApp wikipediaApp;

    @RequestMapping(method = RequestMethod.POST, value = "/personguesser", produces = "application/json")
    public @ResponseBody String guessPerson(@RequestBody String body, Map<String, String> headers) throws Exception{
        return wikipediaApp.handleRequest(body, headers).get();
    }
}
