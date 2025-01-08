package decay.content;

import arc.graphics.*;
import arc.struct.*;
import decay.graphics.DecayPal;
import mindustry.type.*;

import static mindustry.content.Items.*;

public class DInterItems {
     public static Item oldmateria, tellurium, decaygraphite, timefragment, viliniteAlloy, timeEssence, reliteplate, infectum, tarite;

    public static final Seq<Item> decalinItems = new Seq<>();
    public static void load(){
        oldmateria = new Item("oldmateria", Color.valueOf("1a1a1a")){{
            hardness = 1;
            cost = 0.8f;
            healthScaling = 0.86f;
        }};
        tellurium = new Item("tellurium", Color.valueOf("735c8a")){{
            hardness = 2;
            cost = 1.5f;
        }};
        decaygraphite = new Item("decay-graphite", Color.valueOf("2d2d2d")){{
            hardness = 2;
            cost = 1.65f;
        }};
        timefragment = new Item("time-fragment", Color.valueOf("89b4b6")){{
            hardness = 3;
            cost = 1.8f;
            healthScaling = 1.24f;
        }};
        viliniteAlloy = new Item("vilinite-alloy", Color.valueOf("37861f")){{
            hardness = 4;
            cost = 2.4f;
        }};
        timeEssence = new Item("time-essence", Color.valueOf("cddaf3")){{
            frames = 2;
            frameTime = 16f;
            hardness = 5;
            cost = 3.6f;
            healthScaling = 1.6f;
        }};
        reliteplate = new Item("relite-plate", Color.valueOf("3b394d")){{
            hardness = 5;
            cost = 4.1f;
            healthScaling = 2.1f;
        }};
        infectum = new Item("infectum", DecayPal.infect){{
            hardness = 4;
            cost = 3.8f;
            healthScaling = 1.75f;
        }};
        tarite = new Item("tarite", Color.valueOf("7a5c47")){{
            hardness = 4;
            cost = 1.5f;
            healthScaling = 1.46f;
        }};
        decalinItems.addAll(
                oldmateria, tellurium, timefragment, tarite, decaygraphite, lead, silicon, graphite, viliniteAlloy, timeEssence, reliteplate, infectum
        );
    }
}