package com.googlehome.wikipediaAction;


import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WikipediaApp extends DialogflowApp {


    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(WikipediaApp.class);
    @ForIntent("PersonIntent")
    public ActionResponse personIntent(ActionRequest request) {
        LOGGER.info("Welcome to Person Intent");
        ResponseBuilder responseBuilder = getResponseBuilder(request);
        String[] wikiTekst = wiki_test.getRandomArticle();
        responseBuilder.add(wikiTekst[1]);
        LOGGER.info("Person intent end.");
        return responseBuilder.build();
    }




}
