package br.com.upe.ChefIA.servlet;

import br.com.upe.ChefIA.handlers.*;
import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import br.com.upe.ChefIA.servlet.SkillServlet;

public class ChefiaServlet extends SkillServlet {

    public ChefiaServlet() {
        super((getSkill()));
    }
    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new AskForRecipeIntentHandler()
                )
                .withSkillId("amzn1.ask.skill.70ec1e59-74b6-4509-9424-879c2f976206")
                .build();
    }

}
