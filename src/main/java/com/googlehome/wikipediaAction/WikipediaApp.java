package com.googlehome.wikipediaAction;


import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WikipediaApp extends DialogflowApp {


    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(WikipediaApp.class);

    @ForIntent("PersonIntent")
    public ActionResponse personIntent(ActionRequest request) {
        LOGGER.info("Welcome to Person Intent");
        ResponseBuilder responseBuilder = getResponseBuilder(request);
        String[] wikiTekst = Wikipedia.getRandomArticle();
        responseBuilder.add(wikiTekst[1]);
        responseBuilder.add("Who is this person?");
        LOGGER.info("Person intent end.");
        return responseBuilder.build();
    }


    @ForIntent("AnswerIntent")
    public ActionResponse answerIntent(ActionRequest request) {
        LOGGER.info("Welcome to Answer Intent");
        ResponseBuilder responseBuilder = getResponseBuilder(request);

        String answer = (String) request.getConversationData().get("person");
        String[] wikiTekst = Wikipedia.getRandomArticle();
        while (answer != wikiTekst[0]){
            responseBuilder.add("Try again");
            String answer1 = (String) request.getConversationData().get("person");

        }
        responseBuilder.add("Correct answer");


        responseBuilder.add("");

        return responseBuilder.build();
    }




}
