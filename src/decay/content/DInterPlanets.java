package decay.content;

import arc.graphics.*;
import decay.graphics.*;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import decay.planets.*;

import static decay.content.DInterItems.*;
import static mindustry.content.Planets.*;


public class DInterPlanets {
    public static Planet
    //Present time
    decalin;
    public static void load(){
        Planets.tantros.visible = true;
         decalin = new Planet("decalin", sun, 1f, 3){{
            defaultCore = DInterBlocks.coreDry;
            sectorSeed = 3;
            generator = new DecalinPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
             cloudMeshLoader = () -> new MultiMesh(
                     new HexSkyMesh(this, 6, 0.13f, 0.12f, 5, Color.valueOf("393939").a(0.75f), 2, 0.45f, 1.13f, 0.45f),
                     new HexSkyMesh(this, 2, 0.26f, 0.15f, 5, Color.valueOf("686868").a(0.55f), 4, 0.35f, 1.35f, 0.45f)
             );
             iconColor = DecayPal.decalOutline;
            accessible = true;
            alwaysUnlocked = true;
            atmosphereColor = Color.valueOf("393939");
            startSector = 16;
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.3f;
            clearSectorOnLose = true;
            ruleSetter = r -> {
                r.loadout = ItemStack.list(oldmateria, 160);
                r.waveTeam = DInterTeams.decayed;
                r.showSpawns = true;
                r.fog = false;
                r.onlyDepositCore = false;
                Weather.WeatherEntry abuse = new Weather.WeatherEntry(DInterWeather.timeBackground);
                abuse.always = true;
                r.weather.add(abuse);
            };
             unlockedOnLand.add(DInterBlocks.coreDry);
        }};
        decalin.itemWhitelist.addAll(decalinItems);
}}