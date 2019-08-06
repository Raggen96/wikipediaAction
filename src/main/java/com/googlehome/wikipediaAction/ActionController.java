package com.googlehome.wikipediaAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionController{

    @Autowired
    private WikipediaApp wikipediaApp;
}
