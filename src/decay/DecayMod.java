package decay;

import mindustry.mod.*;
import decay.content.*;

public class DecayMod extends Mod{

    public DecayMod(){
    }

    @Override
    public void loadContent(){
        new DInterTeams().load();
        new DInterAttributes().load();
        new DInterItems().load();
        new DInterLiquids().load();
        new DInterStatus().load();
        new DInterWeather().load();
        new DInterUnits().load();
        new DInterBlocks().load();
        new DInterLoadouts().load();
        new DInterPlanets().load();
        new DInterSectors().load();
        new DecalinTechTree().load();
    }

}
