package br.com.upe.ChefIA.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;

import com.amazon.ask.model.RequestEnvelope;
import com.amazon.ask.model.Response;
import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

public class AskForRecipeIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AskForRecipeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Poderia repetir, por favor, os ingredientes?";

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("AskForRecipe", speechText)
                .withReprompt(speechText)
                .build();
    }
}
