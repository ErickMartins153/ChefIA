package br.com.upe.ChefIA;

import br.com.upe.ChefIA.handlers.AskForRecipeIntentHandler;
import br.com.upe.ChefIA.handlers.LaunchRequestHandler;
import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class ChefiaStreamHandler extends SkillStreamHandler {
    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new AskForRecipeIntentHandler()
                )
                .withSkillId("amzn1.ask.skill.70ec1e59-74b6-4509-9424-879c2f976206")
                .build();
    }
    public ChefiaStreamHandler() {
        super((getSkill()));
    }
}
