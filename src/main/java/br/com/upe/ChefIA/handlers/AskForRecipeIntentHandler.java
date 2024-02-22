package br.com.upe.ChefIA.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;

import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.RequestEnvelope;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

public class AskForRecipeIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AskForRecipeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        RequestEnvelope envelope = input.getRequestEnvelope();
        Map<String, Slot> request = null;
        if (envelope.getRequest() instanceof IntentRequest intentRequest) {
            request = intentRequest.getIntent().getSlots();
        }

        Slot slot = request.get("ingredientes");
        System.out.println(slot.getValue());

        String speechText = "Poderia repetir, por favor, os ingredientes?";

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("AskForRecipe", speechText)
                .withReprompt(speechText)
                .build();
    }
}
